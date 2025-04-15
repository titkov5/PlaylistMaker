package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            val displayIntent = Intent(this, MainActivity::class.java)
            startActivity(displayIntent)
        }

        val agreement = findViewById<LinearLayout>(R.id.userAgreement)
        agreement.setOnClickListener {
            val uri = Uri.parse(getString(R.string.offerString))
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        val share = findViewById<LinearLayout>(R.id.shareApp)
        share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, getString(R.string.androidRazrab))
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        val contactSupport = findViewById<LinearLayout>(R.id.contactSupport)
        contactSupport.setOnClickListener {
            val message = getString(R.string.thanksAll)
            val subject = getString(R.string.messageToAll)
            val shareIntent = Intent(Intent.ACTION_SENDTO)
            shareIntent.data = Uri.parse("mailto:")
            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(R.string.myMail))
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,subject)
            startActivity(shareIntent)
        }
    }
}