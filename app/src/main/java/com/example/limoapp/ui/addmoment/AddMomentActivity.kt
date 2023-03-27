package com.example.limoapp.ui.addmoment

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.limoapp.databinding.ActivityAddMomentBinding
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.ui.camerax.CameraXActivity
import com.example.limoapp.utils.GetTimeNow
import com.example.limoapp.utils.ViewModelFactory

class AddMomentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMomentBinding
    private lateinit var viewModel: AddMomentViewModel

    companion object {
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMomentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //PERMISION CAMERA
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        //VIEWMODEL
        val factory = ViewModelFactory.getInstance(this.applicationContext)
        viewModel = ViewModelProvider(this, factory)[AddMomentViewModel::class.java]
        display()
        btnDisplay()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun display() {
        binding.apply {
            tvDateNow.text = "${GetTimeNow.getCurrentTime()}, Today"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun btnDisplay() {
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
        binding.btnAddmoemnt.setOnClickListener {
            startActivity(Intent(this, CameraXActivity::class.java))
        }
    }
}
