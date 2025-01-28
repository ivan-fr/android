package com.wayoukiss.android.data.local.di;

import com.wayoukiss.android.data.local.dao.ProfileDao;
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
public final class DatabaseModule_ProvideProfileDaoFactory implements Factory<ProfileDao> {
  private final Provider<NonExistentClass> databaseProvider;

  public DatabaseModule_ProvideProfileDaoFactory(Provider<NonExistentClass> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ProfileDao get() {
    return provideProfileDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideProfileDaoFactory create(
      Provider<NonExistentClass> databaseProvider) {
    return new DatabaseModule_ProvideProfileDaoFactory(databaseProvider);
  }

  public static ProfileDao provideProfileDao(NonExistentClass database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideProfileDao(database));
  }
}
