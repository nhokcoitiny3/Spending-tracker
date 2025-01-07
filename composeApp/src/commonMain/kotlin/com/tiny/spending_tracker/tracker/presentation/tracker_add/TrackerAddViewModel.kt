package com.tiny.spending_tracker.tracker.presentation.tracker_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiny.spending_tracker.tracker.domain.TrackerRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TrackerAddViewModel(private val trackerRepository: TrackerRepository) : ViewModel() {
    private var observeAllCategoryJob: Job? = null

    private val _state = MutableStateFlow(TrackerAddState())
    val state = _state.onStart {
        observeAllCategory()
    }.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), _state.value
    )

    fun onAction(action: TrackerAddAction) {
        when (action) {
            is TrackerAddAction.OnClickSelectCategory -> {
                _state.update {
                    it.copy(isLoading = false)
                }
            }

        }
    }

    private fun observeAllCategory() {
        observeAllCategoryJob?.cancel()
        observeAllCategoryJob = trackerRepository.getAllCategory().onEach { categories ->
            _state.update {
                it.copy(
                    listCategory = categories
                )
            }
        }.launchIn(viewModelScope)
    }
}