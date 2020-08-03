package com.pe.googleapi.Views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.pe.googleapi.R
import com.pe.googleapi.Views.LoginFragments.ForgotPassRecoverByEmail
import com.pe.googleapi.Views.LoginFragments.SignInFragment

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtLayoutEmail: TextInputLayout
    private lateinit var txtLayoutPassword: TextInputLayout
    private lateinit var email: TextInputEditText;
    private lateinit var password: TextInputEditText
    private lateinit var forgotPass: TextView           // fun like a button
    private lateinit var login: Button
    private lateinit var googleSignInButton: Button
    private lateinit var register: TextView             // fun like a button

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setTheme(R.style.LoginTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        // Instances
        txtLayoutEmail = findViewById(R.id.txtilay_email)
        txtLayoutPassword = findViewById(R.id.txtilay_password)
        email = findViewById(R.id.txtiedt_email)
        password = findViewById(R.id.txtiedt_password)
        forgotPass = findViewById(R.id.txt_btn_forgot_password)
        login = findViewById(R.id.btn_login)
        googleSignInButton = findViewById(R.id.btn_signin_google)
        register = findViewById(R.id.txt_btn_register)

        login.setOnClickListener(this)
        forgotPass.setOnClickListener(this)
        register.setOnClickListener(this)
        googleSignInButton.setOnClickListener(this)


    }

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                Toast.makeText(this, "Logeado!", Toast.LENGTH_SHORT).show()
            }
            R.id.txt_btn_forgot_password -> {
                val forgotPass = ForgotPassRecoverByEmail()
                forgotPass.show(supportFragmentManager, "forgot password email fullscreen")
            }
            R.id.txt_btn_register -> {
                val signFragment = SignInFragment()
                signFragment.show(supportFragmentManager, "signScreen fullscreen")
            }
            R.id.btn_signin_google -> {
                val signInIntent = mGoogleSignInClient.signInIntent
                startActivityForResult(signInIntent, RC_SIGN_IN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            updateUI(account)
        } catch (e: ApiException) {
            Log.w("Exception", "SignInResult: failed code " + e.statusCode)
            updateUI(null)
        }
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        if (account != null) {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}

