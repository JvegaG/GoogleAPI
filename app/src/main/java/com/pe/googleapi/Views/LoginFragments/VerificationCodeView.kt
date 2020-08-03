package com.pe.googleapi.Views.LoginFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.chaos.view.PinView
import com.pe.googleapi.R

class VerificationCodeView: DialogFragment(), View.OnClickListener {

    private lateinit var backButton: ImageButton
    private lateinit var txtQuestion: TextView
    private lateinit var code: PinView
    private lateinit var txtResendCode: TextView
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
        val view = inflater.inflate(R.layout.verification_code, container, false)

        backButton = view.findViewById(R.id.btn_back_button)
        txtQuestion = view.findViewById(R.id.txt_question_verify_code)
        code = view.findViewById(R.id.pin_code)
        txtResendCode = view.findViewById(R.id.txt_resend_code)
        btnResetPass = view.findViewById(R.id.btn_reset_pass)
        txtHelp = view.findViewById(R.id.txt_help)

        backButton.setOnClickListener(this)
        txtResendCode.setOnClickListener(this)
        btnResetPass.setOnClickListener(this)
        txtHelp.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_button -> {
                dismiss()
            }
            R.id.txt_resend_code -> {
            }
            R.id.btn_reset_pass -> {
                val resetPass = ResetPassView()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                resetPass.show(transaction, "reset password fullscreen")
            }
            R.id.txt_help -> {
            }
        }
    }
}