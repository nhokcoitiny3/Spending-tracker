@file:OptIn(FlowPreview::class)

package com.tiny.spending_tracker.tracker.presentation.tracker_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiny.spending_tracker.tracker.domain.TrackerRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TrackerHomeViewModel(private val trackerRepository: TrackerRepository) : ViewModel() {

    private var observeAllExpenseJob: Job? = null

    private val _state = MutableStateFlow(TrackerHomeState())
    val state = _state.onStart {
        observeAllExpense()
    }.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), _state.value
    )

    fun onAction(action: TrackerHomeAction) {
        when (action) {
            is TrackerHomeAction.OnClickViewAll -> {
                _state.update {
                    it.copy(isLoading = false)
                }
            }

        }
    }

    private fun observeAllExpense() {
        observeAllExpenseJob?.cancel()
        observeAllExpenseJob = trackerRepository.getAllExpense().onEach { expenses ->
            _state.update {
                it.copy(
                    listExpense = expenses
                )
            }
        }.launchIn(viewModelScope)
    }
}