/**
 * Build Tools Demo
 * 
 * This file demonstrates a sample Java application that would be built
 * using Maven or Gradle. It includes examples of how to structure code
 * for professional builds.
 * 
 * Project Structure:
 * my-app/
 * ├── pom.xml (or build.gradle)
 * ├── src/main/java/com/example/
 * │   ├── App.java (this file)
 * │   ├── model/
 * │   ├── service/
 * │   └── util/
 * ├── src/main/resources/
 * │   └── application.properties
 * └── src/test/java/com/example/
 *     └── AppTest.java
 */

// ============================================================
// EXAMPLE APPLICATION STRUCTURE
// ============================================================

// Package declaration matches directory structure
// package com.example;

import java.io.*;
import java.util.*;
import java.time.*;
import java.nio.file.*;

/**
 * Main application class demonstrating a buildable Java project.
 */
public class BuildToolsDemo {
    
    // Application version (could be injected from build)
    private static final String VERSION = "1.0.0";
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              Build Tools Demonstration                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Demo 1: Show Maven POM structure
        demonstrateMavenPOM();
        
        // Demo 2: Show Gradle build script
        demonstrateGradleBuild();
        
        // Demo 3: Show common commands
        demonstrateBuildCommands();
        
        // Demo 4: Show JAR creation
        demonstrateJARCreation();
        
        // Demo 5: Show multi-module structure
        demonstrateMultiModule();
        
        // Demo 6: Show sample application
        runSampleApplication();
    }
    
    static void demonstrateMavenPOM() {
        System.out.println("=== Maven POM.xml Structure ===\n");
        
        String pomXml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <project xmlns="http://maven.apache.org/POM/4.0.0"
                     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                                         http://maven.apache.org/xsd/maven-4.0.0.xsd">
                
                <modelVersion>4.0.0</modelVersion>
                
                <!-- Project Coordinates -->
                <groupId>com.example</groupId>
                <artifactId>my-app</artifactId>
                <version>1.0.0</version>
                <packaging>jar</packaging>
                
                <!-- Properties -->
                <properties>
                    <maven.compiler.source>21</maven.compiler.source>
                    <maven.compiler.target>21</maven.compiler.target>
                    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                </properties>
                
                <!-- Dependencies -->
                <dependencies>
                    <!-- Google Guava -->
                    <dependency>
                        <groupId>com.google.guava</groupId>
                        <artifactId>guava</artifactId>
                        <version>32.1.2-jre</version>
                    </dependency>
                    
                    <!-- JSON Processing -->
                    <dependency>
                        <groupId>com.fasterxml.jackson.core</groupId>
                        <artifactId>jackson-databind</artifactId>
                        <version>2.15.2</version>
                    </dependency>
                    
                    <!-- JUnit 5 (Test Scope) -->
                    <dependency>
                        <groupId>org.junit.jupiter</groupId>
                        <artifactId>junit-jupiter</artifactId>
                        <version>5.10.0</version>
                        <scope>test</scope>
                    </dependency>
                </dependencies>
                
                <!-- Build Configuration -->
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
            </project>
            """;
        
        System.out.println(pomXml);
    }
    
    static void demonstrateGradleBuild() {
        System.out.println("\n=== Gradle build.gradle Structure ===\n");
        
        String buildGradle = """
            // Plugins
            plugins {
                id 'java'
                id 'application'
            }
            
            // Project Info
            group = 'com.example'
            version = '1.0.0'
            
            // Java Version
            java {
                toolchain {
                    languageVersion = JavaLanguageVersion.of(21)
                }
            }
            
            // Repository
            repositories {
                mavenCentral()
            }
            
            // Dependencies
            dependencies {
                // Compile dependencies
                implementation 'com.google.guava:guava:32.1.2-jre'
                implementation 'com.fasterxml.jackson.core:jackson-databind:2.15.2'
                
                // Test dependencies
                testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
            }
            
            // Main class for 'run' task
            application {
                mainClass = 'com.example.App'
            }
            
            // Test configuration
            test {
                useJUnitPlatform()
            }
            
            // Custom task
            task printVersion {
                doLast {
                    println "Version: ${project.version}"
                }
            }
            """;
        
        System.out.println(buildGradle);
    }
    
    static void demonstrateBuildCommands() {
        System.out.println("\n=== Common Build Commands ===\n");
        
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    Maven Commands                           │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.println("│  mvn clean              # Delete target directory           │");
        System.out.println("│  mvn compile            # Compile source code               │");
        System.out.println("│  mvn test               # Run unit tests                    │");
        System.out.println("│  mvn package            # Create JAR/WAR                    │");
        System.out.println("│  mvn install            # Install to local repository       │");
        System.out.println("│  mvn clean install      # Full clean build                  │");
        System.out.println("│  mvn dependency:tree    # Show dependency tree              │");
        System.out.println("│  mvn package -DskipTests # Package without tests            │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    Gradle Commands                          │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.println("│  ./gradlew clean        # Delete build directory            │");
        System.out.println("│  ./gradlew compileJava  # Compile source code               │");
        System.out.println("│  ./gradlew test         # Run unit tests                    │");
        System.out.println("│  ./gradlew build        # Full build with tests             │");
        System.out.println("│  ./gradlew jar          # Create JAR                        │");
        System.out.println("│  ./gradlew run          # Run application                   │");
        System.out.println("│  ./gradlew dependencies # Show dependencies                 │");
        System.out.println("│  ./gradlew tasks        # List available tasks              │");
        System.out.println("│  ./gradlew build -x test # Build without tests              │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }
    
    static void demonstrateJARCreation() {
        System.out.println("\n=== Creating Executable JARs ===\n");
        
        System.out.println("1. THIN JAR (requires external dependencies):");
        System.out.println("   mvn package");
        System.out.println("   java -cp 'target/my-app.jar:target/dependency/*' com.example.App");
        System.out.println();
        
        System.out.println("2. FAT JAR / UBER JAR (all dependencies included):");
        System.out.println();
        
        String shadePlugin = """
            Maven Shade Plugin:
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.5.0</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals><goal>shade</goal></goals>
                        <configuration>
                            <transformers>
                                <transformer implementation=
                                    "org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.example.App</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            """;
        System.out.println(shadePlugin);
        
        String shadowPlugin = """
            Gradle Shadow Plugin:
            plugins {
                id 'com.github.johnrengelman.shadow' version '8.1.1'
            }
            
            shadowJar {
                archiveBaseName.set('my-app')
                archiveClassifier.set('all')
                manifest {
                    attributes 'Main-Class': 'com.example.App'
                }
            }
            
            Build: ./gradlew shadowJar
            Run:   java -jar build/libs/my-app-all.jar
            """;
        System.out.println(shadowPlugin);
    }
    
    static void demonstrateMultiModule() {
        System.out.println("\n=== Multi-Module Project Structure ===\n");
        
        System.out.println("Project Layout:");
        System.out.println("""
            my-project/
            ├── pom.xml                    # Parent POM
            ├── core/
            │   ├── pom.xml               # Core module POM
            │   └── src/main/java/        # Core source
            ├── api/
            │   ├── pom.xml               # API module POM (depends on core)
            │   └── src/main/java/        # API source
            └── web/
                ├── pom.xml               # Web module POM (depends on api)
                └── src/main/java/        # Web source
            """);
        
        System.out.println("Parent POM:");
        String parentPom = """
            <project>
                <groupId>com.example</groupId>
                <artifactId>my-project</artifactId>
                <version>1.0.0</version>
                <packaging>pom</packaging>
                
                <modules>
                    <module>core</module>
                    <module>api</module>
                    <module>web</module>
                </modules>
                
                <dependencyManagement>
                    <dependencies>
                        <!-- Centralized version management -->
                    </dependencies>
                </dependencyManagement>
            </project>
            """;
        System.out.println(parentPom);
        
        System.out.println("Module POM (api/pom.xml):");
        String modulePom = """
            <project>
                <parent>
                    <groupId>com.example</groupId>
                    <artifactId>my-project</artifactId>
                    <version>1.0.0</version>
                </parent>
                
                <artifactId>api</artifactId>
                
                <dependencies>
                    <dependency>
                        <groupId>com.example</groupId>
                        <artifactId>core</artifactId>
                        <version>${project.version}</version>
                    </dependency>
                </dependencies>
            </project>
            """;
        System.out.println(modulePom);
        
        System.out.println("Gradle Multi-Module (settings.gradle):");
        System.out.println("""
            rootProject.name = 'my-project'
            include 'core', 'api', 'web'
            """);
    }
    
    static void runSampleApplication() {
        System.out.println("\n=== Sample Application Demo ===\n");
        
        System.out.println("This simulates what a real buildable application might do:\n");
        
        // Create sample services
        UserService userService = new UserService();
        
        // Create users
        System.out.println("Creating users...");
        User user1 = userService.createUser("john_doe", "john@example.com");
        User user2 = userService.createUser("jane_smith", "jane@example.com");
        
        // Display users
        System.out.println("\nAll users:");
        userService.getAllUsers().forEach(System.out::println);
        
        // Find user
        System.out.println("\nFinding user by username 'john_doe':");
        userService.findByUsername("john_doe")
            .ifPresentOrElse(
                u -> System.out.println("Found: " + u),
                () -> System.out.println("Not found")
            );
        
        // Application info
        System.out.println("\n=== Application Info ===");
        System.out.println("Version: " + VERSION);
        System.out.println("Java: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println("Working Dir: " + System.getProperty("user.dir"));
        
        System.out.println("\n=== Demo Complete ===\n");
        System.out.println("To build and run a real project:");
        System.out.println("1. Create pom.xml or build.gradle");
        System.out.println("2. Organize code in src/main/java");
        System.out.println("3. Add dependencies as needed");
        System.out.println("4. Run: mvn package or ./gradlew build");
        System.out.println("5. Execute: java -jar target/app.jar");
    }
}

// ============================================================
// MODEL CLASSES
// ============================================================

/**
 * User model class.
 * In a real project, this would be in src/main/java/com/example/model/User.java
 */
class User {
    private final String id;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;
    
    public User(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }
    
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    
    @Override
    public String toString() {
        return String.format("User{id='%s', username='%s', email='%s', createdAt=%s}",
            id, username, email, createdAt.toString().substring(0, 19));
    }
}

// ============================================================
// SERVICE CLASSES
// ============================================================

/**
 * User service class.
 * In a real project, this would be in src/main/java/com/example/service/UserService.java
 */
class UserService {
    private final Map<String, User> users = new HashMap<>();
    private int nextId = 1;
    
    public User createUser(String username, String email) {
        String id = "USER-" + String.format("%04d", nextId++);
        User user = new User(id, username, email);
        users.put(id, user);
        System.out.println("  Created: " + user);
        return user;
    }
    
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }
    
    public Optional<User> findByUsername(String username) {
        return users.values().stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst();
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    public void deleteUser(String id) {
        users.remove(id);
    }
}

// ============================================================
// CONFIGURATION EXAMPLE
// ============================================================

/**
 * Example of loading configuration from resources.
 * In a real project: src/main/resources/application.properties
 * 
 * application.properties:
 * app.name=My Application
 * app.version=1.0.0
 * database.url=jdbc:mysql://localhost:3306/mydb
 * database.username=root
 * database.password=secret
 */
class AppConfig {
    private static final Properties properties = new Properties();
    
    static {
        try {
            // Load from classpath
            InputStream input = AppConfig.class.getClassLoader()
                .getResourceAsStream("application.properties");
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            System.err.println("Could not load configuration: " + e.getMessage());
        }
    }
    
    public static String get(String key) {
        return properties.getProperty(key);
    }
    
    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    public static int getInt(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value == null) return defaultValue;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}

// ============================================================
// UTILITY CLASSES
// ============================================================

/**
 * String utility class.
 * In a real project: src/main/java/com/example/util/StringUtils.java
 */
class StringUtil {
    
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
    
    public static String capitalize(String str) {
        if (isBlank(str)) return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }
    
    public static String truncate(String str, int maxLength) {
        if (str == null || str.length() <= maxLength) return str;
        return str.substring(0, maxLength - 3) + "...";
    }
}

/**
 * JSON utility class (simplified - real project would use Jackson/Gson).
 * In a real project: src/main/java/com/example/util/JsonUtils.java
 */
class JsonUtil {
    
    // In real project with Jackson:
    // private static final ObjectMapper mapper = new ObjectMapper();
    
    public static String toJson(Object obj) {
        // Simplified implementation
        if (obj instanceof User user) {
            return String.format(
                "{\"id\":\"%s\",\"username\":\"%s\",\"email\":\"%s\"}",
                user.getId(), user.getUsername(), user.getEmail()
            );
        }
        return obj.toString();
    }
    
    // Real implementation with Jackson:
    // public static String toJson(Object obj) throws JsonProcessingException {
    //     return mapper.writeValueAsString(obj);
    // }
    //
    // public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
    //     return mapper.readValue(json, clazz);
    // }
}
