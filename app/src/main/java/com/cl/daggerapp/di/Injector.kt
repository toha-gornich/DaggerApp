package com.cl.daggerapp.di

import Service
import com.cl.daggerapp.di.PresentationCompositionRoot
import java.lang.reflect.Field
import com.cl.daggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.daggerapp.questions.FetchQuestionsUseCase
import com.cl.daggerapp.screens.common.ScreensNavigator
import com.cl.daggerapp.screens.common.dialogs.DialogsNavigator
import com.cl.daggerapp.screens.common.viewsmvc.ViewMvcFactory

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(client: Any) {
        for (field in getAllFields(client)) {
            if (isAnnotatedForInjection(field)) {
                injectField(client, field)
            }
        }
    }

    private fun getAllFields(client: Any): Array<out Field> {
        val clientClass = client::class.java
        return clientClass.declaredFields
    }

    private fun isAnnotatedForInjection(field: Field): Boolean {
        val fieldAnnotations = field.annotations
        for (annotation in fieldAnnotations) {
            if (annotation is Service) {
                return true
            }
        }
        return false
    }

    private fun injectField(client: Any, field: Field) {
        val isAccessibleInitially = field.isAccessible
        field.isAccessible = true
        field.set(client, getServiceForClass(field.type))
        field.isAccessible = isAccessibleInitially
    }

    private fun getServiceForClass(type: Class<*>): Any {
        when (type) {
            DialogsNavigator::class.java -> {
                return compositionRoot.dialogsNavigator
            }
            ScreensNavigator::class.java -> {
                return compositionRoot.screensNavigator
            }
            FetchQuestionsUseCase::class.java -> {
                return compositionRoot.fetchQuestionsUseCase
            }
            FetchQuestionDetailsUseCase::class.java -> {
                return compositionRoot.fetchQuestionDetailsUseCase
            }
            ViewMvcFactory::class.java -> {
                return compositionRoot.viewMvcFactory
            }
            else -> {
                throw Exception("unsupported service type: $type")
            }
        }
    }


}