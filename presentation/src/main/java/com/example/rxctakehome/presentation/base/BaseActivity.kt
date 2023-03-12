package com.example.rxctakehome.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding, out VM : BaseViewModel<E>, E : BaseEvent>(
    private val inflater: (LayoutInflater) -> B,
) : AppCompatActivity() {

    protected lateinit var binding: B
        private set

    protected abstract val viewModel: VM

    protected abstract fun viewModelVariableId(): Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding.root)

        initLayout()
        bindLayout()
    }

    private fun initLayout() {
        bind {
            lifecycleOwner = this@BaseActivity
            viewModelVariableId()?.let { id -> setVariable(id, viewModel) }
        }
    }

    abstract fun bindLayout()

    protected fun bind(action: B.() -> Unit) {
        binding.run(action)
    }

    protected fun <T : ViewDataBinding> bind(binding: T, action: T.() -> Unit) {
        binding.run(action)
    }
}
