package com.example.limoapp

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
    private val PERMISSIONS_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memeriksa apakah aplikasi memiliki izin akses
        if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED
        ) {

            // Jika tidak memiliki izin akses, maka meminta izin akses
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), PERMISSIONS_REQUEST_CODE
            )

        } else {

            // Jika sudah memiliki izin akses, maka menjalankan kode utama
            firstSet()

        }
    }

    // Menangani hasil dari permintaan izin akses
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // Jika izin akses diberikan, maka menjalankan kode utama
                firstSet()

            } else {

                // Jika izin akses tidak diberikan, maka menampilkan pesan
                Toast.makeText(
                    this, "Izin akses diperlukan untuk menjalankan aplikasi", Toast.LENGTH_SHORT
                ).show()

                // Menutup aplikasi
                finish()
            }
        }
    }

    private fun firstSet() {
        // VIEWMODEL
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