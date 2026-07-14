# AGENTS.md

Kotlin JVM library (`org.example:page-lib`, version `1.0-SNAPSHOT`) published to GitHub Pages as a static Maven repo. Single Gradle module (see `settings.gradle`). `Main.kt` has a `main()` but this is a library, not an app; the public API is `org.example.printHelloWorld()`.

## Build & test
- Build: `./gradlew build`
- Tests: `./gradlew test` (JUnit Platform; Kotlin test)
- Single test class: `./gradlew test --tests MainTest`
- Kotlin code style is `official` (`gradle.properties`); match it.
- JDK: `build.gradle` sets `jvmToolchain(23)`. CI's `setup-java` pins 17 only to run Gradle; the toolchain auto-provisions 23 via the foojay resolver (`settings.gradle`). Don't "fix" the toolchain to 17.

## Publishing (GitHub Pages)
- CI (`.github/workflows/gh-pages.yml`) on push to `main`/tags builds a static Maven layout under `repo/releases/` and deploys it via GitHub Pages.
- `BUILD.md` documents the manual `publishToMavenLocal` + copy-to-`repo/` flow.

## Gotchas
- `src/test/kotlin/MainTest.kt` currently contains build-script text (a stray `build.gradle` body), not Kotlin test code. It will not compile as a test and is not a real test. Replace it with an actual test before relying on `./gradlew test`.
- Publishing is wired via the `maven-publish` plugin in `build.gradle` (`publishing { ... }`). `publishToMavenLocal` and `build/publications/mavenJava/*` now exist; CI's `.github/workflows/gh-pages.yml` pushes to GitHub Pages on `main`/tag.
