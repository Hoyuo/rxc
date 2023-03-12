package com.example.rxctakehome.presentation.widget

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.example.rxctakehome.presentation.databinding.WidgetProductDescriptionBinding
import com.example.rxctakehome.presentation.model.GoodPresentationModel
import com.example.rxctakehome.util.ktx.layoutInflater

@BindingMethods(
    value = [
        BindingMethod(
            type = WidgetProductDescription::class,
            attribute = "description",
            method = "setDescription",
        ),
    ]
)
class WidgetProductDescription @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = WidgetProductDescriptionBinding.inflate(
        layoutInflater,
        this,
        true
    )

    fun setDescription(item: GoodPresentationModel) {
        setTitle("${item.name}")
        setDiscountRate(item.discountRate)
        setPrice(item.price)
        setConsumerPrice(item.discountRate, item.consumerPrice)
    }

    private fun setTitle(title: String) {
        binding.title.text = title
    }

    private fun setDiscountRate(discountRate: Double) {
        if (discountRate > 0) {
            binding.discountRate.text = String.format("%.0f%%", discountRate)
            binding.discountRate.isVisible = true
        } else {
            binding.discountRate.isVisible = false
        }
    }

    private fun setPrice(price: Int) {
        binding.price.text = String.format("%,d원", price)
    }

    private fun setConsumerPrice(discountRate: Double, consumerPrice: Int) {
        if (discountRate > 0) {
            binding.consumerPrice.isVisible = true
            binding.consumerPrice.text = String.format("%,d원", consumerPrice)
            binding.consumerPrice.paintFlags = binding.consumerPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.consumerPrice.isVisible = false
        }
    }
}
