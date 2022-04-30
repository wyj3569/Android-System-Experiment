package com.example.example03

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.example03.databinding.ActivityMainBinding
import java.lang.Exception

const val GALLERY = 1

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var bitmap : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)

            val resize = resizeBitmap(bitmap!!, 300, 300)
            intent.putExtra("image", resize)
            intent.putExtra("name", binding.nameEt.text.toString())
            intent.putExtra("age", binding.ageEt.text.toString())
            intent.putExtra("phone", binding.phoneEt.text.toString())
            intent.putExtra("address", binding.addressEt.text.toString())
            intent.putExtra("memo", binding.memoEt.text.toString())

            startActivityForResult(intent, 10)
            resetEditText()
        }

        // ImageView
        // 이미지 뷰를 클릭할 수 있게 함
        binding.photo.isClickable = true
        binding.photo.setOnClickListener {
            openGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                // 갤러리 인텐트에 대한 처리
                GALLERY -> {
                    var imageData = data?.data
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageData)
                        binding.photo.setImageBitmap(bitmap)
                    } catch (e : Exception) {
                        e.printStackTrace()
                    }
                }

            }
        }
    }

    private fun resetEditText() {
        binding.nameEt.text = null
        binding.ageEt.text = null
        binding.phoneEt.text = null
        binding.addressEt.text = null
        binding.memoEt.text = null
    }

    private fun openGallery() {
        val intent : Intent = Intent(Intent.ACTION_GET_CONTENT)
        // 인텐트의 형식을 지정해줌 : URI 반환
        intent.setType("image/*")
        // GALLERY : 갤러리에 대한 Intent임을 구별해줌
        startActivityForResult(intent, GALLERY)
    }

    // 비트맵의 높이와 넓이를 .createScaledBitmap을 통해 재조정하는 함수를 구현
    private fun resizeBitmap(bitmap : Bitmap, width : Int, height : Int) : Bitmap {
        return Bitmap.createScaledBitmap(
            bitmap,
            height,
            width,
            false
        )
    }
}