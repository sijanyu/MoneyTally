package com.yu.moneytally

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class SavingsBankDialog(
    context: Context,
    private val listener: OnAddButtonListener? = null
): AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_savings_bank_dialog)
        window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        setCanceledOnTouchOutside(false)

        val dialogClose: ImageView = findViewById(R.id.bankDialogCloseImageView)
<<<<<<< HEAD
=======
<<<<<<<< HEAD:app/src/main/java/com/yu/moneytally/SavingsDialog.kt


========
>>>>>>>> 5f20ea4 (added database for Expense Fragment):app/src/main/java/com/yu/moneytally/SavingsBankDialog.kt
>>>>>>> 5f20ea4 (added database for Expense Fragment)
        val addAmountTextBox: EditText = findViewById(R.id.bankAddAmountTextBox)
        val addAmountButton: AppCompatButton = findViewById(R.id.bankAddAmountButton)

        dialogClose.setOnClickListener {
            dismiss()
        }

        addAmountButton.setOnClickListener {
            if (addAmountTextBox.text.isNotEmpty()) {
                listener?.onAddAmount(addAmountTextBox.text.toString())
                dismiss()
            } else {
                show()
<<<<<<< HEAD
            }
        }
    }
}


interface OnAddButtonListener {
    fun onAddAmount(amount: String) {}
}
=======
<<<<<<<< HEAD:app/src/main/java/com/yu/moneytally/SavingsDialog.kt
========
            }
>>>>>>>> 5f20ea4 (added database for Expense Fragment):app/src/main/java/com/yu/moneytally/SavingsBankDialog.kt
        }
                }
            }
        }


/**
interface OnAddButtonListener {
    fun onAddAmount(amount: String) {}
}

<<<<<<<< HEAD:app/src/main/java/com/yu/moneytally/SavingsDialog.kt
 **/
========

interface OnAddButtonListener {
    fun onAddAmount(amount: String) {}

    fun onAddAmountWallet(amount: String) {}
}
>>>>>>>> 5f20ea4 (added database for Expense Fragment):app/src/main/java/com/yu/moneytally/SavingsBankDialog.kt
>>>>>>> 5f20ea4 (added database for Expense Fragment)
