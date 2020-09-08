package com.example.storagelab

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_reading.*

class WritingFragment : Fragment() {

    val FILENAME = "myFile.txt"

    private var textToFile: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("STRLB", "Writing view created")

        val view = inflater.inflate(R.layout.fragment_writing, container, false)
        val writeButton: Button? = view?.findViewById(R.id.write_button)
        textToFile = view?.findViewById(R.id.inputText)

        writeButton?.setOnClickListener { writeButtonClicked() }

        return view
    }

    private fun writeButtonClicked() {
        Log.i("STRLB", "Write button clicked")

        activity?.openFileOutput(FILENAME, Context.MODE_APPEND).use {
            it?.write("${textToFile?.text}\n".toByteArray())
        }
        textToFile?.text?.clear()
    }
}

