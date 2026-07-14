# Build & Publish `page-lib`

A Kotlin JVM library published to GitHub Pages as a static Maven repository.

- Coordinates: `org.example:page-lib:1.0-SNAPSHOT`
- Published Maven repo URL: `https://shalva97.github.io/page-lib/`
- Page source: the `shalva97/page-lib` GitHub repo

## Prerequisites
- Java 17+ to run Gradle (the build auto-provisions JDK 23 via the foojay toolchain resolver in `settings.gradle`).
- Gradle wrapper (`./gradlew`).

## Build
```bash
./gradlew clean build
```

## Test
```bash
./gradlew test                 # all tests (JUnit Platform)
./gradlew test --tests MainTest
```
> `src/test/kotlin/MainTest.kt` currently holds stray build-script text, not a test. Replace it with real test code or `./gradlew test` will fail.

## Publish to GitHub Pages (automatic)
Pushing to `main` or a `v*` tag triggers `.github/workflows/gh-pages.yml`: it builds the library, assembles a static Maven layout under `repo/releases/`, and deploys it to GitHub Pages. After a successful run, consumers can use the repo URL above. No manual steps required.

## Publish to local Maven repo (manual)
```bash
./gradlew publishToMavenLocal
```
This requires the `maven-publish` plugin (already applied in `build.gradle`) and produces:
- JAR: `build/libs/page-lib-1.0-SNAPSHOT.jar`
- POM: `build/publications/mavenJava/pom-default.xml`

Consume locally by adding `mavenLocal()` to the consumer's repositories:
```gradle
repositories { mavenLocal() }
dependencies { implementation("org.example:page-lib:1.0-SNAPSHOT") }
```


## Consume from GitHub Pages
```gradle
repositories {
    maven { url "https://shalva97.github.io/page-lib/" }
}
dependencies {
    implementation("org.example:page-lib:1.0-SNAPSHOT")
}
```
