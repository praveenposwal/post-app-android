package com.praveenposwal.androidapp.di;

import com.praveenposwal.androidapp.data.repository.AuthRepositoryImpl;
import com.praveenposwal.androidapp.domain.repository.AuthRepository;
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
public final class AppModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<AuthRepositoryImpl> authRepositoryImplProvider;

  public AppModule_ProvideAuthRepositoryFactory(
      Provider<AuthRepositoryImpl> authRepositoryImplProvider) {
    this.authRepositoryImplProvider = authRepositoryImplProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(authRepositoryImplProvider.get());
  }

  public static AppModule_ProvideAuthRepositoryFactory create(
      Provider<AuthRepositoryImpl> authRepositoryImplProvider) {
    return new AppModule_ProvideAuthRepositoryFactory(authRepositoryImplProvider);
  }

  public static AuthRepository provideAuthRepository(AuthRepositoryImpl authRepositoryImpl) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRepository(authRepositoryImpl));
  }
}
