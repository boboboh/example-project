package com.beedev.core.common

/*
*https://github.com/android10/Android-CleanArchitecture-Kotlin/blob/main/app/src/main/kotlin/com/fernandocejas/sample/core/exception/Failure.kt
*/

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}