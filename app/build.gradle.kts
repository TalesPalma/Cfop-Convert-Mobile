plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp) // Processador de código ksp (keep updating)
    alias(libs.plugins.hilt) // Injetor de dependências do Hilt
}

android {
    namespace = "com.talespalma.cfopconvertmobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.talespalma.cfopconvertmobile"
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
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
    buildFeatures {
        compose = true
    }


    //Criar o schemas do bd na location do projeto.
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }

}

dependencies {

    //Depedencias do Android Compose Navigation
    implementation(libs.androidx.navigation.compose)

    // Depedencias do Android room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //Depedencias do Android Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    //Depedencias do kotlin
    implementation(libs.kotlinx.serialization.json)

    //Depedencias padrão do kotlin com o android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}