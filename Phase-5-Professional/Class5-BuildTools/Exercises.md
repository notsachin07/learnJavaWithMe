# 🔧 Class 5: Build Tools & Packaging - Exercises

Practice setting up and using Maven and Gradle build tools!

---

## 📝 Exercise Format

Each exercise includes:
- **Objective**: What to build/configure
- **Requirements**: Specific features needed
- **Hints**: Build tool tips
- **Expected Output**: What the build should produce

---

## 🟢 Easy Exercises

### Exercise 1: Create a Maven Project
**Objective:** Set up a basic Maven project from scratch.

**Requirements:**
1. Create project structure:
   ```
   hello-maven/
   ├── pom.xml
   └── src/
       ├── main/java/com/example/App.java
       └── test/java/com/example/AppTest.java
   ```
2. Configure pom.xml with:
   - groupId: `com.example`
   - artifactId: `hello-maven`
   - version: `1.0.0`
   - Java 21 compiler settings
3. Add JUnit 5 dependency (test scope)
4. Create App.java with main method that prints "Hello Maven!"
5. Create AppTest.java with one passing test

**Commands to verify:**
```bash
mvn compile       # Should compile successfully
mvn test          # Should run 1 test, 0 failures
mvn package       # Should create JAR
```

**Hints:**
- Use maven.compiler.source and maven.compiler.target properties
- JUnit 5 groupId is `org.junit.jupiter`
- Add maven-surefire-plugin for JUnit 5 support

**Expected Output:**
```
[INFO] BUILD SUCCESS
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Building jar: target/hello-maven-1.0.0.jar
```

---

### Exercise 2: Create a Gradle Project
**Objective:** Set up a basic Gradle project from scratch.

**Requirements:**
1. Create project structure:
   ```
   hello-gradle/
   ├── build.gradle
   ├── settings.gradle
   └── src/
       ├── main/java/com/example/App.java
       └── test/java/com/example/AppTest.java
   ```
2. Configure build.gradle with:
   - Java plugin
   - Application plugin
   - Java 21 toolchain
   - Main class configuration
3. Add JUnit 5 dependency
4. Create App.java and AppTest.java (same as Exercise 1)
5. Initialize Gradle wrapper

**Commands to verify:**
```bash
./gradlew build   # Full build
./gradlew run     # Run application
./gradlew test    # Run tests
```

**Hints:**
- Use `gradle wrapper` to create wrapper files
- Use `useJUnitPlatform()` in test block
- settings.gradle needs `rootProject.name`

**Expected Output:**
```
> Task :run
Hello Gradle!

BUILD SUCCESSFUL
```

---

### Exercise 3: Add Dependencies
**Objective:** Practice adding and using external dependencies.

**Requirements:**
Create a project (Maven or Gradle) that:
1. Uses Google Guava for collections
2. Uses Jackson for JSON processing
3. Uses SLF4J + Logback for logging

**Code to implement:**
```java
public class DependencyDemo {
    private static final Logger logger = LoggerFactory.getLogger(DependencyDemo.class);
    
    public static void main(String[] args) {
        // Use Guava
        List<String> names = ImmutableList.of("Alice", "Bob", "Charlie");
        logger.info("Names: {}", names);
        
        // Use Jackson
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person("John", 30);
        String json = mapper.writeValueAsString(person);
        logger.info("JSON: {}", json);
        
        // Parse JSON back
        Person parsed = mapper.readValue(json, Person.class);
        logger.info("Parsed: {}", parsed);
    }
}

record Person(String name, int age) {}
```

**Dependencies to add:**
```
com.google.guava:guava:32.1.2-jre
com.fasterxml.jackson.core:jackson-databind:2.15.2
org.slf4j:slf4j-api:2.0.9
ch.qos.logback:logback-classic:1.4.11
```

**Hints:**
- Jackson needs default constructor or @JsonCreator for records
- Create logback.xml in src/main/resources
- Check dependency tree for conflicts

**Expected Output:**
```
[main] INFO DependencyDemo - Names: [Alice, Bob, Charlie]
[main] INFO DependencyDemo - JSON: {"name":"John","age":30}
[main] INFO DependencyDemo - Parsed: Person[name=John, age=30]
```

---

## 🟡 Medium Exercises

### Exercise 4: Create an Executable Fat JAR
**Objective:** Build a self-contained executable JAR with all dependencies.

**Requirements:**
1. Create a project with multiple dependencies:
   - HTTP client (OkHttp or Apache HttpClient)
   - JSON processor (Jackson)
   - CLI parser (Picocli or Apache Commons CLI)
2. Build a simple weather CLI app:
   ```bash
   java -jar weather-cli.jar --city "London"
   # Output: Weather in London: Cloudy, 15°C
   ```
3. Configure Maven Shade or Gradle Shadow plugin
4. Ensure JAR is executable with `java -jar`

**Implementation outline:**
```java
public class WeatherCli {
    @Option(names = {"-c", "--city"}, required = true)
    private String city;
    
    public static void main(String[] args) {
        // Parse args and fetch weather
        // (Use mock data or free API like wttr.in)
    }
    
    private String fetchWeather(String city) {
        // HTTP request to weather API
        // Parse JSON response
        // Return formatted weather
    }
}
```

**Hints:**
- Maven: Use maven-shade-plugin with ManifestResourceTransformer
- Gradle: Use shadow plugin with shadowJar task
- Test with: `java -jar target/weather-cli-1.0.0-shaded.jar`

**Expected Output:**
```bash
$ java -jar weather-cli.jar --city "Tokyo"
Weather in Tokyo: Partly Cloudy, 22°C

$ java -jar weather-cli.jar --help
Usage: weather-cli [-c=<city>]
  -c, --city=<city>   City name to get weather for
```

---

### Exercise 5: Multi-Module Maven Project
**Objective:** Create a multi-module Maven project with dependencies between modules.

**Requirements:**
1. Create structure:
   ```
   library-system/
   ├── pom.xml                    # Parent POM
   ├── library-core/              # Core domain models
   │   ├── pom.xml
   │   └── src/main/java/
   │       └── com/library/core/
   │           ├── Book.java
   │           └── Author.java
   ├── library-service/           # Business logic
   │   ├── pom.xml
   │   └── src/main/java/
   │       └── com/library/service/
   │           ├── BookService.java
   │           └── LibraryService.java
   └── library-app/               # CLI application
       ├── pom.xml
       └── src/main/java/
           └── com/library/app/
               └── LibraryApp.java
   ```

2. Module dependencies:
   - library-core: No internal dependencies
   - library-service: Depends on library-core
   - library-app: Depends on library-service

3. Parent POM should:
   - Define common properties
   - Use dependencyManagement for versions
   - Configure plugins for all modules

4. Implement basic library functionality:
   - Add/remove books
   - Search by author
   - List all books

**Build commands:**
```bash
mvn clean install        # Build all modules
mvn -pl library-app exec:java  # Run app module
```

**Hints:**
- Use `<packaging>pom</packaging>` for parent
- Reference sibling modules with `${project.version}`
- Use `<modules>` section in parent

**Expected Output:**
```
[INFO] Reactor Build Order:
[INFO] library-system
[INFO] library-core
[INFO] library-service
[INFO] library-app
[INFO] 
[INFO] BUILD SUCCESS
```

---

### Exercise 6: Gradle Multi-Project Build
**Objective:** Create the same library system using Gradle.

**Requirements:**
1. Convert Exercise 5 structure to Gradle:
   ```
   library-system/
   ├── settings.gradle
   ├── build.gradle              # Root build file
   ├── library-core/
   │   └── build.gradle
   ├── library-service/
   │   └── build.gradle
   └── library-app/
       └── build.gradle
   ```

2. Use Gradle features:
   - `subprojects {}` for common config
   - `project(':module')` for dependencies
   - Version catalogs (libs.versions.toml)

3. Add additional Gradle features:
   - Custom task to print all books
   - Jacoco for test coverage
   - Generate build report

**Build commands:**
```bash
./gradlew build                  # Build all
./gradlew :library-app:run       # Run app
./gradlew jacocoTestReport       # Coverage report
./gradlew printBooks             # Custom task
```

**Hints:**
- settings.gradle: `include 'library-core', 'library-service', 'library-app'`
- Use `api` configuration for transitive exposure
- Custom tasks use `doLast {}` block

**Expected Output:**
```
> Task :library-app:run
=== Library System ===
1. The Pragmatic Programmer - Andy Hunt
2. Clean Code - Robert Martin
3. Effective Java - Joshua Bloch

BUILD SUCCESSFUL
```

---

## 🔴 Hard Exercises

### Exercise 7: Complete CI/CD Pipeline
**Objective:** Set up a project with full CI/CD configuration.

**Requirements:**
1. Create a project with:
   - Maven or Gradle build
   - JUnit 5 tests with good coverage
   - JaCoCo coverage reporting
   - Checkstyle for code style
   - SpotBugs for static analysis

2. Create GitHub Actions workflow (`.github/workflows/ci.yml`):
   ```yaml
   name: CI Pipeline
   on: [push, pull_request]
   jobs:
     build:
       runs-on: ubuntu-latest
       steps:
         - uses: actions/checkout@v4
         - uses: actions/setup-java@v3
           with:
             distribution: 'temurin'
             java-version: '21'
         - name: Build
           run: mvn clean verify
         - name: Upload coverage
           uses: codecov/codecov-action@v3
   ```

3. Configure plugins in build file:
   - maven-checkstyle-plugin or checkstyle for Gradle
   - spotbugs-maven-plugin or spotbugs for Gradle
   - jacoco-maven-plugin or jacoco for Gradle

4. Create quality gates:
   - Minimum 80% code coverage
   - Zero checkstyle violations
   - Zero critical SpotBugs issues

**Hints:**
- Use `<executions>` to bind plugins to phases
- JaCoCo needs prepare-agent and report goals
- Use `mvn verify` to run all quality checks

**Expected Pipeline Output:**
```
✓ Checkout code
✓ Setup Java 21
✓ Build with Maven
  - Compiled 15 classes
  - Ran 25 tests (all passed)
  - Code coverage: 85%
  - Checkstyle: 0 violations
  - SpotBugs: 0 issues
✓ Upload coverage report
✓ Build succeeded!
```

---

### Exercise 8: Custom Maven Plugin
**Objective:** Create a simple Maven plugin.

**Requirements:**
1. Create a Maven plugin project:
   ```
   greeting-maven-plugin/
   ├── pom.xml
   └── src/main/java/
       └── com/example/maven/
           └── GreetingMojo.java
   ```

2. Plugin should:
   - Accept a `name` parameter
   - Accept an `outputFile` parameter (optional)
   - Print greeting to console
   - Optionally write to file

3. Create Mojo class:
   ```java
   @Mojo(name = "greet", defaultPhase = LifecyclePhase.COMPILE)
   public class GreetingMojo extends AbstractMojo {
       @Parameter(property = "greeting.name", defaultValue = "World")
       private String name;
       
       @Parameter(property = "greeting.outputFile")
       private File outputFile;
       
       public void execute() throws MojoExecutionException {
           String greeting = "Hello, " + name + "!";
           getLog().info(greeting);
           
           if (outputFile != null) {
               // Write to file
           }
       }
   }
   ```

4. Install and use in another project:
   ```xml
   <plugin>
       <groupId>com.example</groupId>
       <artifactId>greeting-maven-plugin</artifactId>
       <version>1.0.0</version>
       <configuration>
           <name>Developer</name>
       </configuration>
   </plugin>
   ```

**Commands:**
```bash
# In plugin project
mvn install

# In consumer project
mvn com.example:greeting-maven-plugin:greet -Dgreeting.name=Alice
```

**Hints:**
- Extend `AbstractMojo`
- Use `maven-plugin-api` and `maven-plugin-annotations` dependencies
- Packaging must be `maven-plugin`

**Expected Output:**
```
[INFO] --- greeting-maven-plugin:1.0.0:greet (default-cli) ---
[INFO] Hello, Alice!
```

---

### Exercise 9: Custom Gradle Plugin
**Objective:** Create a Gradle plugin with custom tasks.

**Requirements:**
1. Create plugin in buildSrc or separate project:
   ```
   buildSrc/
   └── src/main/groovy/
       └── com/example/gradle/
           ├── VersionBumpPlugin.groovy
           └── VersionBumpTask.groovy
   ```

2. Plugin should add tasks:
   - `bumpMajor` - Increment major version (1.0.0 → 2.0.0)
   - `bumpMinor` - Increment minor version (1.0.0 → 1.1.0)
   - `bumpPatch` - Increment patch version (1.0.0 → 1.0.1)
   - `printVersion` - Print current version

3. Version should be stored in `version.properties`:
   ```properties
   major=1
   minor=0
   patch=0
   ```

4. Implementation:
   ```groovy
   class VersionBumpPlugin implements Plugin<Project> {
       void apply(Project project) {
           project.extensions.create('versioning', VersioningExtension)
           
           project.tasks.register('bumpMajor', VersionBumpTask) {
               component = 'major'
           }
           // ... more tasks
       }
   }
   
   class VersionBumpTask extends DefaultTask {
       @Input
       String component
       
       @TaskAction
       void bump() {
           // Read version.properties
           // Increment appropriate component
           // Write back
       }
   }
   ```

**Usage:**
```bash
./gradlew printVersion    # Output: 1.0.0
./gradlew bumpMinor       # Increments minor
./gradlew printVersion    # Output: 1.1.0
./gradlew bumpMajor       # Increments major, resets minor/patch
./gradlew printVersion    # Output: 2.0.0
```

**Hints:**
- Use `buildSrc` directory for project-local plugins
- Plugins in buildSrc are automatically available
- Use `@Input` and `@Output` for task inputs/outputs

**Expected Output:**
```
> Task :bumpMinor
Version bumped: 1.0.0 → 1.1.0

> Task :printVersion
Current version: 1.1.0

BUILD SUCCESSFUL
```

---

## 🏆 Bonus Challenge: Full Application Build System

**Objective:** Create a complete build system for a production-ready application.

**Requirements:**

Build a REST API application with complete build infrastructure:

### 1. Project Structure
```
task-api/
├── pom.xml (or build.gradle)
├── docker/
│   ├── Dockerfile
│   └── docker-compose.yml
├── src/
│   ├── main/
│   │   ├── java/com/example/taskapi/
│   │   │   ├── TaskApiApplication.java
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   └── model/
│   │   └── resources/
│   │       ├── application.yml
│   │       └── logback-spring.xml
│   └── test/
│       └── java/com/example/taskapi/
│           ├── controller/
│           ├── service/
│           └── integration/
├── .github/
│   └── workflows/
│       └── ci-cd.yml
└── README.md
```

### 2. Build Features
- [ ] Spring Boot application setup
- [ ] H2 database for development
- [ ] PostgreSQL for production (profile-based)
- [ ] JUnit 5 + Mockito tests
- [ ] Integration tests (separate phase)
- [ ] JaCoCo coverage (min 80%)
- [ ] Checkstyle enforcement
- [ ] SpotBugs analysis
- [ ] Javadoc generation
- [ ] Fat JAR creation
- [ ] Docker image build
- [ ] Version management

### 3. Build Profiles

**Development:**
```bash
mvn spring-boot:run -Pdev
# OR
./gradlew bootRun --args='--spring.profiles.active=dev'
```

**Production:**
```bash
mvn clean package -Pprod -DskipTests
# OR
./gradlew build -Pprod -x test
```

**Docker:**
```bash
mvn spring-boot:build-image
# OR
./gradlew bootBuildImage
```

### 4. CI/CD Pipeline

```yaml
jobs:
  test:
    - Compile
    - Unit tests
    - Integration tests
    - Coverage report
    
  quality:
    - Checkstyle
    - SpotBugs
    - OWASP dependency check
    
  build:
    - Create JAR
    - Build Docker image
    - Push to registry
    
  deploy:
    - Deploy to staging
    - Run smoke tests
    - Deploy to production
```

### 5. Expected Build Output

```
[INFO] === BUILD SUMMARY ===
[INFO] 
[INFO] Compilation:     SUCCESS
[INFO] Unit Tests:      45 passed, 0 failed
[INFO] Integration:     12 passed, 0 failed
[INFO] Coverage:        87.5% (target: 80%)
[INFO] Checkstyle:      0 violations
[INFO] SpotBugs:        0 bugs found
[INFO] 
[INFO] Artifacts:
[INFO]   - task-api-1.0.0.jar (15 MB)
[INFO]   - task-api-1.0.0-javadoc.jar (2 MB)
[INFO]   - task-api:1.0.0 (Docker image)
[INFO] 
[INFO] BUILD SUCCESS
```

---

## 📊 Exercise Checklist

| Exercise | Difficulty | Build Tool | Completed |
|----------|------------|------------|-----------|
| 1. Maven Project | 🟢 Easy | Maven | ⬜ |
| 2. Gradle Project | 🟢 Easy | Gradle | ⬜ |
| 3. Dependencies | 🟢 Easy | Both | ⬜ |
| 4. Fat JAR | 🟡 Medium | Both | ⬜ |
| 5. Multi-Module Maven | 🟡 Medium | Maven | ⬜ |
| 6. Multi-Project Gradle | 🟡 Medium | Gradle | ⬜ |
| 7. CI/CD Pipeline | 🔴 Hard | Both | ⬜ |
| 8. Custom Maven Plugin | 🔴 Hard | Maven | ⬜ |
| 9. Custom Gradle Plugin | 🔴 Hard | Gradle | ⬜ |
| 🏆 Full Build System | Bonus | Both | ⬜ |

---

## 💡 Build Tool Tips

### Maven Tips
1. **Use properties** for version management
2. **Run with `-X`** for debug output
3. **Use `mvn help:effective-pom`** to see resolved POM
4. **Skip tests wisely**: `-DskipTests` vs `-Dmaven.test.skip`
5. **Use BOM (Bill of Materials)** for dependency management

### Gradle Tips
1. **Always use the wrapper** (`./gradlew`)
2. **Use `--info` or `--debug`** for verbose output
3. **Enable build cache** for faster builds
4. **Use `buildSrc`** for shared build logic
5. **Use version catalogs** for dependency management

### Common Issues
- **Dependency conflicts**: Use `mvn dependency:tree` or `./gradlew dependencies`
- **Build failures**: Check Java version compatibility
- **Test failures**: Ensure test dependencies are in test scope
- **JAR not executable**: Verify MANIFEST.MF has Main-Class

---

## 🎓 Congratulations!

You've completed all exercises for **Phase 5: Professional Java**!

You now have professional-level skills in:
- ✅ Multithreading & Concurrency
- ✅ Database connectivity (JDBC)
- ✅ Design Patterns
- ✅ Unit Testing (JUnit 5)
- ✅ Build Tools (Maven & Gradle)

**You're ready to build production-quality Java applications!** 🚀
