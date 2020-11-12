package com.example.desafioandroid02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastrar_user.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_cadastrar.*

class CadastrarUserActivity : AppCompatActivity() {

    private lateinit var buttonRegisterUser:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_user)

        setupBackButton()

        buttonRegisterUser = findViewById(R.id.btnSignup)

        clicaBotaoRegistrar()

    }

    fun setupBackButton(){

        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

    }

    fun validaCamposCadastro():Boolean{

        var camposForamValidados = true

        when {
            textFieldNameContent.text!!.trim()!!.isBlank() -> {
                textFieldNameContent.error = getString(R.string.empty_name)
                camposForamValidados = false
            }

            textFieldEmailSignupContent.text!!.trim()!!.isBlank() -> {
                textFieldEmailSignupContent.error = getString(R.string.empty_name)
                camposForamValidados = false
            }

            textFieldPasswordSignupContent.text!!.trim()!!.isBlank() -> {
                textFieldPasswordSignupContent.error = getString(R.string.empty_name)
                camposForamValidados = false
            }

            textFieldPasswordRepeatSignupContent.text!!.trim()!!.isBlank() -> {
                textFieldPasswordRepeatSignupContent.error = getString(R.string.empty_name)
                camposForamValidados = false

            }

            textFieldEmailSignupContent.text != textFieldPasswordRepeatSignupContent.text -> {
                Toast.makeText(this,"As senhas não são iguais",Toast.LENGTH_SHORT).show()
                camposForamValidados = false
            }

        }

        return camposForamValidados
    }

    fun clicaBotaoRegistrar(){

        buttonRegisterUser.setOnClickListener {

            if(validaCamposCadastro()){

            }

        }

    }



}