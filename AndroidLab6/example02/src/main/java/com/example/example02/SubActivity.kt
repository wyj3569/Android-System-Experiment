
package com.example.example02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val btn = findViewById<Button>(R.id.btn_sub)
        val ev = findViewById<EditText>(R.id.ev_sub)
        val res = findViewById<TextView>(R.id.res_sub)

        val intent = intent
        val data = intent.getStringExtra("data") + "\n-send from main"
        res.text = data.toString()

        btn.setOnClickListener {
            if (ev.text.isEmpty()) {
                Toast.makeText(this, "값을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data : String = ev.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", data)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}