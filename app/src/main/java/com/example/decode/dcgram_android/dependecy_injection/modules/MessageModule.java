package com.example.decode.dcgram_android.dependecy_injection.modules;

import com.example.decode.dcgram_android.data.repository.MessageRepository;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.interactors.MessageInteractor;
import com.example.decode.dcgram_android.domain.interactors.base.Interactor;
import com.example.decode.dcgram_android.domain.repository.Repository;
import com.example.decode.dcgram_android.presentation.presenters.MainPresenter;
import com.example.decode.dcgram_android.presentation.presenters.impl.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;


@Module
public class MessageModule {

    private MainPresenter.View view;

    public MessageModule(MainPresenter.View view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    public MainPresenter.View provideView() {
        return view;
    }

    @PerActivity
    @Provides
    public Interactor provideInteractor(MessageInteractor interactor) {
        return interactor;
    }

    @PerActivity
    @Provides
    public MainPresenter providePresenter(MainPresenterImpl presenter) {
        return presenter;
    }

    @PerActivity
    @Provides
    public Repository provideRepository(MessageRepository messageRepository) {
        return messageRepository;
    }
}
