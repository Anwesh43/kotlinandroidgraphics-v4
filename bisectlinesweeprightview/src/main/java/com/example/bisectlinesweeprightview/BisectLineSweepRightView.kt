package com.example.bisectlinesweeprightview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Color
import android.graphics.Canvas
import android.app.Activity
import android.content.Context

val colors : Array<String> = arrayOf(
    "#1A237E",
    "#EF5350",
    "#AA00FF",
    "#C51162",
    "#00C853"
)
val parts : Int = 3
val scGap : Float = 0.03f / parts
val strokeFactor : Float = 90f
val sizeFactor : Float = 4.9f
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")
val rot : Float = 60f
val rFactor : Float = 8.9f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawXY(x : Float, y : Float, cb : () -> Unit) {
    save()
    translate(x, y)
    cb()
    restore()
}

fun Canvas.drawBisectLineSweepRight(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val dsc : (Int) -> Float = {
        scale.divideScale(it, parts)
    }
    val r : Float = size / rFactor
    drawXY(w / 2 + (w / 2) * dsc(2), h / 2) {
        for (j in 0..Math.floor(dsc(0).toDouble()).toInt()) {
            drawXY(size / 2, 0f) {
                scale(1f - 2 * j, 1f - 2 * j)
                drawXY(-size / 2, 0f) {
                    drawXY(0f, 0f) {
                        rotate(-rot * dsc(1))
                        drawLine(0f, 0f, size * dsc(0), 0f, paint)
                    }
                    drawArc(RectF(-r, -r, r, r), -rot * dsc(1), rot * dsc(1), false, paint)
                }
            }
        }
    }
}

fun Canvas.drawBLSRNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.style = Paint.Style.STROKE
    drawBisectLineSweepRight(scale, w, h, paint)
}
