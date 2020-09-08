package com.example.storagelab

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReadingFragment : Fragment() {

    val FILENAME = "myFile.txt"

    private var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("STRLB", "Reading view created")

        val view = inflater.inflate(R.layout.fragment_reading, container, false)
        textView = view?.findViewById(R.id.fileText)

        val readButton: Button? = view?.findViewById(R.id.read_button)
        readButton?.setOnClickListener { readButtonClicked() }

        return view
    }

    private fun readButtonClicked() {

        Log.i("STRLB", "Read button clicked")

        textView?.text = activity?.openFileInput(FILENAME)?.bufferedReader().use {
            it?.readText() ?: "Text reading failed"
        }
    }

}