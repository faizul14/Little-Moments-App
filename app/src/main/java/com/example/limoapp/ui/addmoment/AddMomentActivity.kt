package com.example.limoapp.ui.addmoment

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
import com.example.limoapp.utils.rotateBitmap
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class AddMomentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMomentBinding
    private lateinit var viewModel: AddMomentViewModel
    private var myFileSave: File? = null

    companion object {
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this, "Tidak mendapatkan permission.", Toast.LENGTH_SHORT
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
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
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
//            val dataMoment = DataModel(
//                comment = "Lorem Ipsum Dolor Is Amet, Lorem ipsum dolor is amset, Lipsum",
//                path = "home//pat",
//                time = GetTimeNow.getCurrentTime().toString(),
//                emoji = "smile"
//
//            )

            if (checkValidation()){
                val dataMoment = DataModel(
                    comment = binding.txtComment.text.toString(),
                    path = myFileSave?.let { it1 -> saveImage(it1) },
                    time = GetTimeNow.getCurrentTime().toString(),
                    emoji = "smile"

                )
                viewModel.setSaveMoment(dataMoment)
                finish()
            }
        }
        binding.btnAddmoemnt.setOnClickListener {
            launcherIntentCameraX.launch(Intent(this, CameraXActivity::class.java))
        }
    }

    private fun checkValidation(): Boolean{
        if (binding.txtComment.text?.isEmpty() == true){
            binding.txtComment.error = "Isi Dulu Deskripsinya!"
            return false
        }
        return if (binding.txtComment.text?.isNotEmpty() == true && myFileSave != null) true else false
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            myFileSave = myFile
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean
            val result = rotateBitmap(
                BitmapFactory.decodeFile(myFile.path),
                isBackCamera
            )
            binding.imgMoment.apply {
                setImageBitmap(result)
                visibility = View.VISIBLE
            }
        }
    }

    private fun saveImage(myFile: File): String {
        // Create a directory based on the current date
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val targetDir = File(getExternalFilesDir(null), currentDate)
        targetDir.mkdir()

        // Create a new file with a unique name based on the current date and time
        val currentTime = SimpleDateFormat("HH-mm-ss", Locale.getDefault()).format(Date())
        val fileName = "image_${currentDate}_${currentTime}.jpg"
        val targetFile = File(targetDir, fileName)

        // Copy the image file to the new directory
        myFile.copyTo(targetFile)

        // Show a toast message indicating the file has been saved
        Toast.makeText(this, "Image saved!", Toast.LENGTH_SHORT).show()

        // Return the path of the saved image file
        return targetFile.absolutePath
    }


}
