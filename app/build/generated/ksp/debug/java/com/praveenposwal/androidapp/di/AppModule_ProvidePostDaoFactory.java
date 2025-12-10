package com.praveenposwal.androidapp.di;

import com.praveenposwal.androidapp.data.db.AppDatabase;
import com.praveenposwal.androidapp.data.db.PostDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class AppModule_ProvidePostDaoFactory implements Factory<PostDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvidePostDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public PostDao get() {
    return providePostDao(dbProvider.get());
  }

  public static AppModule_ProvidePostDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvidePostDaoFactory(dbProvider);
  }

  public static PostDao providePostDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePostDao(db));
  }
}
