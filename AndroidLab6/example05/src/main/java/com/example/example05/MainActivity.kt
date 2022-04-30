package com.example.example05

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.example05.databinding.ActivityMainBinding
import java.lang.Exception

const val GALLERY = 1
const val SUBACTIVITY = 2

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    // 갤러리로부터 얻은 Uri의 Bitmap
    var bitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 자소서 버튼을 누르면 데이터를 담은 인텐트를 서브액티비티로 보냄
        binding.biographyBtn.setOnClickListener {
            if (bitmap == null) {
                Toast.makeText(this, "프로필 사진을 등록해주세요!", Toast.LENGTH_SHORT).show()
            } else if (binding.korNameEt.text.isEmpty()) {
                Toast.makeText(this, "한글 이름을 등록해주세요!", Toast.LENGTH_SHORT).show()
            } else if (binding.engNameEt.text.isEmpty()) {
                Toast.makeText(this, "영어 이름을 등록해주세요!", Toast.LENGTH_SHORT).show()
            } else if (binding.phoneEt.text.isEmpty()) {
                Toast.makeText(this, "연락처를 등록해주세요!", Toast.LENGTH_SHORT).show()
            } else if (binding.emailEt.text.isEmpty()) {
                Toast.makeText(this, "이메일을 등록해주세요!", Toast.LENGTH_SHORT).show()
            }  else if (binding.addressEt.text.isEmpty()) {
                Toast.makeText(this, "주소를 등록해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SubActivity::class.java)

                // Bitmap의 사이즈를 바꾼다. (해당 과정을 진행하지 않을 경우 인텐트를 통해 이미지를 SubActivity로 전달할 때 용량초과로 에러가 발생할 수 있다.)
                var resize = resizeBitmap(bitmap!!, 300, 300)
                // 인텐트에 정보를 넣는다.
                intent.putExtra("resize",       resize)
                intent.putExtra("korName",      binding.korNameEt.text.toString())
                intent.putExtra("engName",      binding.engNameEt.text.toString())
                intent.putExtra("phoneNumber",  binding.phoneEt.text.toString())
                intent.putExtra("eMail",        binding.emailEt.text.toString())
                intent.putExtra("address",      binding.addressEt.text.toString())
                startActivityForResult(intent, SUBACTIVITY)
            }
        }

        // 이미지뷰를 누르면 갤러리 액티비티를 실행하고
        // 갤러리 액티비티가 종료되고 메인 액티비티로 넘어오면
        // onActivityResult() 콜백 함수가 실행되고 이미지뷰의 사진을 갤러리에서 선택된 사진으로 변경
        binding.profileIv.isClickable = true
        binding.profileIv.setOnClickListener {
            openGallery()
        }
    }

    // 인텐트로 갤러리를 실행
    private fun openGallery() {
        val intent : Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, GALLERY)
    }

    private fun resizeBitmap(bitmap : Bitmap, width : Int, height : Int) : Bitmap {
        return Bitmap.createScaledBitmap(
            bitmap,
            height,
            width,
            false
        )
    }

    // 현재 액티비티로 돌아오면 실행하는 코드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                // 갤러리 인텐트를 보내고 다시 돌아오면
                GALLERY -> {
                    // 인텐트에 들어있는 Uri를 얻고
                    var imageData : Uri? = data?.data
                    try {
                        // MediaStore에서 해당 Uri의 Bitmap을 얻고
                        bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageData)
                        // 이미지뷰에 보여준다.
                        binding.profileIv.setImageBitmap(bitmap)
                    } catch (e : Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

}