package com.cl.daggerapp.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cl.daggerapp.screens.questiondetails.QuestionDetailsViewMvc
import com.cl.daggerapp.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(private val layoutInflater: LayoutInflater){

    fun newQuestionsListViewMvc(parent:ViewGroup?):QuestionsListViewMvc{
        return QuestionsListViewMvc(layoutInflater,parent)
    }
    fun newQuestionDetailsViewMvc(parent:ViewGroup?):QuestionDetailsViewMvc{
        return QuestionDetailsViewMvc(layoutInflater,parent)
    }

}