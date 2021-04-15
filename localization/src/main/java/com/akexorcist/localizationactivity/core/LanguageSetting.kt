package com.akexorcist.localizationactivity.core

import android.content.Context
import android.os.Build
import androidx.annotation.VisibleForTesting
import java.util.*


object LanguageSetting {
    private const val PREFERENCE_LANGUAGE = "pref_language"
    private const val KEY_CURRENT_LANGUAGE = "key_language"
    private const val KEY_DEFAULT_LANGUAGE = "key_default_language"
    private const val KEY_FOLLOW_SYSTEM= "key_follow_system_language"
    private val DEFAULT_LOCALE = Locale.getDefault()
    private val defaultLocale: Locale get() {
        //Locale.getDefault()
        return DEFAULT_LOCALE
    }

    @JvmStatic
    fun setFollowSystemLanguage(context: Context) {
        setPreference(context, KEY_FOLLOW_SYSTEM, true)
    }

    @JvmStatic
    fun unsetFollowSystemLanguage(context: Context) {
        setPreference(context, KEY_FOLLOW_SYSTEM, false)
    }

    @JvmStatic
    fun setDefaultLanguage(context: Context, locale: Locale) {
        setPreference(context, KEY_DEFAULT_LANGUAGE, locale.forSaving())
    }

    @JvmStatic
    fun getDefaultLanguage(context: Context): Locale =
        if (isFollowSystem(context)) defaultLocale else getPreference(context, KEY_DEFAULT_LANGUAGE)?.let { locale: String ->
            locale.toLocale()
        } ?: run {
            defaultLocale
        }

    private fun Locale.forSaving(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toLanguageTag()
        } else {
            toString()
        }
    }

    private fun String.toLocale(): Locale? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Locale.forLanguageTag(this)
        } else {
            val info = split("_")
            when (info.size) {
                1 -> Locale(info[0])
                2 -> Locale(info[0], info[1])
                3 -> Locale(info[0], info[1], info[2])
                else -> null
            }
        }
    }

    fun isFollowSystem(context: Context) = getPreferenceBoolean(context, KEY_FOLLOW_SYSTEM, true)

    @JvmStatic
    fun setLanguage(context: Context, locale: Locale) {
        Locale.setDefault(locale)
        setPreference(context, KEY_CURRENT_LANGUAGE, locale.forSaving())
    }

    @JvmStatic
    fun getLanguage(context: Context): Locale? =
        if (isFollowSystem(context)) defaultLocale else {
            getPreference(context, KEY_CURRENT_LANGUAGE)?.let { locale: String ->
                locale.toLocale()
            } ?: run {
                null
            }
        }

    fun getLanguageWithDefault(context: Context, default: Locale): Locale {
        return getLanguage(context)?.let { locale ->
            locale
        } ?: run {
            setLanguage(context, default)
            default
        }
    }

    private fun setPreference(context: Context, key: String, value: Boolean) {
        context.getSharedPreferences(PREFERENCE_LANGUAGE, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(key, value)
            .apply()
    }

    private fun setPreference(context: Context, key: String, value: String) {
        context.getSharedPreferences(PREFERENCE_LANGUAGE, Context.MODE_PRIVATE)
            .edit()
            .putString(key, value)
            .apply()
    }

    private fun getPreference(context: Context, key: String, default: String? = null): String? =
        context.getSharedPreferences(PREFERENCE_LANGUAGE, Context.MODE_PRIVATE)
            .getString(key, default)

    private fun getPreferenceBoolean(context: Context, key: String, default: Boolean = false): Boolean =
        context.getSharedPreferences(PREFERENCE_LANGUAGE, Context.MODE_PRIVATE)
            .getBoolean(key, default)

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun clear(context: Context) {
        context.getSharedPreferences(PREFERENCE_LANGUAGE, Context.MODE_PRIVATE)
            .edit()
            .clear()
            .apply()
    }
}
