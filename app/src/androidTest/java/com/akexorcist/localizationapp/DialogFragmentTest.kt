package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.DialogFragmentScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DialogFragmentTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun dialogFragment() {
        Screen.onScreen<MainActivityScreen> {
            buttonDialogFragment { click() }
        }
        // Chinese
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            buttonChinese {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_CHINESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_CHINESE)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
            }
            buttonDialogFragment { click() }
        }
        // Italian
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_CHINESE)
            }
            buttonItalian {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
            }
            buttonDialogFragment { click() }
        }
        // Japanese
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
            }
            buttonJapanese {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
            }
            buttonDialogFragment { click() }
        }
        // Korean
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
            }
            buttonKorean {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_KOREAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_KOREAN)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
            }
            buttonDialogFragment { click() }
        }
        // Portuguese
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_KOREAN)
            }
            buttonPortuguese {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
            }
            buttonDialogFragment { click() }
        }
        // Thai
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
            }
            buttonThai {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_THAI)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_THAI)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_THAI)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_THAI)
            }
            buttonDialogFragment { click() }
        }
        // American
        Screen.onScreen<DialogFragmentScreen> {
            buttonOpenContent { click() }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_THAI)
            }
            buttonAmerican {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_AMERICAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_AMERICAN)
            }
            pressBack()
            pressBack()
        }
        Screen.onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
            }
        }
    }
}