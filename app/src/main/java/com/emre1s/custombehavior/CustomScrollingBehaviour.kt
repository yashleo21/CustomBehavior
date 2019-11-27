package com.emre1s.custombehavior

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomScrollingBehaviour(context: Context, attributeSet: AttributeSet):
    CoordinatorLayout.Behavior<View>(context, attributeSet) {

    var a = false
    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        Log.d("Emre1s", "$dependency asdsadsad")
        return dependency is RecyclerView
    }

//    override fun onStartNestedScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: View,
//        directTargetChild: View,
//        target: View,
//        axes: Int,
//        type: Int
//    ): Boolean {
//        return true
//    }

//    override fun onNestedPreScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: View,
//        target: View,
//        dx: Int,
//        dy: Int,
//        consumed: IntArray,
//        type: Int
//    ) {
//        Log.d("Emre1s PRESCROLL", "A $coordinatorLayout /A  B$child /B  C$target /C   D$dx /D  E$dy /E    F$consumed /F    G$type /G")
//        target as RecyclerView
//        val lm = target.layoutManager as LinearLayoutManager
//        target.adapter as RVAdapter
//        Log.d("Emre1s POSSS", "${lm.findFirstCompletelyVisibleItemPosition()}")
//        val itemPos = lm.findFirstCompletelyVisibleItemPosition()
//        if (itemPos >= 8) {
//            a = true
//            ObjectAnimator.ofFloat(child, "translationY", 150f).apply {
//                duration = 500
//                start()
//            }
//        } else if (a) {
//            a = false
//            ObjectAnimator.ofFloat(child, "translationY", -150f).apply {
//                duration = 500
//                start()
//            }
//        }
//       // child.scaleY = (target as RecyclerView).computeVerticalScrollOffset() + 0f
//    }
    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        Log.d("Emre1s", "$dependency $parent asdsadsadsa")
    dependency as RecyclerView
    val lm = dependency.layoutManager as LinearLayoutManager
    dependency.adapter as RVAdapter
    Log.d("Emre1s POSSS", "${lm.findFirstCompletelyVisibleItemPosition()}")
    val itemPos = lm.findFirstCompletelyVisibleItemPosition()
    if (itemPos >= 8) {
        a = true
        ObjectAnimator.ofFloat(child, "translationY", 150f).apply {
            duration = 500
            start()
        }
    } else if (a) {
        a = false
        ObjectAnimator.ofFloat(child, "translationY", -150f).apply {
            duration = 500
            start()
        }
    }
//        val translationY = Math.min(0f, dependency.translationY - dependency.height)
//        child.translationY = translationY
       return true
    }
}