package com.cl.daggerapp.screens.common.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import com.cl.daggerapp.R

class ServerErrorDialogFragment : BaseDialog(){

    override fun onCreateDialog(savedInstanceState: Bundle?):Dialog{
        return AlertDialog.Builder(activity).let{
            it.setTitle(R.string.server_error_dialog_title)
            it.setMessage(R.string.server_error_dialog_message)
            it.setPositiveButton(R.string.server_error_dialog_button_caption) { _, _ -> dismiss() }
            it.create()
        }
    }
    companion object{
        fun  newInstance(): ServerErrorDialogFragment{
            return ServerErrorDialogFragment()
        }
    }
}