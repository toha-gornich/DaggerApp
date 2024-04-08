package com.cl.daggerapp.screens.questionslist

import android.os.Bundle
import com.cl.daggerapp.questions.FetchQuestionsUseCase
import com.cl.daggerapp.questions.FetchQuestionsUseCase.*
import com.cl.daggerapp.questions.Question
import com.cl.daggerapp.screens.common.ScreensNavigator
import com.cl.daggerapp.screens.common.activities.BaseActivity
import com.cl.daggerapp.screens.common.dialogs.DialogsNavigator
import com.cl.daggerapp.screens.common.viewsmvc.ViewMvcFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestionsListActivity : BaseActivity(), QuestionsListViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject  lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    @Inject  lateinit var dialogsNavigator: DialogsNavigator
    @Inject  lateinit var screensNavigator: ScreensNavigator
    @Inject  lateinit var viewMvcFactory: ViewMvcFactory

    private lateinit var viewMvc: QuestionsListViewMvc

    private var isDataLoaded = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        viewMvc = viewMvcFactory.newQuestionsListViewMvc( null)
        setContentView(viewMvc.rootView)
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        screensNavigator.toQuestionDetails(clickedQuestion.id)
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionsUseCase.fetchLatestQuestions()) {
                    is Result.Success -> {
                        viewMvc.bindQuestion(result.questions)
                        isDataLoaded = true
                    }

                    is Result.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()

    }


}