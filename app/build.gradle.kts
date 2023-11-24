plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")


}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "kg.ticode.zukhridin_safarbek"
            artifactId = "phone_masker"
            version = "1.0.0"

        }
    }
}
android {
    namespace = "kg.ticode.zukhridin_safarbek.phonemasker"
    compileSdk = 34

    defaultConfig {
        applicationId = "kg.ticode.zukhridin_safarbek.phonemasker"
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}