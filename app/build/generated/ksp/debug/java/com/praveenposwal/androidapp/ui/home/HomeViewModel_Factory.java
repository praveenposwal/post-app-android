package com.praveenposwal.androidapp.ui.home;

import com.praveenposwal.androidapp.domain.usecase.GetPostsUseCase;
import com.praveenposwal.androidapp.domain.usecase.RefreshPostsUseCase;
import com.praveenposwal.androidapp.domain.usecase.ToggleFavoriteUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetPostsUseCase> getPostsUseCaseProvider;

  private final Provider<RefreshPostsUseCase> refreshPostsUseCaseProvider;

  private final Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetPostsUseCase> getPostsUseCaseProvider,
      Provider<RefreshPostsUseCase> refreshPostsUseCaseProvider,
      Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider) {
    this.getPostsUseCaseProvider = getPostsUseCaseProvider;
    this.refreshPostsUseCaseProvider = refreshPostsUseCaseProvider;
    this.toggleFavoriteUseCaseProvider = toggleFavoriteUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getPostsUseCaseProvider.get(), refreshPostsUseCaseProvider.get(), toggleFavoriteUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<GetPostsUseCase> getPostsUseCaseProvider,
      Provider<RefreshPostsUseCase> refreshPostsUseCaseProvider,
      Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider) {
    return new HomeViewModel_Factory(getPostsUseCaseProvider, refreshPostsUseCaseProvider, toggleFavoriteUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetPostsUseCase getPostsUseCase,
      RefreshPostsUseCase refreshPostsUseCase, ToggleFavoriteUseCase toggleFavoriteUseCase) {
    return new HomeViewModel(getPostsUseCase, refreshPostsUseCase, toggleFavoriteUseCase);
  }
}
