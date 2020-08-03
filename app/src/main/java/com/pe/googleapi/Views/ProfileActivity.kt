package com.pe.googleapi.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.pe.googleapi.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var textoInfo: TextView
    var txtinfo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        textoInfo = findViewById(R.id.info)

        val infoAccount = GoogleSignIn.getLastSignedInAccount(this)
        if (infoAccount != null){
            txtinfo = infoAccount.displayName + "\n" +
                    infoAccount.givenName + "\n" +
                    infoAccount.familyName +"\n" +
                    infoAccount.email + "\n" +
                    infoAccount.id
        }

        textoInfo.text = txtinfo
    }
}