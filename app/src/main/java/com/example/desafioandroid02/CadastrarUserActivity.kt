package com.example.desafioandroid02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class CadastrarUserActivity : AppCompatActivity() {

    private lateinit var buttonRegisterUser:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_user)

        buttonRegisterUser = findViewById(R.id.btnSignup)

        buttonRegisterUser.setOnClickListener {



        }

    }

    fun validaCamposCadastro():Boolean{

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



}