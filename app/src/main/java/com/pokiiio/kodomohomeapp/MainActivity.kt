package com.pokiiio.kodomohomeapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var father : LinearLayout
    private lateinit var mother : LinearLayout
    private lateinit var camera : LinearLayout
    private lateinit var photo : LinearLayout
    private lateinit var packageManager : PackageManager
    private val code = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        packageManager = getPackageManager()

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), code)
        }
    }

    override fun onResume() {
        super.onResume()

        father = findViewById(R.id.father)
        mother = findViewById(R.id.mother)
        camera = findViewById(R.id.camera)
        photo = findViewById(R.id.photo)

        father.setOnLongClickListener(View.OnLongClickListener {
            val uri = Uri.parse("tel:08000000000")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
            return@OnLongClickListener true
        })

        mother.setOnLongClickListener(View.OnLongClickListener {
            val uri = Uri.parse("tel:08000000000")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
            return@OnLongClickListener true
        })

        camera.setOnLongClickListener(View.OnLongClickListener {
            val intent = packageManager.getLaunchIntentForPackage("com.myos.camera")
            startActivity(intent)
            return@OnLongClickListener true
        })

        photo.setOnLongClickListener(View.OnLongClickListener {
            val intent = packageManager.getLaunchIntentForPackage("com.google.android.apps.nbu.files")
            startActivity(intent)
            return@OnLongClickListener true
        })
    }
}