package com.example.dukaan

import androidx.appcompat.app.AppCompatActivity
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