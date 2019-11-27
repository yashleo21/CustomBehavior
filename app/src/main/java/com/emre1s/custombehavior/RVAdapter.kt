package com.emre1s.custombehavior

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_itemone.view.*

class RVAdapter(datax: List<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderOne).setData(position)
    }

    val data = datax
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOne {
        return ViewHolderOne(LayoutInflater.from(parent.context).inflate(R.layout.rv_itemone, parent, false))
    }

    override fun getItemCount(): Int {
        if (data.isNullOrEmpty()) {
            return 0
        } else {
            return data.size
        }
    }

    inner class ViewHolderOne(val view: View): RecyclerView.ViewHolder(view) {
        fun setData(position: Int) {
            view.tv_number.text = " NUM ${data[position]}"
        }
    }

    inner class ViewHolderTwo(val view: View): RecyclerView.ViewHolder(view) {
        fun setData(position: Int) {
            view.tv_number.text = " NUM ${data[position]}"
        }
    }

    inner class ViewHolderThree(val view: View): RecyclerView.ViewHolder(view) {
        fun setData(position: Int) {
            view.tv_number.text = " NUM ${data[position]}"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}