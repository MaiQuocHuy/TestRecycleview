package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.RowCalculatorBinding

class AdapterCal: Adapter<AdapterCal.HolderCal> {
    private lateinit var binding: RowCalculatorBinding
    private val context: Context
    public val listcal: ArrayList<Double>

    constructor(context: Context, listCal: ArrayList<Double>) {
        this.context = context
        this.listcal = listCal
    }

    inner class HolderCal(itemView: View): ViewHolder(itemView) {
        var txCals: TextView = binding.txCal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCal {
        binding = RowCalculatorBinding.inflate(LayoutInflater.from(context), parent, false)
        return HolderCal(binding.root)
    }

    override fun onBindViewHolder(holder: HolderCal, position: Int) {
       val model = listcal[position]
       val id = model
       holder.txCals.text = id.toString()
    }

    override fun getItemCount(): Int {
        return listcal.size
    }
}