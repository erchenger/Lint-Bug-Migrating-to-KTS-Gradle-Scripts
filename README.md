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

 # Reproduction Steps
 - Download this repo
 - Run `./gradlew lint` from command line

 <b>Expected:</b> Lint shouldn't fail
 <b>Actual:</b> Lint fails to run with the following response:

 ```
 FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:lint'.
> Lint found errors in the project; aborting build.

  Fix the issues identified by lint, or add the following to your build script to proceed with errors:
  ...
  android {
      lintOptions {
          abortOnError false
      }
  }
  ...

  Errors found:

  convert-groovy-to-kotlin-gradle/app: Error: Unexpected failure during lint analysis (this is a bug in lint or one of the libraries it depends on)

  Message: Couldn't get delegate for class
  Stack: KotlinExceptionWithAttachments:LightClassDataHolderKt.findDelegate(LightClassDataHolder.kt:100)←LightClassDataHolder$ForClass$findDataForClassOrObject$1.invoke(LightClassDataHolder.kt:40)←LightClassDataHolder$ForClass$findDataForClassOrObject$1.invoke(LightClassDataHolder.kt:34)←LightClassDataHolderImpl.findData(LightClassDataHolder.kt:83)ghtClassDataHolderImpl.findData(LightClassDataHolder.kt:79)←LightClassDataHolder$ForClass$DefaultImpls.findDataForClassOrObject(LightClassDataHolder.kt:40)←LightClassDataHolderImpl.findDataForClassOrObject(LightClassDataHolder.kt:79)←KtLightClassForSourceDeclaration.findLightClassData(KtLightClassForSourceDeclaration.kt:95)

  You can set environment variable LINT_PRINT_STACKTRACE=true to dump a full stacktrace to stdout. [LintError]

 ```
