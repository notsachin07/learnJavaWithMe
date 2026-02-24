# 🔧 Class 5: Build Tools & Packaging

Welcome to the final class of Phase 5! In this class, you'll learn how to use professional build tools (Maven and Gradle) to manage dependencies, build your projects, and create distributable packages.

---

## 📚 Table of Contents

1. [Why Build Tools?](#1-why-build-tools)
2. [Maven Overview](#2-maven-overview)
3. [Maven Project Structure](#3-maven-project-structure)
4. [The POM File](#4-the-pom-file)
5. [Maven Dependencies](#5-maven-dependencies)
6. [Maven Lifecycle](#6-maven-lifecycle)
7. [Maven Plugins](#7-maven-plugins)
8. [Gradle Overview](#8-gradle-overview)
9. [Gradle Project Structure](#9-gradle-project-structure)
10. [The Build Script](#10-the-build-script)
11. [Gradle Dependencies](#11-gradle-dependencies)
12. [Gradle Tasks](#12-gradle-tasks)
13. [Creating JAR Files](#13-creating-jar-files)
14. [Multi-Module Projects](#14-multi-module-projects)
15. [Maven vs Gradle](#15-maven-vs-gradle)
16. [Summary](#16-summary)

---

## 1. Why Build Tools?

### The Problem Without Build Tools

```
┌─────────────────────────────────────────────────────────────┐
│              Manual Build Process (❌ Don't Do This)        │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  1. Download each dependency JAR manually                  │
│  2. Add each JAR to classpath                              │
│  3. Compile: javac -cp lib/* src/*.java -d out/           │
│  4. Run tests manually                                      │
│  5. Package: jar cvf app.jar -C out/ .                     │
│  6. Repeat for every dependency update                     │
│                                                             │
│  Problems:                                                  │
│  • Manual dependency management                            │
│  • No transitive dependency resolution                     │
│  • Inconsistent builds across machines                     │
│  • No standardized project structure                       │
│  • Difficult to reproduce builds                           │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### The Solution: Build Tools

```
┌─────────────────────────────────────────────────────────────┐
│              With Build Tools (✅ Professional Way)         │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  mvn clean install                                          │
│                                                             │
│  OR                                                         │
│                                                             │
│  gradle build                                               │
│                                                             │
│  That's it! The build tool:                                │
│  ✓ Downloads all dependencies (and their dependencies)    │
│  ✓ Compiles source code                                    │
│  ✓ Runs all tests                                          │
│  ✓ Packages the application                                │
│  ✓ Generates documentation                                 │
│  ✓ Creates reproducible builds                             │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Build Tool Features

| Feature | Description |
|---------|-------------|
| **Dependency Management** | Automatically download and manage libraries |
| **Build Automation** | Compile, test, package with one command |
| **Project Structure** | Standardized directory layout |
| **Plugin Ecosystem** | Extend functionality with plugins |
| **Multi-Module Support** | Manage complex projects |
| **CI/CD Integration** | Works with Jenkins, GitHub Actions, etc. |

---

## 2. Maven Overview

### What is Maven?

Maven is a powerful build automation and project management tool based on the concept of a **Project Object Model (POM)**.

```
┌─────────────────────────────────────────────────────────────┐
│                    Maven Architecture                       │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌──────────────┐                                          │
│  │   pom.xml    │  Project configuration                   │
│  └──────┬───────┘                                          │
│         │                                                   │
│         ▼                                                   │
│  ┌──────────────┐    ┌──────────────┐                      │
│  │    Maven     │───▶│   Plugins    │  Build logic        │
│  │    Core      │    └──────────────┘                      │
│  └──────┬───────┘                                          │
│         │                                                   │
│         ▼                                                   │
│  ┌──────────────┐    ┌──────────────┐                      │
│  │  Local Repo  │◀──▶│ Remote Repos │  Dependencies       │
│  │  (~/.m2/)    │    │ (Central)    │                      │
│  └──────────────┘    └──────────────┘                      │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Installing Maven

```bash
# macOS (Homebrew)
brew install maven

# Ubuntu/Debian
sudo apt install maven

# Windows (Chocolatey)
choco install maven

# Verify installation
mvn --version
# Apache Maven 3.9.5
# Maven home: /usr/local/Cellar/maven/3.9.5/libexec
# Java version: 21.0.1
```

### Creating a Maven Project

```bash
# Using archetype (project template)
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=my-app \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false

# This creates:
my-app/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── App.java
    └── test/
        └── java/
            └── com/
                └── example/
                    └── AppTest.java
```

---

## 3. Maven Project Structure

### Standard Directory Layout

```
my-project/
├── pom.xml                          # Project configuration
├── src/
│   ├── main/
│   │   ├── java/                    # Application source code
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── App.java
│   │   │           ├── model/
│   │   │           ├── service/
│   │   │           └── util/
│   │   └── resources/               # Configuration files
│   │       ├── application.properties
│   │       └── logback.xml
│   └── test/
│       ├── java/                    # Test source code
│       │   └── com/
│       │       └── example/
│       │           ├── AppTest.java
│       │           └── service/
│       └── resources/               # Test configuration
│           └── test-data.json
├── target/                          # Build output (generated)
│   ├── classes/                     # Compiled classes
│   ├── test-classes/                # Compiled tests
│   └── my-project-1.0.jar          # Packaged JAR
└── .mvn/                            # Maven wrapper (optional)
    └── wrapper/
        └── maven-wrapper.properties
```

### Why This Structure?

- **Convention over Configuration**: No need to specify where source files are
- **Separation of Concerns**: Main code vs test code, Java vs resources
- **IDE Compatible**: All major IDEs recognize this structure
- **CI/CD Friendly**: Standard structure works with build servers

---

## 4. The POM File

### Basic POM Structure

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <!-- POM model version (always 4.0.0) -->
    <modelVersion>4.0.0</modelVersion>
    
    <!-- Project coordinates (GAV) -->
    <groupId>com.example</groupId>      <!-- Organization/group -->
    <artifactId>my-app</artifactId>     <!-- Project name -->
    <version>1.0.0</version>            <!-- Version -->
    <packaging>jar</packaging>          <!-- jar, war, pom, etc. -->
    
    <!-- Project information -->
    <name>My Application</name>
    <description>A sample Java application</description>
    <url>https://github.com/example/my-app</url>
    
    <!-- Properties (variables) -->
    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.10.0</junit.version>
    </properties>
    
    <!-- Dependencies -->
    <dependencies>
        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <!-- Build configuration -->
    <build>
        <plugins>
            <!-- Compiler plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
</project>
```

### Understanding GAV Coordinates

```
┌─────────────────────────────────────────────────────────────┐
│                    GAV Coordinates                          │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  G - groupId:    com.example                                │
│      └── Organization or project group                     │
│      └── Usually reverse domain name                       │
│                                                             │
│  A - artifactId: my-app                                     │
│      └── Project/module name                               │
│      └── Unique within groupId                             │
│                                                             │
│  V - version:    1.0.0                                      │
│      └── Project version                                   │
│      └── SNAPSHOT = development version                    │
│                                                             │
│  Example: com.google.guava:guava:32.1.2-jre                │
│           ^^^^^^^^^^^^^^^^ ^^^^^ ^^^^^^^^^^^                │
│           groupId       artifactId  version                │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Version Numbering

```
Semantic Versioning: MAJOR.MINOR.PATCH

1.0.0     - Initial release
1.0.1     - Bug fix
1.1.0     - New feature (backward compatible)
2.0.0     - Breaking changes

Special versions:
1.0.0-SNAPSHOT  - Development version (not stable)
1.0.0-RC1       - Release candidate
1.0.0-beta      - Beta release
```

---

## 5. Maven Dependencies

### Adding Dependencies

```xml
<dependencies>
    <!-- Compile-time dependency (default scope) -->
    <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>32.1.2-jre</version>
    </dependency>
    
    <!-- Test dependency -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Runtime-only dependency -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Provided (available at compile, not packaged) -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Dependency Scopes

| Scope | Compile | Test | Runtime | Packaged |
|-------|---------|------|---------|----------|
| **compile** (default) | ✅ | ✅ | ✅ | ✅ |
| **test** | ❌ | ✅ | ❌ | ❌ |
| **runtime** | ❌ | ✅ | ✅ | ✅ |
| **provided** | ✅ | ✅ | ❌ | ❌ |
| **system** | ✅ | ✅ | ❌ | ❌ |

### Transitive Dependencies

```
┌─────────────────────────────────────────────────────────────┐
│               Transitive Dependency Resolution              │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  Your pom.xml declares:                                    │
│  └── spring-boot-starter-web                               │
│                                                             │
│  Maven automatically resolves:                             │
│  └── spring-boot-starter-web                               │
│      ├── spring-boot-starter                               │
│      │   ├── spring-boot                                   │
│      │   ├── spring-boot-autoconfigure                     │
│      │   └── spring-core                                   │
│      ├── spring-web                                        │
│      ├── spring-webmvc                                     │
│      └── spring-boot-starter-tomcat                        │
│          ├── tomcat-embed-core                             │
│          └── tomcat-embed-websocket                        │
│                                                             │
│  Total: 50+ JARs from 1 dependency declaration!           │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Viewing Dependencies

```bash
# View dependency tree
mvn dependency:tree

# Output:
[INFO] com.example:my-app:jar:1.0.0
[INFO] +- com.google.guava:guava:jar:32.1.2-jre:compile
[INFO] |  +- com.google.guava:failureaccess:jar:1.0.1:compile
[INFO] |  +- com.google.guava:listenablefuture:jar:9999.0-empty-to-avoid-conflict-with-guava:compile
[INFO] |  \- com.google.errorprone:error_prone_annotations:jar:2.18.0:compile
[INFO] \- org.junit.jupiter:junit-jupiter:jar:5.10.0:test
[INFO]    +- org.junit.jupiter:junit-jupiter-api:jar:5.10.0:test
[INFO]    \- org.junit.jupiter:junit-jupiter-engine:jar:5.10.0:test
```

### Excluding Dependencies

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>6.0.11</version>
    <exclusions>
        <!-- Exclude commons-logging, we use SLF4J -->
        <exclusion>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

### Finding Dependencies

Search at [Maven Central](https://search.maven.org/) or [mvnrepository.com](https://mvnrepository.com/)

Popular dependencies:
```xml
<!-- JSON Processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>

<!-- Logging -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.0.9</version>
</dependency>

<!-- HTTP Client -->
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.11.0</version>
</dependency>

<!-- Database Connection Pool -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>
```

---

## 6. Maven Lifecycle

### Build Lifecycle Phases

```
┌─────────────────────────────────────────────────────────────┐
│                 Maven Default Lifecycle                     │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  validate ──▶ compile ──▶ test ──▶ package ──▶ verify      │
│      │                                              │       │
│      │                                              ▼       │
│      │                                          install     │
│      │                                              │       │
│      │                                              ▼       │
│      └──────────────────────────────────────────▶ deploy   │
│                                                             │
│  Each phase executes all previous phases!                  │
│                                                             │
│  mvn package = validate + compile + test + package         │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Common Maven Commands

```bash
# Validate project structure
mvn validate

# Compile source code
mvn compile

# Run tests
mvn test

# Package into JAR/WAR
mvn package

# Install to local repository (~/.m2/)
mvn install

# Deploy to remote repository
mvn deploy

# Clean build output
mvn clean

# Common combinations
mvn clean install        # Clean, then full build + install
mvn clean package        # Clean, then build + package
mvn clean test           # Clean, then compile + test

# Skip tests
mvn package -DskipTests           # Skip test execution
mvn package -Dmaven.test.skip    # Skip compilation and execution

# Run specific test
mvn test -Dtest=CalculatorTest
mvn test -Dtest=CalculatorTest#testAdd
```

### Lifecycle Phases Explained

| Phase | Description |
|-------|-------------|
| `validate` | Validate project is correct |
| `compile` | Compile source code |
| `test` | Run unit tests |
| `package` | Package compiled code (JAR/WAR) |
| `verify` | Run integration tests |
| `install` | Install package to local repo |
| `deploy` | Deploy to remote repository |
| `clean` | Delete target directory |
| `site` | Generate project documentation |

---

## 7. Maven Plugins

### Essential Plugins

```xml
<build>
    <plugins>
        <!-- Compiler Plugin -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>21</source>
                <target>21</target>
            </configuration>
        </plugin>
        
        <!-- Surefire Plugin (unit tests) -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
        
        <!-- JAR Plugin -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>com.example.App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
        
        <!-- Shade Plugin (fat JAR with dependencies) -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.5.0</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                    <configuration>
                        <transformers>
                            <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                <mainClass>com.example.App</mainClass>
                            </transformer>
                        </transformers>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

### Running Plugin Goals

```bash
# Format: mvn plugin:goal

# Compile
mvn compiler:compile

# Run tests
mvn surefire:test

# Generate site
mvn site:site

# Dependency analysis
mvn dependency:analyze
mvn dependency:tree

# Display effective POM (with inherited settings)
mvn help:effective-pom

# Display plugin help
mvn help:describe -Dplugin=compiler
```

---

## 8. Gradle Overview

### What is Gradle?

Gradle is a modern build tool that uses a Groovy or Kotlin DSL instead of XML.

```
┌─────────────────────────────────────────────────────────────┐
│                    Gradle Architecture                      │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌────────────────┐                                        │
│  │ build.gradle   │  Build script (Groovy/Kotlin)         │
│  └───────┬────────┘                                        │
│          │                                                  │
│          ▼                                                  │
│  ┌────────────────┐    ┌────────────────┐                  │
│  │  Gradle Core   │───▶│    Plugins     │                  │
│  └───────┬────────┘    └────────────────┘                  │
│          │                                                  │
│          ▼                                                  │
│  ┌────────────────┐    ┌────────────────┐                  │
│  │  Gradle Cache  │◀──▶│   Repositories │                  │
│  │  (~/.gradle/)  │    │   (Central)    │                  │
│  └────────────────┘    └────────────────┘                  │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Installing Gradle

```bash
# macOS (Homebrew)
brew install gradle

# Ubuntu/Debian (SDKMAN recommended)
sdk install gradle

# Windows (Chocolatey)
choco install gradle

# Verify installation
gradle --version
# Gradle 8.4
# Build time: 2023-10-04
# Kotlin: 1.9.10
# JVM: 21.0.1
```

### Creating a Gradle Project

```bash
# Initialize new project
gradle init

# Interactive prompts:
# Select type of project: application
# Select implementation language: Java
# Select build script DSL: Groovy (or Kotlin)
# Select test framework: JUnit Jupiter

# Or use specific type
gradle init --type java-application
```

---

## 9. Gradle Project Structure

### Standard Directory Layout

```
my-project/
├── build.gradle                 # Build configuration
├── settings.gradle              # Project settings
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew                      # Gradle wrapper (Unix)
├── gradlew.bat                  # Gradle wrapper (Windows)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── App.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── AppTest.java
│       └── resources/
└── build/                       # Build output (generated)
    ├── classes/
    ├── libs/
    └── reports/
```

### The Gradle Wrapper

```bash
# Always use the wrapper (./gradlew) instead of global gradle
# This ensures consistent Gradle version across all environments

# Unix/macOS
./gradlew build

# Windows
gradlew.bat build

# Generate/update wrapper
gradle wrapper --gradle-version 8.4
```

---

## 10. The Build Script

### Basic build.gradle (Groovy DSL)

```groovy
// Apply plugins
plugins {
    id 'java'                    // Java support
    id 'application'             // Application support
}

// Project information
group = 'com.example'
version = '1.0.0'

// Java version
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

// Repository for dependencies
repositories {
    mavenCentral()
}

// Dependencies
dependencies {
    // Compile dependency
    implementation 'com.google.guava:guava:32.1.2-jre'
    
    // Test dependency
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
    
    // Runtime only
    runtimeOnly 'mysql:mysql-connector-java:8.0.33'
}

// Application main class
application {
    mainClass = 'com.example.App'
}

// Test configuration
test {
    useJUnitPlatform()
}
```

### build.gradle.kts (Kotlin DSL)

```kotlin
plugins {
    java
    application
}

group = "com.example"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:32.1.2-jre")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    runtimeOnly("mysql:mysql-connector-java:8.0.33")
}

application {
    mainClass.set("com.example.App")
}

tasks.test {
    useJUnitPlatform()
}
```

### settings.gradle

```groovy
// Project name
rootProject.name = 'my-app'

// For multi-module projects
// include 'core', 'web', 'api'
```

---

## 11. Gradle Dependencies

### Dependency Configurations

```groovy
dependencies {
    // Compile + Runtime (most common)
    implementation 'group:artifact:version'
    
    // Compile only (not in runtime classpath)
    compileOnly 'group:artifact:version'
    
    // Runtime only (not in compile classpath)
    runtimeOnly 'group:artifact:version'
    
    // Test compile + runtime
    testImplementation 'group:artifact:version'
    
    // Test runtime only
    testRuntimeOnly 'group:artifact:version'
    
    // API (exposed to consumers in library projects)
    api 'group:artifact:version'
}
```

### Configuration Comparison

| Gradle | Maven | Description |
|--------|-------|-------------|
| `implementation` | `compile` | Standard dependency |
| `api` | `compile` | Exposed to consumers |
| `compileOnly` | `provided` | Compile only |
| `runtimeOnly` | `runtime` | Runtime only |
| `testImplementation` | `test` | Test dependency |

### Dependency Declaration Styles

```groovy
dependencies {
    // String notation (most common)
    implementation 'com.google.guava:guava:32.1.2-jre'
    
    // Map notation
    implementation group: 'com.google.guava', name: 'guava', version: '32.1.2-jre'
    
    // With exclusions
    implementation('org.springframework:spring-core:6.0.11') {
        exclude group: 'commons-logging', module: 'commons-logging'
    }
    
    // Version catalog (recommended for large projects)
    implementation libs.guava
    
    // Project dependency (multi-module)
    implementation project(':core')
    
    // File dependency
    implementation files('libs/custom.jar')
    implementation fileTree(dir: 'libs', include: ['*.jar'])
}
```

### Version Catalogs (libs.versions.toml)

```toml
# gradle/libs.versions.toml

[versions]
guava = "32.1.2-jre"
junit = "5.10.0"
jackson = "2.15.2"

[libraries]
guava = { module = "com.google.guava:guava", version.ref = "guava" }
junit-jupiter = { module = "org.junit.jupiter:junit-jupiter", version.ref = "junit" }
jackson-databind = { module = "com.fasterxml.jackson.core:jackson-databind", version.ref = "jackson" }

[bundles]
jackson = ["jackson-databind", "jackson-core", "jackson-annotations"]

[plugins]
shadow = { id = "com.github.johnrengelman.shadow", version = "8.1.1" }
```

```groovy
// build.gradle
dependencies {
    implementation libs.guava
    implementation libs.bundles.jackson
    testImplementation libs.junit.jupiter
}
```

---

## 12. Gradle Tasks

### Common Tasks

```bash
# Build project
./gradlew build

# Clean build directory
./gradlew clean

# Compile source
./gradlew compileJava

# Run tests
./gradlew test

# Run application
./gradlew run

# Create JAR
./gradlew jar

# List all tasks
./gradlew tasks

# Task with details
./gradlew tasks --all

# Run specific test
./gradlew test --tests "CalculatorTest"
./gradlew test --tests "*Test"

# Continuous build (rebuild on changes)
./gradlew build --continuous

# Parallel execution
./gradlew build --parallel
```

### Custom Tasks

```groovy
// Simple task
task hello {
    doLast {
        println 'Hello, Gradle!'
    }
}

// Task with configuration
task copyDocs(type: Copy) {
    from 'src/docs'
    into 'build/docs'
}

// Task with dependencies
task buildAll {
    dependsOn 'clean', 'build', 'test'
    doLast {
        println 'Build complete!'
    }
}

// Task ordering
task taskB {
    mustRunAfter 'taskA'
}

// Typed task
task generateReport(type: Exec) {
    commandLine 'python', 'generate_report.py'
}
```

### Running Tasks

```bash
# Run custom task
./gradlew hello

# Run multiple tasks
./gradlew clean build test

# Skip task
./gradlew build -x test

# Run with info logging
./gradlew build --info

# Run with debug logging
./gradlew build --debug
```

---

## 13. Creating JAR Files

### Simple JAR (Maven)

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>com.example.App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

```bash
mvn package
java -jar target/my-app-1.0.0.jar
# Error: Missing dependencies!
```

### Fat JAR / Uber JAR (Maven Shade)

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.5.0</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
            <configuration>
                <transformers>
                    <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                        <mainClass>com.example.App</mainClass>
                    </transformer>
                </transformers>
                <createDependencyReducedPom>false</createDependencyReducedPom>
            </configuration>
        </execution>
    </executions>
</plugin>
```

### Fat JAR (Gradle Shadow)

```groovy
plugins {
    id 'java'
    id 'application'
    id 'com.github.johnrengelman.shadow' version '8.1.1'
}

application {
    mainClass = 'com.example.App'
}

// Build fat JAR
// ./gradlew shadowJar
// Output: build/libs/my-app-1.0.0-all.jar
```

### JAR Types Comparison

```
┌─────────────────────────────────────────────────────────────┐
│                      JAR Types                              │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  Thin JAR (default):                                       │
│  ┌─────────────────┐                                       │
│  │   my-app.jar    │  Just your code                       │
│  │   (50 KB)       │  Requires dependencies on classpath   │
│  └─────────────────┘                                       │
│                                                             │
│  Fat/Uber JAR:                                              │
│  ┌─────────────────┐                                       │
│  │   my-app.jar    │  Your code + ALL dependencies        │
│  │   (25 MB)       │  Self-contained, portable            │
│  └─────────────────┘                                       │
│                                                             │
│  Executable JAR:                                            │
│  ┌─────────────────┐                                       │
│  │   my-app.jar    │  Has MANIFEST.MF with Main-Class     │
│  │                 │  Run with: java -jar my-app.jar      │
│  └─────────────────┘                                       │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Running JAR Files

```bash
# Run executable JAR
java -jar my-app.jar

# Run with main class specified
java -cp my-app.jar com.example.App

# Run with additional classpath
java -cp "my-app.jar:lib/*" com.example.App

# Run with JVM options
java -Xmx512m -jar my-app.jar

# Run with system properties
java -Dconfig.file=prod.properties -jar my-app.jar
```

---

## 14. Multi-Module Projects

### Maven Multi-Module

```
my-project/
├── pom.xml                    # Parent POM
├── core/
│   ├── pom.xml
│   └── src/
├── api/
│   ├── pom.xml
│   └── src/
└── web/
    ├── pom.xml
    └── src/
```

**Parent pom.xml:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.example</groupId>
    <artifactId>my-project</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging>
    
    <!-- Modules -->
    <modules>
        <module>core</module>
        <module>api</module>
        <module>web</module>
    </modules>
    
    <!-- Shared properties -->
    <properties>
        <java.version>21</java.version>
    </properties>
    
    <!-- Dependency management (versions for all modules) -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.junit.jupiter</groupId>
                <artifactId>junit-jupiter</artifactId>
                <version>5.10.0</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

**Module pom.xml (core/pom.xml):**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>com.example</groupId>
        <artifactId>my-project</artifactId>
        <version>1.0.0</version>
    </parent>
    
    <artifactId>core</artifactId>
    
    <dependencies>
        <!-- No version needed - inherited from parent -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

**Module with dependency on sibling (api/pom.xml):**
```xml
<dependencies>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>core</artifactId>
        <version>${project.version}</version>
    </dependency>
</dependencies>
```

### Gradle Multi-Module

**settings.gradle:**
```groovy
rootProject.name = 'my-project'

include 'core'
include 'api'
include 'web'
```

**Root build.gradle:**
```groovy
plugins {
    id 'java'
}

// Configuration for all projects
allprojects {
    group = 'com.example'
    version = '1.0.0'
    
    repositories {
        mavenCentral()
    }
}

// Configuration for subprojects only
subprojects {
    apply plugin: 'java'
    
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }
    
    dependencies {
        testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
    }
    
    test {
        useJUnitPlatform()
    }
}
```

**Submodule build.gradle (api/build.gradle):**
```groovy
dependencies {
    implementation project(':core')
}
```

### Building Multi-Module Projects

```bash
# Maven - build all modules
mvn clean install

# Maven - build specific module
mvn clean install -pl core

# Maven - build module with dependencies
mvn clean install -pl api -am

# Gradle - build all
./gradlew build

# Gradle - build specific module
./gradlew :core:build
./gradlew :api:build
```

---

## 15. Maven vs Gradle

### Comparison

| Feature | Maven | Gradle |
|---------|-------|--------|
| **Configuration** | XML (pom.xml) | Groovy/Kotlin DSL |
| **Readability** | Verbose | Concise |
| **Flexibility** | Convention-based | Highly customizable |
| **Build Speed** | Good | Faster (incremental) |
| **Learning Curve** | Easier | Steeper |
| **IDE Support** | Excellent | Excellent |
| **Community** | Larger | Growing |
| **Android** | Not used | Standard |

### Performance Comparison

```
┌─────────────────────────────────────────────────────────────┐
│                  Build Time Comparison                      │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  Clean Build (first time):                                 │
│  Maven:  ████████████████████ 45s                          │
│  Gradle: ████████████████     40s                          │
│                                                             │
│  Incremental Build (small change):                         │
│  Maven:  ████████████████████ 45s (no caching)             │
│  Gradle: ████                  8s (incremental)            │
│                                                             │
│  No Changes:                                                │
│  Maven:  ████████████         25s                          │
│  Gradle: █                     2s (up-to-date)             │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### When to Use Which?

**Use Maven when:**
- Working on enterprise/corporate projects
- Team prefers convention over configuration
- Need extensive documentation and community support
- Simpler build requirements

**Use Gradle when:**
- Building Android applications
- Need highly customized builds
- Performance is critical
- Working with multi-language projects
- Modern greenfield projects

### Migrating Between Tools

```bash
# Generate Gradle from Maven
gradle init --type pom

# This creates build.gradle from pom.xml
```

---

## 16. Summary

### Key Takeaways

```
┌─────────────────────────────────────────────────────────────┐
│               Build Tools Summary                           │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  📦 Dependency Management:                                  │
│     • Declare dependencies in pom.xml or build.gradle      │
│     • Build tool downloads and manages versions            │
│     • Transitive dependencies handled automatically        │
│                                                             │
│  🔧 Build Automation:                                       │
│     • Maven: mvn clean install                             │
│     • Gradle: ./gradlew build                              │
│     • Standardized project structure                       │
│                                                             │
│  📋 Project Structure:                                      │
│     • src/main/java - source code                          │
│     • src/main/resources - config files                    │
│     • src/test/java - test code                            │
│     • target/ or build/ - output                           │
│                                                             │
│  📦 Packaging:                                              │
│     • JAR - Java Archive (library or app)                  │
│     • WAR - Web Archive (web app)                          │
│     • Fat JAR - includes all dependencies                  │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Quick Reference

**Maven:**
```bash
mvn clean                  # Clean
mvn compile               # Compile
mvn test                  # Test
mvn package               # Create JAR
mvn install               # Install to local repo
mvn dependency:tree       # Show dependencies
```

**Gradle:**
```bash
./gradlew clean           # Clean
./gradlew compileJava     # Compile
./gradlew test            # Test
./gradlew build           # Build + test
./gradlew jar             # Create JAR
./gradlew dependencies    # Show dependencies
```

### Minimum pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0.0</version>
    
    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>
</project>
```

### Minimum build.gradle

```groovy
plugins {
    id 'java'
}

group = 'com.example'
version = '1.0.0'

repositories {
    mavenCentral()
}
```

---

## 🔗 Resources

- [Maven Documentation](https://maven.apache.org/guides/)
- [Gradle User Guide](https://docs.gradle.org/current/userguide/userguide.html)
- [Maven Central Repository](https://search.maven.org/)
- [Gradle Plugin Portal](https://plugins.gradle.org/)

---

## 🎓 Congratulations!

You've completed **Phase 5: Professional Java**! You now know:

1. ✅ Multithreading & Concurrency
2. ✅ Database connectivity with JDBC
3. ✅ Design Patterns
4. ✅ Unit Testing with JUnit
5. ✅ Build Tools (Maven & Gradle)

You're now ready to build professional Java applications! 🚀

---

**Keep learning, keep building!** 🔧
