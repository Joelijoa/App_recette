plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.kotlin.android)

}

android {
    namespace = "ma.ismagi.ci2.apptest"
    compileSdk = 35

    defaultConfig {
        applicationId = "ma.ismagi.ci2.apptest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.core.ktx)
    implementation(libs.firebase.database)
    implementation (libs.firebase.firestore)
    implementation(libs.litert.support.api)
    testImplementation(libs.junit)
    implementation (libs.github.glide)
    annotationProcessor (libs.compiler)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.play.services.auth)
    implementation (libs.play.services.base)
    implementation(libs.firebase.storage)
}
apply(plugin = "com.google.gms.google-services")