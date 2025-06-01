package com.example.praktikfragmentprojects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FragmentB : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtData = view.findViewById<EditText>(R.id.edtData)
        val btnToFragmentA = view.findViewById<Button>(R.id.btnToFragmentA)

        val fragmentManager = parentFragmentManager

        btnToFragmentA.setOnClickListener {
            val valueEditText = edtData.text.toString()
            val dataToSend: String? = if (valueEditText.isNotEmpty()) {
                valueEditText
            } else {
                null

            }

            val fragmentA = FragmentA()
            fragmentA.arguments = Bundle().apply {
                putString("DATA_KEY", dataToSend)
            }
            fragmentManager.beginTransaction()
                .replace(R.id.frameContainer, fragmentA, FragmentA::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }

}