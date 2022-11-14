package com.kkaansrky.valorantapp.ui.main

import android.app.Application
import com.deliveryhero.whetstone.Whetstone
import com.deliveryhero.whetstone.app.ApplicationComponentOwner
import com.deliveryhero.whetstone.app.ContributesAppInjector

@ContributesAppInjector(generateAppComponent = true)
class ValorantAppApplication : Application(), ApplicationComponentOwner {

    override val applicationComponent by lazy { GeneratedApplicationComponent.create(this)}

    override fun onCreate() {
        Whetstone.inject(this)
        super.onCreate()
    }
}