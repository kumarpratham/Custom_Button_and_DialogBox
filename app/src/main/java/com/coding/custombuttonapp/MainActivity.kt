package com.coding.custombuttonapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
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
        binding.btn3.setOnClickListener {
            showCustomDialog1()
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
    private fun showCustomDialog1() {
        // Create a Dialog instance
        val dialog = Dialog(this)

        // Set the custom dialog layout
        dialog.setContentView(R.layout.custom_dialogbox_1)

        // Find the OK button in the dialog layout
        val dialogButtonOK: Button = dialog.findViewById(R.id.btnOK)
        val dialogButtonCancel: Button = dialog.findViewById(R.id.btnCancel)

        // Set a click listener for the OK button
        dialogButtonOK.setOnClickListener {
            t.show()
        }
        dialogButtonCancel.setOnClickListener {
            // Close the dialog when the OK button is clicked
            dialog.dismiss()
        }

        // Set the position of the dialog
        val window: Window? = dialog.window
        window?.let {
            val layoutParams = WindowManager.LayoutParams()
            // Set background to transparent
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            // Set the gravity to control the position of the dialog
            layoutParams.gravity = Gravity.BOTTOM // Change this to your desired position


            // Adjust the layout parameters to match the content, not fill the screen
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

            it.attributes = layoutParams
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