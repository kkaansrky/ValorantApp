package com.kkaansrky.valorantapp.ui.main

import android.app.Application
import com.deliveryhero.whetstone.SingleIn
import com.deliveryhero.whetstone.app.ApplicationComponent
import com.deliveryhero.whetstone.app.ApplicationScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton // Optional. Can be omitted if you never use this annotation
@SingleIn(ApplicationScope::class)
@MergeComponent(ApplicationScope::class)
interface ValorantApplicationComponent : ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application, // this is necessary for whetstone to set things up properly
        ): ValorantApplicationComponent
    }
}
