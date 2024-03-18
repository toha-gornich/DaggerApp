package com.cl.dsggerapp.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cl.dsggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.dsggerapp.screens.common.dialogs.ServerErrorDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

class QuestionDetailsActivity : AppCompatActivity(), QuestionDetailsMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase

    private lateinit var questionId: String
    private lateinit var viewMvc: QuestionDetailsMvc


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewMvc = QuestionDetailsMvc(LayoutInflater.from(this), null)
        setContentView(viewMvc.rootView)


        //retrieve question ID passed from outside
        questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!

        fetchQuestionDetailsUseCase = FetchQuestionDetailsUseCase()
    }

    override fun onStart() {
        super.onStart()
        fetchQuestionDetails()
        viewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)

    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionDetailsUseCase.fetchDetailQuestion(questionId)) {
                    is FetchQuestionDetailsUseCase.Result.Success -> {
                        val questionBody = result.question
                        viewMvc.bindQuestionBody(questionBody!!)
                    }

                    is FetchQuestionDetailsUseCase.Result.Failure -> {
                        onFetchFailed()
                    }
                }


            } finally {
                viewMvc.hideProgressIndication()

            }

        }
    }

    private fun onFetchFailed() {
        supportFragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }


    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"

        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }

    override fun onBackClicked() {
        onBackPressed()
    }
}