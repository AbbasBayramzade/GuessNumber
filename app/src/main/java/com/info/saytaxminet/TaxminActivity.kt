package com.info.saytaxminet

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_taxmin.*
import kotlin.random.Random

class TaxminActivity : AppCompatActivity() {

    private  var rastgelesayi = 0
    private var saygac = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxmin)

        rastgelesayi = Random.nextInt(51) //yani 0 ile 50 arasinda

        Log.e("Rastgele sayi",rastgelesayi.toString())

        btntaxminet.setOnClickListener {

            saygac = saygac - 1

            val tahmin = edttxt.text.toString().toInt()

            if (tahmin == rastgelesayi){

                val newintent =Intent(this@TaxminActivity,SonucActivity::class.java)

                newintent.putExtra("sonuc",true)

                finish()

                startActivity(newintent)

                return@setOnClickListener
            }

            if (tahmin > rastgelesayi){

                txtthird.text = "Azalt"

                txtsecond.text = "Qalan haqqınız : $saygac"
            }

            if (tahmin < rastgelesayi){
                txtthird.text = "Artır"

                txtsecond.text = "Qalan haqqınız : $saygac"
            }

            if (saygac == 0){

                intent.putExtra("sonuc",false)

                finish()

                startActivity(Intent(this@TaxminActivity,SonucActivity::class.java))
            }

            edttxt.setText("") //bu kod edttexte girilen son reqemi sifirlar yani orda qoymur qalsin:)

        }
    }
}