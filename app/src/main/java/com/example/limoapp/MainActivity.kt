package com.example.limoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limoapp.adapter.ListMomentAdapter
import com.example.limoapp.databinding.ActivityMainBinding
import com.example.limoapp.ui.addmoment.AddMomentActivity
import com.example.limoapp.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListMomentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //VIEWMODEL
        val factory = ViewModelFactory.getInstance(this.applicationContext)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        //ADAPTER
        adapter = ListMomentAdapter()
        binding.rvComment.layoutManager = LinearLayoutManager(this)
        display()
        btnDisplay()
    }

    private fun display() {
        viewModel.dataAllMoment.observe(this) { data ->
            adapter.setData(data)
            binding.rvComment.adapter = adapter
        }
    }

    private fun btnDisplay() {
        binding.btnAddmoemnt.setOnClickListener {
            startActivity(Intent(this, AddMomentActivity::class.java))
        }
    }
}