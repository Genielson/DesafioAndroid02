package com.example.desafioandroid02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonRegister:Button

    private lateinit var buttonLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegister = findViewById<Button>(R.id.btnRegister)

        buttonLogin = findViewById<Button>(R.id.btnLogin)

        buttonLogin.setOnClickListener {

            if(validaCamposLogin()){

            }

        }

        btnRegister.setOnClickListener {

            chamarTelaRegister()

        }

    }

    fun validaCamposLogin():Boolean{

        var camposForamValidados = true

        if(textFieldEmailContent.text!!.trim()!!.isBlank()){

            textFieldEmailContent.error = getString(R.string.empty_email)

            camposForamValidados = false

        }

        if(textFieldPasswordContent.text!!.trim().isBlank()){

            textFieldPasswordContent.error = getString(R.string.empty_password)

            camposForamValidados = false

        }

        return camposForamValidados

    }

    fun chamarTelaRegister(){

        var intent = Intent(this,CadastrarUserActivity::class.java)

        startActivity(intent)
    }


}