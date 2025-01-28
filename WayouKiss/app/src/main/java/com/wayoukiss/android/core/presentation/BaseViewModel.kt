package com.wayoukiss.android.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, Event> : ViewModel() {
    private val _state = MutableStateFlow<State?>(null)
    val state: StateFlow<State?> = _state.asStateFlow()

    protected fun setState(newState: State) {
        _state.value = newState
    }

    protected fun updateState(update: (State?) -> State) {
        _state.value = update(_state.value)
    }

    abstract fun onEvent(event: Event)

    protected fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            block()
        }
    }
}
