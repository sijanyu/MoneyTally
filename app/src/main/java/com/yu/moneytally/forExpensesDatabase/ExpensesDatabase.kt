package com.yu.moneytally.forExpensesDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expense::class],
    version = 1
)

abstract class ExpensesDatabase: RoomDatabase() {
    abstract val dao: ExpenseDao
}

