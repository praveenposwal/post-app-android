package com.praveenposwal.androidapp.ui.settings;

import com.praveenposwal.androidapp.domain.usecase.LogoutUseCase;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<LogoutUseCase> logoutUseCaseProvider;

  public SettingsViewModel_Factory(Provider<LogoutUseCase> logoutUseCaseProvider) {
    this.logoutUseCaseProvider = logoutUseCaseProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(logoutUseCaseProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<LogoutUseCase> logoutUseCaseProvider) {
    return new SettingsViewModel_Factory(logoutUseCaseProvider);
  }

  public static SettingsViewModel newInstance(LogoutUseCase logoutUseCase) {
    return new SettingsViewModel(logoutUseCase);
  }
}
