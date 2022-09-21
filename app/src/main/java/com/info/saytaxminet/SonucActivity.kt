package com.info.saytaxminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sonuc.*
import kotlinx.android.synthetic.main.activity_taxmin.*

class SonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val sonuc = intent.getBooleanExtra("sonuc",false)

        if (sonuc){

            txtdord.text = "Təbriklər,qazandınız"

            Toast.makeText(applicationContext, "Cavab :$sonuc", Toast.LENGTH_LONG).show()

            image_uzgun.setImageResource(R.drawable.kazandin_resim)

        }else{

            txtdord.text = "Təəssüf,qazanmadınız"

            image_uzgun.setImageResource(R.drawable.uzgun_resim)

        }

        btntekrar.setOnClickListener {

            val newintent = Intent(this@SonucActivity,TaxminActivity::class.java)

            finish()

            startActivity(newintent)

        }

    }
}