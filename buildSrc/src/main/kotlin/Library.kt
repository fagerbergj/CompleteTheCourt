import org.gradle.api.artifacts.dsl.DependencyHandler

object Library {

    object Version {
        // build
        const val androidGradle = "7.0.3"
        const val compose = "1.0.5"
        const val kotlin = "1.5.31"
        // libs
        const val androidLifecycle = "2.3.1"
        const val androidx = "1.3.0"
        const val appcompat = "1.2.0"
        const val coreKtx = "1.3.2"
        const val kotlinLogging = "2.0.11"
        const val orika = "1.5.4"
        // testing
        const val androidTestRunner = "1.1.1"
        const val espresso = "3.2.0"
        const val junit = "5.8.1"
        const val mockk = "1.12.0"
    }

    // build
    const val androidGradle = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    // libs
    const val androidLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.androidLifecycle}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val composeActivity = "androidx.activity:activity-compose:${Version.androidx}"
    const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Version.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val googleMaterial = "com.google.android.material:material:${Version.androidx}"
    const val kotlinLogging = "io.github.microutils:kotlin-logging:${Version.kotlinLogging}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val orika = "ma.glasnost.orika:orika-core:${Version.orika}"
    // testing
    const val androidTestRunner = "com.android.support.test:runner:${Version.androidTestRunner}"
    const val androidTestRunnerExt = "androidx.test.ext:junit:${Version.androidTestRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val junit = "org.junit.jupiter:junit-jupiter:${Version.junit}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Version.kotlin}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"

    val appLibraries = listOf(
        androidLifecycle,
        appcompat,
        composeActivity,
        composeUi,
        composeMaterial,
        composeRuntime,
        composeTooling,
        coreKtx,
        googleMaterial,
        kotlinStdLib
    )

    val testLibraries = listOf(
        junit,
        mockk,
        kotlinTest
    )

    val androidTestLibraries = listOf(
        androidTestRunner,
        androidTestRunnerExt,
        espressoCore,
        junit,
        kotlinTest
    )
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}