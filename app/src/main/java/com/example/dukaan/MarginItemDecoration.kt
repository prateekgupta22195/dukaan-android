package com.example.dukaan

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val marginVertical: Int, private val marginHorizontal : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            left =  marginHorizontal
            right = marginHorizontal
            bottom = marginVertical
        }
    }
}