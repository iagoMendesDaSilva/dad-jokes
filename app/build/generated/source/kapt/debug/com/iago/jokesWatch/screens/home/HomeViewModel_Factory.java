// Generated by Dagger (https://dagger.dev).
package com.iago.jokesWatch.screens.home;

import com.iago.jokesWatch.repository.JokeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<JokeRepository> repositoryProvider;

  public HomeViewModel_Factory(Provider<JokeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<JokeRepository> repositoryProvider) {
    return new HomeViewModel_Factory(repositoryProvider);
  }

  public static HomeViewModel newInstance(JokeRepository repository) {
    return new HomeViewModel(repository);
  }
}
