package com.praveenposwal.androidapp.di;

import com.praveenposwal.androidapp.data.api.ApiService;
import com.praveenposwal.androidapp.data.db.PostDao;
import com.praveenposwal.androidapp.domain.repository.PostRepository;
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
public final class AppModule_ProvidePostRepositoryFactory implements Factory<PostRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<PostDao> postDaoProvider;

  public AppModule_ProvidePostRepositoryFactory(Provider<ApiService> apiServiceProvider,
      Provider<PostDao> postDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.postDaoProvider = postDaoProvider;
  }

  @Override
  public PostRepository get() {
    return providePostRepository(apiServiceProvider.get(), postDaoProvider.get());
  }

  public static AppModule_ProvidePostRepositoryFactory create(
      Provider<ApiService> apiServiceProvider, Provider<PostDao> postDaoProvider) {
    return new AppModule_ProvidePostRepositoryFactory(apiServiceProvider, postDaoProvider);
  }

  public static PostRepository providePostRepository(ApiService apiService, PostDao postDao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePostRepository(apiService, postDao));
  }
}
