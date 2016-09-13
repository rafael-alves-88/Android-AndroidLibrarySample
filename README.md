# Android-CalculatorLibSample
  
## Library project
MinhaBiblioteca
  
## Calculator project to use the library
CalculadoraExterna
  
## How to generate library version
```java
./gradlew uploadArchives
```
  
## Configurations
  
### Library Project
- gradle.properties
```java
POM_ARTIFACT_ID=minhabiblioteca
VERSION_NAME=0.1
GROUP=com.example.rm40300
```

- build.gradle
```java
apply plugin: 'com.android.library'
apply plugin: 'maven'

uploadArchives {
    repositories {
        mavenDeployer {
            //repository(url: "file:///D:/gradle/rep")
            repository(url: "file:///gradle/rep")

            pom.groupId = GROUP
            pom.artifactId = POM_ARTIFACT_ID
            pom.version = VERSION_NAME
        }
    }
}

task install (dependsOn: uploadArchives)

//./gradlew install
//./gradlew uploadArchives
```

### Calculator Project
- build.gradle
```java
repositories {
    maven {
        //url "file:///D:/gradle/rep"
        url "file:///gradle/rep"
    }
}

dependencies {
    compile 'com.example.rm40300:minhabiblioteca:0.1'
}
```
