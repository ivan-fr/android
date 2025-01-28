package com.wayoukiss.android.data.local.di;

import com.wayoukiss.android.data.local.dao.ChatDao;
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
public final class DatabaseModule_ProvideChatDaoFactory implements Factory<ChatDao> {
  private final Provider<NonExistentClass> databaseProvider;

  public DatabaseModule_ProvideChatDaoFactory(Provider<NonExistentClass> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ChatDao get() {
    return provideChatDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideChatDaoFactory create(
      Provider<NonExistentClass> databaseProvider) {
    return new DatabaseModule_ProvideChatDaoFactory(databaseProvider);
  }

  public static ChatDao provideChatDao(NonExistentClass database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideChatDao(database));
  }
}
