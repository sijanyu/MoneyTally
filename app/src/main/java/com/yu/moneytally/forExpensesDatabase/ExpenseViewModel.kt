package com.yu.moneytally.forExpensesDatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExpenseViewModel(
    private val dao: ExpenseDao
    ): ViewModel() {

    private val _sortType = MutableStateFlow(ExpenseSortType.DATE_RECORDED)
    private val _expenses = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                ExpenseSortType.DATE_RECORDED -> dao.getExpensesOrderedByDate()
            }
        }
    private val _state = MutableStateFlow(ExpenseState())
    val state = combine(_state, _sortType, _expenses) { state, sortType, expenses ->
        state.copy(
            expense = expenses,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ExpenseState())
    fun onEvent(event: ExpenseEvent) {
        when(event) {
            is ExpenseEvent.DeleteExpense -> {
                viewModelScope.launch{
                    dao.deleteExpense(event.expense)
                }
            }

            ExpenseEvent.HideDialog -> {_state.update { it.copy(isAddingExpense = false) }}
            ExpenseEvent.SaveExpense -> {
                val expenseRecorded = state.value.expenseRecorded
                val dateRecorded = state.value.dateRecorded
                val remarks =  state.value.remarks

                if(expenseRecorded.toString().isBlank() || dateRecorded.isBlank() || remarks.isBlank()){
                    return
                }
                val expense = Expense(
                    expenseRecorded = expenseRecorded,
                    dateRecorded = dateRecorded,
                    remarks = remarks
                )
                viewModelScope.launch {
                    dao.upsertExpense(expense)
                }

                _state.update { it.copy(
                    isAddingExpense = false,
                    expenseRecorded = 0,
                    dateRecorded = "",
                    remarks = ""
                ) }
            }



            is ExpenseEvent.SetDateRecorded -> {
            _state.update { it.copy(
                dateRecorded = event.dateRecorded
            )}}
            is ExpenseEvent.SetExpenseRecorded -> {
                _state.update { it.copy(
                    expenseRecorded = event.expenseRecorded
                )}}
            is ExpenseEvent.SetRemarks -> {
                _state.update { it.copy(
                    remarks = event.remarks
                )}}
            ExpenseEvent.ShowDialog -> {
                _state.update {it.copy(
                    isAddingExpense = true
                )}
            }
            is ExpenseEvent.SortExpenses -> {
                _sortType.value = event.SortType
            }
        }
    }
}