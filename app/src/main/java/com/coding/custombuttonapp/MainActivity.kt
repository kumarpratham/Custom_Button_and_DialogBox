package com.coding.custombuttonapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.coding.custombuttonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var t : Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        t = Toast.makeText(this,"You clicked on OK",Toast.LENGTH_SHORT)
        binding.btn1.setOnClickListener {
            showDefaultDialog()
        }
        binding.btn2.setOnClickListener {
            showCustomDialog()
        }


    }

    private fun showCustomDialog() {
        // Create a Dialog instance
        val dialog = Dialog(this)

        // Set the custom dialog layout
        dialog.setContentView(R.layout.custom_dialogbox)

        // Find the OK button in the dialog layout
        val dialogButtonOK: Button = dialog.findViewById(R.id.dialogButtonOK)
        val dialogButtonCancel: Button = dialog.findViewById(R.id.dialogButtonCancel)

        // Set a click listener for the OK button
        dialogButtonOK.setOnClickListener {
            t.show()
        }
        dialogButtonCancel.setOnClickListener {
            // Close the dialog when the OK button is clicked
            dialog.dismiss()
        }

        // Show the dialog
        dialog.show()
    }

    private fun showDefaultDialog() {
        // Create an AlertDialog.Builder instance
        val builder = AlertDialog.Builder(this)

        // Set dialog title and message
        builder.setTitle("Default Dialog")
            .setMessage("This is a default dialog.")

        // Set positive button and its click listener
        builder.setPositiveButton("OK") { dialog, which ->
            // Handle the OK button click
            // You can add your custom logic here if needed
            t.show()
        }

        // Set negative button and its click listener (optional)
        builder.setNegativeButton("Cancel") { dialog, which ->
            // Handle the Cancel button click
            // You can add your custom logic here if needed
            dialog.dismiss()
        }

        // Create and show the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}