package com.example.limoapp.ui.addmoment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import androidx.lifecycle.ViewModelProvider
import com.example.limoapp.R
import com.example.limoapp.databinding.ActivityAddMomentBinding
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.utils.ViewModelFactory

class AddMomentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMomentBinding
    private lateinit var viewModel: AddMomentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMomentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //VIEWMODEL
        val factory = ViewModelFactory.getInstance(this.applicationContext)
        viewModel = ViewModelProvider(this, factory)[AddMomentViewModel::class.java]
        display()
    }

    private fun display(){
        binding.btnSave.setOnClickListener {
            val dataMoment = DataModel(
                comment = "Lorem Ipsum Dolor Is Amet, Lorem ipsum dolor is amset, Lipsum",
                path = "home//pat",
                time = "08:40",
                emoji = "smile"

            )
            viewModel.setSaveMoment(dataMoment)
        }
    }
}
