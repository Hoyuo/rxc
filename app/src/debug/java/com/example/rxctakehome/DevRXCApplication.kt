package com.example.rxctakehome

import android.webkit.WebView
import com.example.rxctakehome.logger.TimberDebugTree
import com.facebook.flipper.plugins.leakcanary2.FlipperLeakEventListener
import leakcanary.LeakCanary
import timber.log.Timber

class DevRXCApplication : RXCApplication() {
    override fun onCreate() {
        super.onCreate()

        LeakCanary.config = LeakCanary.config.run {
            copy(eventListeners = eventListeners + FlipperLeakEventListener())
        }

        Timber.plant(TimberDebugTree(getString(R.string.app_name)))

        Timber.d("Debug App Start")

        WebView.setWebContentsDebuggingEnabled(true)
    }
}
