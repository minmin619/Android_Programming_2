package edu.utap.fling

import android.view.View

class Jump(private val puck: View,
           private val border: Border
) {
    // XXX remember some X and Y values and any other state
    // Track puck position state
    private var currentPosition = 0

    // Possible puck positions in order (Top-Left, Top-Right, Bottom-Right, Bottom-Left)
    private val positions = listOf(
        Pair(border.minX(), border.minY()),  // Top-left
        Pair(border.maxX() - puck.width, border.minY()), // Top-right
        Pair(border.maxX() - puck.width, border.maxY() - puck.height), // Bottom-right
        Pair(border.minX(), border.maxY() - puck.height) // Bottom-left
    )
    private fun placePuck() {
        // XXX Write me
        val (x, y) = positions[currentPosition]
        puck.x = x.toFloat()
        puck.y = y.toFloat()
    }
    fun start() {
        puck.visibility = View.VISIBLE
        puck.isClickable = true
        // XXX Write me
        placePuck()

        // Set click listener to move puck through predefined positions
        puck.setOnClickListener {
            currentPosition = (currentPosition + 1) % positions.size
            placePuck()
        }
    }
    fun finish() {
        // XXX Write me
        // Hide the puck when leaving the Jump mode
        puck.visibility = View.INVISIBLE
        puck.isClickable = false
    }
}