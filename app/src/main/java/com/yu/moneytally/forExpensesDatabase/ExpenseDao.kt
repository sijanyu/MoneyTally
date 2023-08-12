package com.yu.moneytally.forExpensesDatabase

import androidx.room.Dao
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Upsert
    suspend fun upsertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expense ORDER BY dateRecorded ASC")
    fun getExpensesOrderedByDate(): Flow<List<Expense>>
}