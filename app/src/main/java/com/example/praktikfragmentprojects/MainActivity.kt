/*
Nama                : Dani Herawan
NIM                 : 10122331
Kelas               : P.ANDRO 4
Pengerjaan Terakhir : Minggu, 1 Juni 2025, jam 16:44

*/

package com.example.praktikfragmentprojects

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        fragmentManager.beginTransaction()
            .add(R.id.frameContainer, fragmentA, fragmentA::class.java.simpleName)
            .commit()
    }
}