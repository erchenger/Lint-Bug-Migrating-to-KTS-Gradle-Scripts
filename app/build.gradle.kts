import com.android.build.gradle.api.ApplicationVariant

plugins {
    id("kotlin-android-extensions")
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.example.elliott.groovytokotlin"
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    applicationVariants.all(object : Action<ApplicationVariant> {
        override fun execute(variant: ApplicationVariant) {
        }
    })
}




dependencies {
    implementation(
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))
    )
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${rootProject.ext["kotlin_version"]}")
    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}
