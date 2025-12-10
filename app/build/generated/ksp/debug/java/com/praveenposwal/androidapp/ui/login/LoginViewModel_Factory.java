package com.praveenposwal.androidapp.ui.login;

import com.praveenposwal.androidapp.domain.usecase.CheckLoginStatusUseCase;
import com.praveenposwal.androidapp.domain.usecase.LoginUseCase;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<CheckLoginStatusUseCase> checkLoginStatusUseCaseProvider;

  public LoginViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<CheckLoginStatusUseCase> checkLoginStatusUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.checkLoginStatusUseCaseProvider = checkLoginStatusUseCaseProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(loginUseCaseProvider.get(), checkLoginStatusUseCaseProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<CheckLoginStatusUseCase> checkLoginStatusUseCaseProvider) {
    return new LoginViewModel_Factory(loginUseCaseProvider, checkLoginStatusUseCaseProvider);
  }

  public static LoginViewModel newInstance(LoginUseCase loginUseCase,
      CheckLoginStatusUseCase checkLoginStatusUseCase) {
    return new LoginViewModel(loginUseCase, checkLoginStatusUseCase);
  }
}
