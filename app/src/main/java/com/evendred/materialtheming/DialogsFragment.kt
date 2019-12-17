package com.evendred.materialtheming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_dialogs.*

class DialogsFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        simpleDialogButton.setOnClickListener { simpleDialogButton() }
        titledDialogButton.setOnClickListener { titledDialogButton() }
        longActionDialogButton.setOnClickListener { longActionDialogButton() }
    }

    private fun simpleDialogButton() {
        MaterialAlertDialogBuilder(context)
            .setMessage("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna wirl aliqua. Ut enim ad minim ikad veniam, quis nostrud exercitatn ullamco laboris nisi ut aliquip exlaborum incididunt.")
            .setPositiveButton("Button", null)
            .setNegativeButton("Button", null)
            .show()
    }

    private fun titledDialogButton() {
        MaterialAlertDialogBuilder(context)
            .setTitle("Permissions")
            .setMessage("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna wirl aliqua. Ut enim ad minim ikad veniam, quis nostrud exercitatn ullamco laboris nisi ut aliquip exlaborum incididunt.")
            .setPositiveButton("Button", null)
            .setNegativeButton("Button", null)
            .show()
    }

    private fun longActionDialogButton() {
        MaterialAlertDialogBuilder(context)
            .setTitle("Permissions")
            .setMessage("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna wirl aliqua. Ut enim ad minim ikad veniam, quis nostrud exercitatn ullamco laboris nisi ut aliquip exlaborum incididunt.")
            .setPositiveButton("Super very long action button", null)
            .setNegativeButton("Button", null)
            .show()
    }
}