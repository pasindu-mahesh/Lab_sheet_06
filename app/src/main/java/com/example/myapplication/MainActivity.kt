package com.example.myapplication //impotsd git

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch //impot ////

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lateinit var myBroadcastReceiver: MyReceiver
        fun onCreate(savedInstanceState: Bundle?) {

            myBroadcastReceiver = MyReceiver()
            // Register the receiver to listen for broadcast intents with the custom action
            val filter = IntentFilter("com.example.labbroadcast.MY_CUSTOM_ACTION")
            val listenToBroadcastsFromOtherApps = false
            val receiverFlags = if (listenToBroadcastsFromOtherApps) {
                ContextCompat.RECEIVER_EXPORTED
            } else {
                ContextCompat.RECEIVER_NOT_EXPORTED
            }
            ContextCompat.registerReceiver(this, myBroadcastReceiver,filter,receiverFlags)
            GlobalScope.launch {
                delay(5000) //rgererer
                val intent = Intent()
                intent.action = "com.example.labbroadcast.MY_CUSTOM_ACTION"
                sendBroadcast(intent)
            }
        }
    }
}