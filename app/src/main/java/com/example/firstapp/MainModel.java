package com.example.firstapp;

public class MainModel implements MainPresenter.Model {

    private MainPresenter.View _view;

    public MainModel(MainPresenter.View _view){
        this._view = _view;
    }

    @Override
    public void start() {
        _view.initViews();
    }
}