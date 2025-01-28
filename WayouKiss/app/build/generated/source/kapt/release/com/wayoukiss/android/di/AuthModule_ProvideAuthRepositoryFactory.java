package com.wayoukiss.android.di;

import com.wayoukiss.android.data.api.AuthApi;
import com.wayoukiss.android.domain.repositories.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import error.NonExistentClass;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AuthModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<AuthApi> authApiProvider;

  private final Provider<NonExistentClass> tokenManagerProvider;

  public AuthModule_ProvideAuthRepositoryFactory(Provider<AuthApi> authApiProvider,
      Provider<NonExistentClass> tokenManagerProvider) {
    this.authApiProvider = authApiProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(authApiProvider.get(), tokenManagerProvider.get());
  }

  public static AuthModule_ProvideAuthRepositoryFactory create(Provider<AuthApi> authApiProvider,
      Provider<NonExistentClass> tokenManagerProvider) {
    return new AuthModule_ProvideAuthRepositoryFactory(authApiProvider, tokenManagerProvider);
  }

  public static AuthRepository provideAuthRepository(AuthApi authApi,
      NonExistentClass tokenManager) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideAuthRepository(authApi, tokenManager));
  }
}
