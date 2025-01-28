package com.wayoukiss.android.presentation.auth

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.wayoukiss.android.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AuthScreenTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun initialStateShowsWelcomeMessageAndSignInButton() {
        // Given
        var signInClicked = false

        // When
        composeTestRule.setContent {
            AuthScreen(
                onSignInSuccess = {},
                viewModel = FakeAuthViewModel(AuthUiState.Initial)
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(getResourceString(R.string.welcome_message))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(getResourceString(R.string.sign_in_with_google))
            .assertIsDisplayed()
            .performClick()
    }

    @Test
    fun loadingStateShowsProgressIndicator() {
        // When
        composeTestRule.setContent {
            AuthScreen(
                onSignInSuccess = {},
                viewModel = FakeAuthViewModel(AuthUiState.Loading)
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(getResourceString(R.string.signing_in))
            .assertIsDisplayed()
    }

    @Test
    fun errorStateShowsErrorMessageAndRetryButton() {
        // Given
        val errorMessage = "Network error occurred"

        // When
        composeTestRule.setContent {
            AuthScreen(
                onSignInSuccess = {},
                viewModel = FakeAuthViewModel(AuthUiState.Error(errorMessage))
            )
        }

        // Then
        composeTestRule
            .onNodeWithText(errorMessage)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(getResourceString(R.string.sign_in_with_google))
            .assertIsDisplayed()
    }

    @Test
    fun successStateTriggersCallback() {
        // Given
        var callbackTriggered = false

        // When
        composeTestRule.setContent {
            AuthScreen(
                onSignInSuccess = { callbackTriggered = true },
                viewModel = FakeAuthViewModel(AuthUiState.Success)
            )
        }

        // Then
        assert(callbackTriggered)
    }

    private fun getResourceString(resId: Int): String {
        return composeTestRule.activity.getString(resId)
    }
}
