// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    // Gradle Plugins
    dependencies {
        // Open source licenses plugin
        classpath(libs.ossLicenses.plugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.aboutlibraries) apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.sentry) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
}

apply(from = rootProject.file("dependencies.gradle.kts"))
apply(from = "scripts/git-hooks/install.gradle")

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("$buildDir/**/*.kt")
        targetExclude("bin/**/*.kt")
        ktlint("0.45.1")
    }
}
