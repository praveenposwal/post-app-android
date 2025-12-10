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
public final class GetPostsUseCase_Factory implements Factory<GetPostsUseCase> {
  private final Provider<PostRepository> repositoryProvider;

  public GetPostsUseCase_Factory(Provider<PostRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPostsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetPostsUseCase_Factory create(Provider<PostRepository> repositoryProvider) {
    return new GetPostsUseCase_Factory(repositoryProvider);
  }

  public static GetPostsUseCase newInstance(PostRepository repository) {
    return new GetPostsUseCase(repository);
  }
}
