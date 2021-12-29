package com.werockstar.dagger2demo.di.component

import com.werockstar.dagger2demo.di.PerActivity
import com.werockstar.dagger2demo.di.module.ActivityModule
import dagger.Component

@PerActivity
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent
