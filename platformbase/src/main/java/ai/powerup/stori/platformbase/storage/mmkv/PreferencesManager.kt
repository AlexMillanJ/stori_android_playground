package ai.powerup.stori.platformbase.storage.mmkv

class PreferencesManager private constructor() {

    companion object {

        /**
         * APP SCOPE CONSTANTS
         */

        const val PREF_KEY_TYPE_USER = "PREF_KEY_TYPE_USER"
        const val PREF_KEY_USER_ID = "PREF_KEY_USER_ID"

        /**
         * INIT FUNCTIONS
         */

        @Volatile
        private var preferencesManager: PreferencesManager? = null

        fun getInstance(): PreferencesManager {
            return if (preferencesManager == null) {
                synchronized(PreferencesManager::class.java) {
                    return if (preferencesManager == null) {
                        preferencesManager = PreferencesManager()
                        preferencesManager!!
                    } else {
                        preferencesManager!!
                    }
                }
            } else {
                preferencesManager!!
            }
        }

        operator fun invoke(): PreferencesManager {
            return PreferencesManager()
        }
    }

}

inline fun <reified T> PreferencesManager.update(key: String, value: T) {
    when (T::class) {
        else -> throw UnsupportedOperationException("Type ${T::class} not yet supported")
    }
}

inline fun <reified T> PreferencesManager.retrieve(key: String, defaultValue: T? = null): T =
    when (T::class) {
        else -> throw UnsupportedOperationException("Type ${T::class} not yet supported")
    }

fun PreferencesManager.remove(key: String) {}