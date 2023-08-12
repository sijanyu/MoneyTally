package com.yu.moneytally


import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class SavingsWalletDialog(
    context: Context,
<<<<<<< HEAD
    private val listener: OnAddButtonListener? = null
=======
    private val listener2: OnAddButtonListener? = null
>>>>>>> 5f20ea4 (added database for Expense Fragment)
): AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_savings_wallet_dialog)
        window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        setCanceledOnTouchOutside(false)

        val dialogClose: ImageView = findViewById(R.id.walletDialogCloseImageView)
        val addAmountTextBox: EditText = findViewById(R.id.walletAddAmountTextBox)
        val addAmountButton: AppCompatButton = findViewById(R.id.walletAddAmountButton)

        dialogClose.setOnClickListener {
            dismiss()
        }

        addAmountButton.setOnClickListener {
            if (addAmountTextBox.text.isNotEmpty()) {
<<<<<<< HEAD
                listener?.onAddAmount(addAmountTextBox.text.toString())
=======
                listener2?.onAddAmountWallet(addAmountTextBox.text.toString())
>>>>>>> 5f20ea4 (added database for Expense Fragment)
                dismiss()
            } else {
                show()
            }
        }
    }
}
<<<<<<< HEAD

/**
interface OnAddButtonListener {
    fun onAddAmount(amount: String) {}
}
 **/
=======
>>>>>>> 5f20ea4 (added database for Expense Fragment)
