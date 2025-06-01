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
import com.example.praktikfragmentprojects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        fragmentManager.beginTransaction()
            .add(R.id.frameContainer, fragmentA, fragmentA::class.java.simpleName)
            .commit()

        binding.btnA.setOnClickListener {
            var fragment = fragmentManager.findFragmentByTag(FragmentA::class.java.simpleName)

            if (fragment !is FragmentA) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, fragmentA, fragmentA::class.java.simpleName)
                    .commit()
            }
        }

        binding.btnB.setOnClickListener {
            var fragment = fragmentManager.findFragmentByTag(FragmentB::class.java.simpleName)
            if (fragment !is FragmentB) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, fragmentB, fragmentB::class.java.simpleName)
                    .commit()
            }
        }
    }
}