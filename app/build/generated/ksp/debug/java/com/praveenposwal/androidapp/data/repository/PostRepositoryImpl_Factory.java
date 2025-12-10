package com.praveenposwal.androidapp.data.repository;

import com.praveenposwal.androidapp.data.api.ApiService;
import com.praveenposwal.androidapp.data.db.PostDao;
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
public final class PostRepositoryImpl_Factory implements Factory<PostRepositoryImpl> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<PostDao> postDaoProvider;

  public PostRepositoryImpl_Factory(Provider<ApiService> apiServiceProvider,
      Provider<PostDao> postDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.postDaoProvider = postDaoProvider;
  }

  @Override
  public PostRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), postDaoProvider.get());
  }

  public static PostRepositoryImpl_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<PostDao> postDaoProvider) {
    return new PostRepositoryImpl_Factory(apiServiceProvider, postDaoProvider);
  }

  public static PostRepositoryImpl newInstance(ApiService apiService, PostDao postDao) {
    return new PostRepositoryImpl(apiService, postDao);
  }
}
