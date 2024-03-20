package com.cl.dsggerapp.screens.questionslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.cl.dsggerapp.MyApplication
import com.cl.dsggerapp.questions.FetchQuestionsUseCase
import com.cl.dsggerapp.questions.FetchQuestionsUseCase.*
import com.cl.dsggerapp.questions.Question
import com.cl.dsggerapp.screens.common.ScreensNavigator
import com.cl.dsggerapp.screens.common.dialogs.DialogsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

class QuestionsListActivity : AppCompatActivity(), QuestionsListViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)


    private lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    private lateinit var dialogsNavigator: DialogsNavigator

    private lateinit var screensNavigator: ScreensNavigator

    private var isDataLoaded = false
    private lateinit var viewMvc: QuestionsListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewMvc = QuestionsListViewMvc(LayoutInflater.from(this), null)
        setContentView(viewMvc.rootView)

        fetchQuestionsUseCase = (application as MyApplication).fetchQuestionsUseCase
        dialogsNavigator = DialogsNavigator(supportFragmentManager)
        screensNavigator = ScreensNavigator(this)
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