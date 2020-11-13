package com.example.desafioandroid02.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.desafioandroid02.R
import kotlinx.android.synthetic.main.activity_cadastrar_user.*


class CadastrarUserActivity : AppCompatActivity() {

    private lateinit var buttonRegisterUser:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_user)

        buttonRegisterUser = findViewById(R.id.btnSignup)

        setupBackButton()

        clicaBotaoRegistrar()

    }

    fun setupBackButton() {

        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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

            textFieldPasswordSignupContent.text.toString() != textFieldPasswordRepeatSignupContent.text.toString() -> {
                Toast.makeText(this,getString(R.string.equals_password),Toast.LENGTH_SHORT).show()
                camposForamValidados = false
            }

        }

        return camposForamValidados
    }

    fun clicaBotaoRegistrar(){

        buttonRegisterUser.setOnClickListener {

            if(validaCamposCadastro()){

                var intent = Intent(this,
                    HomeActvity::class.java)

                startActivity(intent)

            }

        }

    }



}