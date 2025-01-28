package com.wayoukiss.android.core.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u00a2\u0006\u0002\u0010\f\u001aR\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00142\u001a\b\u0002\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\t\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u00a8\u0006\u001d"}, d2 = {"collectWithLifecycle", "", "T", "Lkotlinx/coroutines/flow/Flow;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "state", "Landroidx/lifecycle/Lifecycle$State;", "collector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;)V", "showBiometricPrompt", "Landroidx/fragment/app/FragmentActivity;", "title", "", "subtitle", "negativeButtonText", "onSuccess", "Lkotlin/Function1;", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "onError", "", "", "showToast", "Landroid/content/Context;", "message", "duration", "app_debug"})
public final class ExtensionsKt {
    
    public static final void showToast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull
    java.lang.String message, int duration) {
    }
    
    public static final <T extends java.lang.Object>void collectWithLifecycle(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> $this$collectWithLifecycle, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.Lifecycle.State state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> collector) {
    }
    
    public static final void showBiometricPrompt(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity $this$showBiometricPrompt, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String subtitle, @org.jetbrains.annotations.NotNull
    java.lang.String negativeButtonText, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.biometric.BiometricPrompt.AuthenticationResult, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.CharSequence, kotlin.Unit> onError) {
    }
}