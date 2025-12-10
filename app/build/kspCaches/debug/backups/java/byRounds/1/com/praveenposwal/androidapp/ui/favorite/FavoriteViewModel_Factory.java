package com.praveenposwal.androidapp.ui.favorite;

import com.praveenposwal.androidapp.domain.usecase.GetFavoritePostsUseCase;
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
public final class FavoriteViewModel_Factory implements Factory<FavoriteViewModel> {
  private final Provider<GetFavoritePostsUseCase> getFavoritePostsUseCaseProvider;

  private final Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider;

  public FavoriteViewModel_Factory(
      Provider<GetFavoritePostsUseCase> getFavoritePostsUseCaseProvider,
      Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider) {
    this.getFavoritePostsUseCaseProvider = getFavoritePostsUseCaseProvider;
    this.toggleFavoriteUseCaseProvider = toggleFavoriteUseCaseProvider;
  }

  @Override
  public FavoriteViewModel get() {
    return newInstance(getFavoritePostsUseCaseProvider.get(), toggleFavoriteUseCaseProvider.get());
  }

  public static FavoriteViewModel_Factory create(
      Provider<GetFavoritePostsUseCase> getFavoritePostsUseCaseProvider,
      Provider<ToggleFavoriteUseCase> toggleFavoriteUseCaseProvider) {
    return new FavoriteViewModel_Factory(getFavoritePostsUseCaseProvider, toggleFavoriteUseCaseProvider);
  }

  public static FavoriteViewModel newInstance(GetFavoritePostsUseCase getFavoritePostsUseCase,
      ToggleFavoriteUseCase toggleFavoriteUseCase) {
    return new FavoriteViewModel(getFavoritePostsUseCase, toggleFavoriteUseCase);
  }
}
