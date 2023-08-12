package com.yu.moneytally.forExpensesDatabase

data class ExpenseState(
    val expense: List<Expense> = emptyList(),
    val expenseRecorded: Int = 0,
    val dateRecorded: String = "",
    val remarks: String = "",
    val isAddingExpense: Boolean = false,
    val sortType: ExpenseSortType = ExpenseSortType.DATE_RECORDED
)
