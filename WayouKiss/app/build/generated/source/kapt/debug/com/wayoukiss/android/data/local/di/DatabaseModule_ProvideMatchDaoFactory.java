package com.wayoukiss.android.data.local.di;

import com.wayoukiss.android.data.local.dao.MatchDao;
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
public final class DatabaseModule_ProvideMatchDaoFactory implements Factory<MatchDao> {
  private final Provider<NonExistentClass> databaseProvider;

  public DatabaseModule_ProvideMatchDaoFactory(Provider<NonExistentClass> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MatchDao get() {
    return provideMatchDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideMatchDaoFactory create(
      Provider<NonExistentClass> databaseProvider) {
    return new DatabaseModule_ProvideMatchDaoFactory(databaseProvider);
  }

  public static MatchDao provideMatchDao(NonExistentClass database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMatchDao(database));
  }
}
