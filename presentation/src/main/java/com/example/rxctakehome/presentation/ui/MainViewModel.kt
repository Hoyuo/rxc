package com.example.rxctakehome.presentation.ui

import com.example.rxctakehome.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainEvent>()
