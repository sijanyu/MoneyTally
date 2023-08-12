package com.yu.moneytally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yu.moneytally.databinding.FragmentSavingsBinding

class SavingsFragment() : Fragment(), OnAddButtonListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var savingsBinding: FragmentSavingsBinding? = null
    private val binding get() = savingsBinding!!
    private var savingsBankDialog: SavingsBankDialog? = null
    private var savingsWalletDialog: SavingsWalletDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savingsBinding = FragmentSavingsBinding.inflate(inflater, container, false)
        setAmountBank()
        setAmountWallet()
        return savingsBinding!!.root
    }

    private fun setAmountBank(){
        savingsBinding?.addAmountBankImageView?.setOnClickListener {
         savingsBankDialog = activity?.let { it1 ->
             SavingsBankDialog(it1, this).apply {
                 show()
             }
         }
        }
    }

    private fun setAmountWallet(){
        savingsBinding?.addAmountWalletImageView?.setOnClickListener {
            savingsWalletDialog = activity?.let { it1 ->
                SavingsWalletDialog(it1, this).apply {
                    show()
                }
            }
        }
    }

    override fun onAddAmount(amount: String) {
        binding.bankAmountTextBox.text = amount
    }
}