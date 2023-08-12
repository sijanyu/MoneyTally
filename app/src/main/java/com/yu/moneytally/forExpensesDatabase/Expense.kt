package com.yu.moneytally.forExpensesDatabase
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val expenseRecorded: Int,
    val dateRecorded: String,
    val remarks: String,

)
