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
public final class GetFavoritePostsUseCase_Factory implements Factory<GetFavoritePostsUseCase> {
  private final Provider<PostRepository> repositoryProvider;

  public GetFavoritePostsUseCase_Factory(Provider<PostRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFavoritePostsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFavoritePostsUseCase_Factory create(
      Provider<PostRepository> repositoryProvider) {
    return new GetFavoritePostsUseCase_Factory(repositoryProvider);
  }

  public static GetFavoritePostsUseCase newInstance(PostRepository repository) {
    return new GetFavoritePostsUseCase(repository);
  }
}
