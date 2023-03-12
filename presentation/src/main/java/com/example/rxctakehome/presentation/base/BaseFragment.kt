package com.example.rxctakehome.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding, out VM : BaseViewModel<E>, E : BaseEvent>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> B,
) : Fragment() {

    protected abstract val viewModel: VM

    private var _binding: B? = null
    protected val binding
        get() = requireNotNull(_binding)

    protected abstract fun viewModelVariableId(): Int?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflater(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        bindLayout()
    }

    protected fun initLayout() {
        bind {
            lifecycleOwner = viewLifecycleOwner
            viewModelVariableId()?.let { id -> setVariable(id, viewModel) }
        }
    }

    abstract fun bindLayout()

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun bind(action: B.() -> Unit) {
        binding.run(action)
    }

    protected fun <T : ViewDataBinding> bind(binding: T, action: T.() -> Unit) {
        binding.run(action)
    }
}
