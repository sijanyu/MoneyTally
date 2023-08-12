package com.yu.moneytally.forExpensesDatabase

sealed interface ExpenseEvent {
    object  SaveExpense: ExpenseEvent
    data class SetExpenseRecorded(val expenseRecorded: Int): ExpenseEvent
    data class SetDateRecorded(val dateRecorded: String): ExpenseEvent
    data class SetRemarks(val remarks: String): ExpenseEvent
    object ShowDialog: ExpenseEvent
    object HideDialog: ExpenseEvent
    data class SortExpenses(val SortType: ExpenseSortType): ExpenseEvent
    data class DeleteExpense(val expense: Expense): ExpenseEvent

}