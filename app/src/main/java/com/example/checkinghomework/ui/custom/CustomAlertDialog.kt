package com.example.checkinghomework.ui.custom

import android.app.Dialog
import android.view.View
import com.example.checkinghomework.databinding.DialogLayoutBinding
import android.view.Window
import androidx.fragment.app.Fragment
import javax.inject.Inject

class CustomAlertDialog @Inject constructor() {

    private lateinit var binding: DialogLayoutBinding
    private var dialog: Dialog? = null

    fun showDialog(fragment: Fragment) {
        binding = DialogLayoutBinding.inflate(fragment.layoutInflater)
        val view = binding.root
        initDialog(fragment, view)
        initListener()

        dialog?.show()
    }

    private fun initDialog(fragment: Fragment, view: View) {
        dialog = fragment.context?.let { Dialog(it) }
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(view)
    }

    private fun initListener() {
        binding.btnDialog.setOnClickListener {
            dialog?.dismiss()
        }
    }

}