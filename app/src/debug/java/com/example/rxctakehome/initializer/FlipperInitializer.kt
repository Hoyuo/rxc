package com.example.rxctakehome.initializer

import android.content.Context
import androidx.startup.Initializer
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

class FlipperInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        SoLoader.init(context, false)

        val descriptorMapping = DescriptorMapping.withDefaults()

        val hilt = EntryPointAccessors.fromApplication(context, InitializerEntry::class.java)

        AndroidFlipperClient.getInstance(context).apply {
            addPlugin(LeakCanary2FlipperPlugin())

            addPlugin(InspectorFlipperPlugin(context, descriptorMapping))
            addPlugin(hilt.networkFlipperPlugin())
            addPlugin(NavigationFlipperPlugin.getInstance())
            addPlugin(CrashReporterPlugin.getInstance())
            addPlugin(LeakCanary2FlipperPlugin())
            addPlugin(DatabasesFlipperPlugin(context))
            addPlugin(SharedPreferencesFlipperPlugin(context))
            start()
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface InitializerEntry {
        fun networkFlipperPlugin(): NetworkFlipperPlugin
    }
}
