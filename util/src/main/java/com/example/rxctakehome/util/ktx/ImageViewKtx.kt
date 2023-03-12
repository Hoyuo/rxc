package com.example.rxctakehome.util.ktx

import android.widget.ImageView
import androidx.core.content.ContextCompat
import coil.load
import com.example.rxctakehome.util.R

fun ImageView.setImage(imageSrc: String?) {
    this.load(imageSrc) {
        allowConversionToBitmap(false)
        placeholder(ContextCompat.getDrawable(context, R.color.place_holder))
    }
}
