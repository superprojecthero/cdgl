package com.bawei.superhero.utils

import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Shader

import com.squareup.picasso.Transformation

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/28 09:52
 */

class RoundTransform(private val radius: Int//圆角值
) : Transformation {

    override fun transform(source: Bitmap): Bitmap {
        val width = source.width
        val height = source.height
        //画板
        val bitmap = Bitmap.createBitmap(width, height, source.config)
        val paint = Paint()
        val canvas = Canvas(bitmap)//创建同尺寸的画布
        paint.isAntiAlias = true//画笔抗锯齿
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        //画圆角背景
        val rectF = RectF(Rect(0, 0, width, height))//赋值
        canvas.drawRoundRect(rectF, radius.toFloat(), radius.toFloat(), paint)//画圆角矩形
        //
        paint.isFilterBitmap = true
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(source, 0f, 0f, paint)
        source.recycle()//释放

        return bitmap
    }

    override fun key(): String {
        return "round : radius = " + radius
    }
}
