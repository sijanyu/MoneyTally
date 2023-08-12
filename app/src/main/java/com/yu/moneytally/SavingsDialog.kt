package com.yu.moneytally

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class SavingsDialog(
    context: Context,
    private val listener: OnAddButtonListener? = null
): AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_savings_dialog)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCanceledOnTouchOutside(false)

        val dialogClose : ImageView  = findViewById(R.id.dialogCloseImageView)
        val addAmountTextBox : TextView =  findViewById(R.id.addAmountTextBox)
        val addAmountButton : AppCompatButton = findViewById(R.id.addAmountButton)

        }
    }

interface OnAddButtonListener {
    fun onAmountAdded(amount: Double)
}