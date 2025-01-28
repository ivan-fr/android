package com.wayoukiss.android.core.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J+\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0004\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u0017\u001a\u00020\f2\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00000\u000eH\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/wayoukiss/android/core/presentation/BaseViewModel;", "State", "Event", "Landroidx/lifecycle/ViewModel;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "launch", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "onEvent", "event", "(Ljava/lang/Object;)V", "setState", "newState", "updateState", "update", "app_release"})
public abstract class BaseViewModel<State extends java.lang.Object, Event extends java.lang.Object> extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<State> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<State> state = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<State> getState() {
        return null;
    }
    
    protected final void setState(State newState) {
    }
    
    protected final void updateState(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super State, ? extends State> update) {
    }
    
    public abstract void onEvent(Event event);
    
    protected final void launch(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
    }
}