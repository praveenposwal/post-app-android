package com.praveenposwal.androidapp.ui.postdetails;

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
public final class PostDetailsViewModel_Factory implements Factory<PostDetailsViewModel> {
  private final Provider<PostRepository> repositoryProvider;

  public PostDetailsViewModel_Factory(Provider<PostRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PostDetailsViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PostDetailsViewModel_Factory create(Provider<PostRepository> repositoryProvider) {
    return new PostDetailsViewModel_Factory(repositoryProvider);
  }

  public static PostDetailsViewModel newInstance(PostRepository repository) {
    return new PostDetailsViewModel(repository);
  }
}
