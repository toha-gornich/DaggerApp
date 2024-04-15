package com.cl.daggerapp.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.cl.daggerapp.screens.common.activities.BaseActivity

open class BaseDialog:DialogFragment() {
    private val presentationComponent by lazy{
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected  val injector get() = presentationComponent
}