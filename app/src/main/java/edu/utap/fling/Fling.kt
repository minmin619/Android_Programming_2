package edu.utap.fling

import android.annotation.SuppressLint
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation


class Fling(private val puck: View,
            private val border: Border,
            private val testing: Boolean
)  {
    private val puckMinX = border.minX().toFloat()
    private val puckMaxX = (border.maxX() - puck.width).toFloat()
    private val puckMinY= border.minY().toFloat()
    private val puckMaxY = (border.maxY() - puck.height).toFloat()
    private val friction = 3.0f
    private var goalBorder = Border.Type.T
    private lateinit var flingAnimationX: FlingAnimation
    private lateinit var flingAnimationY: FlingAnimation

    private fun placePuck() {
        if (testing) {
            puck.x = ((border.maxX() - border.minX()) / 2).toFloat()
            puck.y = ((border.maxY() - border.minY()) / 2).toFloat()
        } else {
            // XXX Write me
        }
        // If puck had been made invisible, make it visible now
        puck.visibility = View.VISIBLE
    }

    private fun success(goalAchieved: () -> Unit) {
        // XXX Write me
    }

    fun makeXFlingAnimation(initVelocity: Float,
                            goalAchieved: () -> Unit): FlingAnimation {
        return FlingAnimation(puck, DynamicAnimation.X)
            .setFriction(friction)
            // XXX Write me
    }

    fun makeYFlingAnimation(initVelocity: Float,
                            goalAchieved: () -> Unit): FlingAnimation {
        //Log.d("XXX", "Fling Y vel $initVelocity")
        return FlingAnimation(puck, DynamicAnimation.Y)
            .setFriction(friction)
            // XXX Write me
    }

    @SuppressLint("ClickableViewAccessibility")
    fun listenPuck(goalAchieved: ()->Unit) {
        // A SimpleOnGestureListener notifies us when the user puts their
        // finger down, and when they edu.utap.edu.utap.fling.
        // Note that here we construct the listener object "on the fly"
        val gestureListener = object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent): Boolean {
                return true
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                // XXX Write me
                return true
            }
        }

        val gestureDetector = GestureDetector(puck.context, gestureListener)
        // When Android senses that the puck is being touched, it will call this code
        // with a motionEvent object that describes the motion.  Our detector
        // will take sequences of motion events and send them to the gesture listener to
        // let us know what the user is doing.
        puck.setOnTouchListener { _, motionEvent ->
            gestureDetector.onTouchEvent(motionEvent)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun deactivatePuck() {
        // XXX Write me
    }

    fun playRound(goalAchieved: () -> Unit) {
        // XXX Write me
    }
}