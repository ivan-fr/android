package com.wayoukiss.android.core.di;

import android.content.Context;
import androidx.biometric.BiometricManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class SecurityModule_ProvideBiometricManagerFactory implements Factory<BiometricManager> {
  private final Provider<Context> contextProvider;

  public SecurityModule_ProvideBiometricManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public BiometricManager get() {
    return provideBiometricManager(contextProvider.get());
  }

  public static SecurityModule_ProvideBiometricManagerFactory create(
      Provider<Context> contextProvider) {
    return new SecurityModule_ProvideBiometricManagerFactory(contextProvider);
  }

  public static BiometricManager provideBiometricManager(Context context) {
    return Preconditions.checkNotNullFromProvides(SecurityModule.INSTANCE.provideBiometricManager(context));
  }
}
