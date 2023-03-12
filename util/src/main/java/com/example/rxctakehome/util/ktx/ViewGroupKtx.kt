package com.example.rxctakehome.util.ktx

import android.view.LayoutInflater
import android.view.ViewGroup

inline val ViewGroup.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(context)
