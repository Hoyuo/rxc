package com.example.rxctakehome.presentation.ui

import androidx.activity.viewModels
import com.example.rxctakehome.presentation.BR
import com.example.rxctakehome.presentation.base.BaseActivity
import com.example.rxctakehome.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel, MainEvent>(ActivityMainBinding::inflate) {
    override val viewModel: MainViewModel by viewModels()

    override fun viewModelVariableId(): Int = BR.vm

    override fun bindLayout() = Unit
}
