package com.app.orca

class AgentEngine {

    fun process(input: String): String {
        val cmd = input.lowercase()

        return when {
            "youtube" in cmd -> "OPEN_YOUTUBE"
            "google" in cmd -> "OPEN_GOOGLE"
            "camera" in cmd -> "OPEN_CAMERA"
            else -> "UNKNOWN"
        }
    }
}
