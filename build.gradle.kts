// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Make sure to include the Android Application, Kotlin, Hilt, and KSP plugins
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}