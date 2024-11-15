package com.example.animation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var card: CardView
    private lateinit var rotateButton: Button
    private lateinit var scaleButton: Button
    private lateinit var translateButton: Button
    private lateinit var slideUpButton: Button
    private lateinit var slideDownButton: Button
    private lateinit var slideLeftButton: Button
    private lateinit var slideRightButton: Button
    private lateinit var fadeInButton: Button
    private lateinit var fadeOutButton: Button
    private lateinit var zoomInButton: Button
    private lateinit var zoomOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card = findViewById(R.id.imgvw)
        rotateButton = findViewById(R.id.Rotate)
        scaleButton = findViewById(R.id.Scale)
        translateButton = findViewById(R.id.translate)
        slideUpButton = findViewById(R.id.SlideUp)
        slideDownButton = findViewById(R.id.SlideDown)
        slideLeftButton = findViewById(R.id.SlideLeft)
        slideRightButton = findViewById(R.id.SlideRight)
        fadeInButton = findViewById(R.id.btnFadeIn)
        fadeOutButton = findViewById(R.id.btnFadeOut)
        zoomInButton = findViewById(R.id.zoomIn)
        zoomOutButton = findViewById(R.id.zoomOut)

        zoomOutButton.setOnClickListener {
            val animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            card.startAnimation(animZoomOut)
        }

        zoomInButton.setOnClickListener {
            val animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            card.startAnimation(animZoomIn)
        }

        fadeInButton.setOnClickListener {
            val animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            card.startAnimation(animFadeIn)
        }

        fadeOutButton.setOnClickListener {
            val animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            card.startAnimation(animFadeOut)
        }

        slideUpButton.setOnClickListener {
            val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            card.startAnimation(slideUp)
        }

        slideDownButton.setOnClickListener {
            val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            card.startAnimation(slideDown)
        }

        slideLeftButton.setOnClickListener {
            val slideLeft = AnimationUtils.loadAnimation(this, R.anim.slide_left)
            card.startAnimation(slideLeft)
        }

        slideRightButton.setOnClickListener {
            val slideRight = AnimationUtils.loadAnimation(this, R.anim.slide_right)
            card.startAnimation(slideRight)
        }

        rotateButton.setOnClickListener {
            rotater()
        }

        translateButton.setOnClickListener {
            translater()
        }

        scaleButton.setOnClickListener {
            scaler()
        }
    }

    private fun rotater() {
        val animator = ObjectAnimator.ofFloat(card, CardView.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.start()
    }

    private fun translater() {
        val animator = ObjectAnimator.ofFloat(card, CardView.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.duration = 1500
        animator.start()
    }

    private fun scaler() {
        val scaleX = PropertyValuesHolder.ofFloat(CardView.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(CardView.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(card, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.duration = 1500
        animator.start()
    }
}
