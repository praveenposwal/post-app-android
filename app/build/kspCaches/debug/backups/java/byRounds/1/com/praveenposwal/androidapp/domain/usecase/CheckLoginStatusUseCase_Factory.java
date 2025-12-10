package com.praveenposwal.androidapp.domain.usecase;

import com.praveenposwal.androidapp.domain.repository.AuthRepository;
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
public final class CheckLoginStatusUseCase_Factory implements Factory<CheckLoginStatusUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public CheckLoginStatusUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CheckLoginStatusUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static CheckLoginStatusUseCase_Factory create(
      Provider<AuthRepository> repositoryProvider) {
    return new CheckLoginStatusUseCase_Factory(repositoryProvider);
  }

  public static CheckLoginStatusUseCase newInstance(AuthRepository repository) {
    return new CheckLoginStatusUseCase(repository);
  }
}
