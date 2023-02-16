package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calList: ArrayList<Double>
    private lateinit var adapterCal: AdapterCal
    public var testList: ArrayList<Double> = ArrayList()
    public var sum: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        loadCal()
        binding.calculateButton.setOnClickListener {
            var txData = binding.costOfService.text.toString()
            var txRadio = binding.tipOptions.checkedRadioButtonId
            var twenty = ((txData.toInt() * 20)/100).toString()
            var eightty = ((txData.toInt() * 80)/100).toString()
            var fifteen = ((txData.toInt() * 15)/100).toString()
            when(txRadio) {
                binding.optionTwentyPercent.id -> {
                    sum = twenty.toDouble()
                    binding.tipResult.text ="${twenty.toDouble()}"
                }
                binding.optionEighteenPercent.id -> {
                    sum = eightty.toDouble()
                    binding.tipResult.text = "${eightty.toDouble()}"
                }
                binding.optionFifteenPercent.id ->{
                    sum = fifteen.toDouble()
                    binding.tipResult.text = "${fifteen.toDouble()}"
                }
            }
            calList.add(sum)
            adapterCal.notifyDataSetChanged()
        }

    }

    private fun loadCal() {
        calList = ArrayList()
        calList.clear()
        adapterCal = AdapterCal(this, calList)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycleview.adapter = adapterCal
        binding.recycleview.layoutManager = layoutManager
        binding.recycleview.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )
    }
}