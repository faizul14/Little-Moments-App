package com.example.limoapp.ui.addmoment

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.limoapp.R
import com.example.limoapp.databinding.ActivityAddMomentBinding
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.utils.GetTimeNow
import com.example.limoapp.utils.ViewModelFactory

class AddMomentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMomentBinding
    private lateinit var viewModel: AddMomentViewModel
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMomentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //VIEWMODEL
        val factory = ViewModelFactory.getInstance(this.applicationContext)
        viewModel = ViewModelProvider(this, factory)[AddMomentViewModel::class.java]
        display()
        btnDisplay()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun display(){
        binding.apply {
            tvDateNow.setText("${GetTimeNow.getCurrentTime()}, Today")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun btnDisplay(){
        binding.btnSave.setOnClickListener {
            val dataMoment = DataModel(
                comment = "Lorem Ipsum Dolor Is Amet, Lorem ipsum dolor is amset, Lipsum",
                path = "home//pat",
                time = GetTimeNow.getCurrentTime().toString(),
                emoji = "smile"

            )
            viewModel.setSaveMoment(dataMoment)
            finish()
        }
    }
}
