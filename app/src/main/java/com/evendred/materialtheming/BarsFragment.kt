package com.evendred.materialtheming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_bars.*

class BarsFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        simpleSnackBarButton.setOnClickListener { simpleSnackBarButton() }
        twoLinesSnackBarButton.setOnClickListener { twoLinesSnackBarButton() }
        twoLinesSnackBarWithLongerActionButton.setOnClickListener { twoLinesSnackBarWithLongerActionButton() }
    }

    private fun simpleSnackBarButton() {
        Snackbar.make(coordinator, "Single line message with action", Snackbar.LENGTH_LONG)
            .setAction("Action") {}
            .show()
    }

    private fun twoLinesSnackBarButton() {
        Snackbar.make(coordinator, "Two lines message\nwith action", Snackbar.LENGTH_LONG)
            .setAction("Action") {}
            .show()
    }

    private fun twoLinesSnackBarWithLongerActionButton() {
        Snackbar.make(coordinator, "Two lines message\nwith action", Snackbar.LENGTH_LONG)
            .setAction("Longer Action Text") {}
            .show()
    }
}