package com.wayoukiss.android.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, Event, Effect> : ViewModel() {
    
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State
    
    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()
    
    private val _effect = MutableSharedFlow<Effect>()
    val effect = _effect.asSharedFlow()
    
    abstract fun handleEvent(event: Event)
    
    protected fun setState(reduce: State.() -> State) {
        val newState = state.value.reduce()
        _state.value = newState
    }
    
    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.emit(effectValue) }
    }
}
