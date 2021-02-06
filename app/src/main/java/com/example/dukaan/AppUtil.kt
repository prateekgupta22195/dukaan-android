package com.example.dukaan

import android.content.Context
import android.text.Spannable
import android.text.style.TextAppearanceSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import java.lang.IllegalStateException

fun AppCompatActivity.hideFragment(fragment: Fragment?) {
    fragment?.let {
        this.supportFragmentManager.beginTransaction().hide(it).commit()
    }?: kotlin.run {
        throw IllegalStateException("Fragment in null")
    }
}

fun AppCompatActivity.showFragment(fragment: Fragment?) {
    fragment?.let {
        supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).show(it).commit()
    }?: kotlin.run {
        throw IllegalStateException("Fragment in null")
    }
}



fun AppCompatActivity.addFragment(fragment: Fragment?, tag : String, resId : Int) {
    fragment?.let {
        supportFragmentManager.beginTransaction().add(resId, it, tag).commit()
    }?: kotlin.run {
        throw IllegalStateException("Fragment in null")
    }
}

fun Context.getSpannableAmount(rupees : Int) : Spannable {
    val text  = "₹$rupees".toSpannable()
    text.setSpan(
        TextAppearanceSpan(this, R.style.TextStyle12),
        0,
        1,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    text.setSpan(
        TextAppearanceSpan(this, R.style.TextStyle13),
        1,
        text.length-1,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return text
}