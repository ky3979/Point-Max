plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.dagger.hilt.android)
  alias(libs.plugins.devtools.ksp)
}

android {
  namespace = "com.ngky.pointmax"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    applicationId = "com.pointmax.app"
    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.targetSdk.get().toInt()
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = libs.versions.jvmTarget.get()
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.3"
  }
  packaging {
    resources {
        excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  kotlinOptions {
    jvmTarget = libs.versions.jvmTarget.get()
  }
  ksp {
    arg("room.schemaLocation", "$projectDir/schemas")

    // Configure Room to generate Kotlin source code
    // This achieves proper nullability in Flow<T>
    arg("room.generateKotlin", "true")
  }
}

dependencies {

  // Android
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.lifecycle.compose)
  implementation(platform(libs.androidx.compose.bom))

  // Kotlin
  implementation(libs.kotlinx.coroutines)

  // Compose
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.fonts)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)

  // Hilt
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)

  // Room
  implementation(libs.room.runtime)
  implementation(libs.room.coroutines)
  ksp(libs.room.compiler)

  implementation(libs.timber)

  androidTestImplementation(libs.androidx.test.junit)
  androidTestImplementation(libs.androidx.test.runner)
}
