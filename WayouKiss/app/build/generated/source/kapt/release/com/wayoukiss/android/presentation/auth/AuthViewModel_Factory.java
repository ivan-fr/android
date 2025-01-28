package com.wayoukiss.android.presentation.auth;

import com.wayoukiss.android.domain.usecases.SignInWithGoogleUseCase;
import com.wayoukiss.android.domain.usecases.SignOutUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<SignInWithGoogleUseCase> signInWithGoogleUseCaseProvider;

  private final Provider<SignOutUseCase> signOutUseCaseProvider;

  public AuthViewModel_Factory(Provider<SignInWithGoogleUseCase> signInWithGoogleUseCaseProvider,
      Provider<SignOutUseCase> signOutUseCaseProvider) {
    this.signInWithGoogleUseCaseProvider = signInWithGoogleUseCaseProvider;
    this.signOutUseCaseProvider = signOutUseCaseProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(signInWithGoogleUseCaseProvider.get(), signOutUseCaseProvider.get());
  }

  public static AuthViewModel_Factory create(
      Provider<SignInWithGoogleUseCase> signInWithGoogleUseCaseProvider,
      Provider<SignOutUseCase> signOutUseCaseProvider) {
    return new AuthViewModel_Factory(signInWithGoogleUseCaseProvider, signOutUseCaseProvider);
  }

  public static AuthViewModel newInstance(SignInWithGoogleUseCase signInWithGoogleUseCase,
      SignOutUseCase signOutUseCase) {
    return new AuthViewModel(signInWithGoogleUseCase, signOutUseCase);
  }
}
