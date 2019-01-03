# Lint Bug with KTS Build Gradle Script

While migrating to Kotlin based build.gradle scripts I stumbled upon an issues regarding running lint with my builds. For some reason the following code in my scripts will work fine when trying to run `./gradlew assemble` but fail when I run `./gradlew lint`:

```
applicationVariants.all(object : Action<ApplicationVariant> {
        override fun execute(variant: ApplicationVariant) {
        }
    })
```

I am not 100% sure yet as to why this is failing but I will be opening a Google Issue and will update this repo and the StackOverflow post I created. https://stackoverflow.com/questions/54011436/android-lint-failing-for-kotlin-based-gradle-scripts

For the time being please remove these lines if you would like your `lint` task to run properly.  
