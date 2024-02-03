package com.example.contactappwithinternet2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactappwithinternet2.utils.NetworkStatusValidator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkStatusValidator.init(
            this,
            availableNetwork = {

        })

    }
}