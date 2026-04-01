package com.app.orca

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore

class ActionExecutor(private val context: Context) {

    fun execute(action: String): String {
        return when (action) {
            "OPEN_YOUTUBE" -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"))
                context.startActivity(intent)
                "Opening YouTube..."
            }

            "OPEN_GOOGLE" -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
                context.startActivity(intent)
                "Opening Google..."
            }

            "OPEN_CAMERA" -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                context.startActivity(intent)
                "Opening Camera..."
            }

            else -> "I don't understand yet."
        }
    }
}
