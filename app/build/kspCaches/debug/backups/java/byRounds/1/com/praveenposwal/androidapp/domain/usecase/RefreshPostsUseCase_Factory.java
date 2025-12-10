package com.praveenposwal.androidapp.domain.usecase;

import com.praveenposwal.androidapp.domain.repository.PostRepository;
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
public final class RefreshPostsUseCase_Factory implements Factory<RefreshPostsUseCase> {
  private final Provider<PostRepository> repositoryProvider;

  public RefreshPostsUseCase_Factory(Provider<PostRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RefreshPostsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static RefreshPostsUseCase_Factory create(Provider<PostRepository> repositoryProvider) {
    return new RefreshPostsUseCase_Factory(repositoryProvider);
  }

  public static RefreshPostsUseCase newInstance(PostRepository repository) {
    return new RefreshPostsUseCase(repository);
  }
}
