package com.wayoukiss.android.presentation.auth;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/wayoukiss/android/presentation/auth/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "signInWithGoogleUseCase", "Lcom/wayoukiss/android/domain/usecases/SignInWithGoogleUseCase;", "signOutUseCase", "Lcom/wayoukiss/android/domain/usecases/SignOutUseCase;", "(Lcom/wayoukiss/android/domain/usecases/SignInWithGoogleUseCase;Lcom/wayoukiss/android/domain/usecases/SignOutUseCase;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wayoukiss/android/presentation/auth/AuthUiState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "signInWithGoogle", "", "idToken", "", "signOut", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.wayoukiss.android.domain.usecases.SignInWithGoogleUseCase signInWithGoogleUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.wayoukiss.android.domain.usecases.SignOutUseCase signOutUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.wayoukiss.android.presentation.auth.AuthUiState> _authState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.wayoukiss.android.presentation.auth.AuthUiState> authState = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.wayoukiss.android.domain.usecases.SignInWithGoogleUseCase signInWithGoogleUseCase, @org.jetbrains.annotations.NotNull
    com.wayoukiss.android.domain.usecases.SignOutUseCase signOutUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.wayoukiss.android.presentation.auth.AuthUiState> getAuthState() {
        return null;
    }
    
    public final void signInWithGoogle(@org.jetbrains.annotations.NotNull
    java.lang.String idToken) {
    }
    
    public final void signOut() {
    }
}