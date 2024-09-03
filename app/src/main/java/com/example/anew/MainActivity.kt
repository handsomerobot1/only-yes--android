package com.example.anew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var buttonYes: Button
    lateinit var buttonNo: Button
    lateinit var rootLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        buttonYes = findViewById(R.id.buttonYes)
        buttonNo = findViewById(R.id.buttonNo)
        rootLayout = findViewById(R.id.rootLayout) // Ensure this matches the ID in XML

        // Set click listener for "Yes" button
        buttonYes.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        // Set click listener for "No" button
        buttonNo.setOnClickListener {
            moveButtonNo(buttonNo, rootLayout)
        }
    }

    private fun moveButtonNo(button: Button, rootLayout: RelativeLayout) {
        // Wait for layout to be fully drawn before measuring dimensions
        rootLayout.post {
            // Get layout dimensions
            val layoutWidth = rootLayout.width
            val layoutHeight = rootLayout.height

            // Button dimensions
            val buttonWidth = button.width
            val buttonHeight = button.height

            // Generate random position within layout bounds
            val random = Random(System.currentTimeMillis())
            val x = random.nextInt(layoutWidth - buttonWidth)
            val y = random.nextInt(layoutHeight - buttonHeight)

            // Set button position
            val params = button.layoutParams as RelativeLayout.LayoutParams
            params.leftMargin = x
            params.topMargin = y
            button.layoutParams = params
        }
    }
}
