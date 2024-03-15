package com.cl.dsggerapp.screens.questionslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cl.dsggerapp.R
import com.cl.dsggerapp.questions.Question
import com.cl.dsggerapp.screens.common.viewsmvc.BaseViewMvc

class QuestionsListViewMvc (
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
): BaseViewMvc<QuestionsListViewMvc.Listener>(layoutInflater, parent, R.layout.layout_questions_list) {
    interface Listener{
        fun onRefreshClicked()
        fun onQuestionClicked(clickedQuestion: Question)
    }
    private val swipeRefresh: SwipeRefreshLayout = rootView.findViewById(R.id.swipeRefresh)
    private val recyclerView: RecyclerView
    private val questionsAdapter:QuestionsAdapter



    init {

        // init pull-down-to-refresh
        swipeRefresh.setOnRefreshListener {
            for(listener in listeners){
                listener.onRefreshClicked()
            }
        }

        // init recycler view
        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        questionsAdapter = QuestionsAdapter {clickedQuestion->
            for(listener in listeners){
                listener.onQuestionClicked(clickedQuestion)
            }
        }
        recyclerView.adapter = questionsAdapter
    }
    fun bindQuestion(questions: List<Question>) {
        questionsAdapter.bindData(questions)

    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }



    class QuestionsAdapter(
        private val onQuestionClickListener: (Question) -> Unit
    ) : RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>() {

        private var questionsList: List<Question> = java.util.ArrayList(0)

        inner class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.txt_title)
        }

        fun bindData(questions: List<Question>) {
            questionsList = ArrayList(questions)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_question_list_item, parent, false)
            return QuestionViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
            holder.title.text = questionsList[position].title
            holder.itemView.setOnClickListener {
                onQuestionClickListener.invoke(questionsList[position])
            }
        }

        override fun getItemCount(): Int {
            return questionsList.size
        }

    }
}