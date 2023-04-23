plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
  kotlin("kapt")
  kotlin("plugin.serialization") version "1.8.10"
}

android {
  namespace = "com.mercy.skeleton"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.mercy.skeleton"
    minSdk = 28
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
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

  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  // Allow references to generated code
  kapt {
    correctErrorTypes = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

}

dependencies {

  implementation("androidx.core:core-ktx:1.8.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
  implementation("androidx.activity:activity-compose:1.5.1")

  testImplementation("unit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

  val composeBom = platform("androidx.compose:compose-bom:2023.01.00")
  implementation(composeBom)
  androidTestImplementation(composeBom)
  implementation("androidx.compose.ui:ui")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  val nav_version = "2.5.3"
  implementation("androidx.navigation:navigation-compose:$nav_version")

  val hilt_version = "2.44"
  implementation("com.google.dagger:hilt-android:$hilt_version")
  kapt("com.google.dagger:hilt-android-compiler:$hilt_version")

  val ktor_version = "2.3.0"
  implementation("io.ktor:ktor-client-core:$ktor_version")
  implementation("io.ktor:ktor-client-cio:$ktor_version")
  implementation("io.ktor:ktor-client-okhttp:$ktor_version")
  implementation("io.ktor:ktor-client-json:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
  implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")


  val coroutines_version = "1.3.9"
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

  val serialization_version = "1.5.0"
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")


}