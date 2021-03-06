package com.example.desafioandroid02.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafioandroid02.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonRegister:Button

    private lateinit var buttonLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegister = findViewById<Button>(R.id.btnRegister)

        buttonLogin = findViewById<Button>(R.id.btnLogin)

        fazerLogin()

        fazerRegistro()

    }

    fun fazerLogin(){

        buttonLogin.setOnClickListener {

            if(validaCamposLogin()){

                chamarTelaHome()

            }

        }

    }

    fun chamarTelaHome(){

        var intent = Intent(this, HomeActvity::class.java)

        startActivity(intent)

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

    fun fazerRegistro(){

        btnRegister.setOnClickListener {

            var intent = Intent(this, CadastrarUserActivity::class.java)

            startActivity(intent)

        }
    }


}