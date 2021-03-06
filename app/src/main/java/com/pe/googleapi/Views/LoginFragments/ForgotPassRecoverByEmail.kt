package com.pe.googleapi.Views.LoginFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.pe.googleapi.R

class ForgotPassRecoverByEmail : DialogFragment(), View.OnClickListener {

    private lateinit var backButton: ImageButton
    private lateinit var email: TextInputEditText
    private lateinit var txtToSMSDialog: TextView
    private lateinit var btnResetPass: Button
    private lateinit var txtHelp: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.fullScreenDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.forgot_pass_email_view, container, false)

        backButton = view.findViewById(R.id.btn_back_button)
        email = view.findViewById(R.id.txtiedt_email)
        txtToSMSDialog = view.findViewById(R.id.txt_try_sms)
        btnResetPass = view.findViewById(R.id.btn_reset_pass)
        txtHelp = view.findViewById(R.id.txt_help)

        backButton.setOnClickListener(this)
        txtToSMSDialog.setOnClickListener(this)
        btnResetPass.setOnClickListener(this)
        txtHelp.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_button -> {
                dismiss()
            }
            R.id.txt_try_sms -> {
                val forgotPass = ForgorPassRecoverBySMS()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                forgotPass.show(transaction, "forgot password SMS fullscreen")
            }
            R.id.btn_reset_pass -> {
                val verifyCode = VerificationCodeView()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                verifyCode.show(transaction, "verify code fullscreen")
            }
            R.id.txt_help -> {
            }
        }
    }
}