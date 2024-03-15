package com.cl.dsggerapp.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cl.dsggerapp.R
import com.cl.dsggerapp.screens.common.toolbar.MyToolbar
import com.cl.dsggerapp.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsMvc(layoutInflater: LayoutInflater, parent: ViewGroup?) :
    BaseViewMvc<QuestionDetailsMvc.Listener>(layoutInflater, parent, R.layout.layout_question_details) {
    interface Listener{
        fun onBackClicked()
    }

    private  var toolbar: MyToolbar = rootView.findViewById(R.id.toolbar)
    private  var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView


    init {
        //init toolbar

        toolbar.setNavigateUpListener {
            for (listener in listeners){
                listener.onBackClicked()
            }

        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

        txtQuestionBody = findViewById(R.id.txt_question_body)

    }

    fun bindQuestionBody(questionBody: String){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            txtQuestionBody.text = Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY)
        }else{
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody)
        }
    }
    fun showProgressIndication(){
        swipeRefresh.isRefreshing = true
    }
    fun hideProgressIndication(){
        swipeRefresh.isRefreshing = false
    }
}