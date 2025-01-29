package edu.utap.fling

import android.view.View

class Jump(private val puck: View,
           private val border: Border
) {
    // XXX remember some X and Y values and any other state

    private fun placePuck() {
        // XXX Write me
    }
    fun start() {
        puck.visibility = View.VISIBLE
        puck.isClickable = true
        // XXX Write me
    }
    fun finish() {
        // XXX Write me
    }
}