package com.pe.googleapi.Views.LoginFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.pe.googleapi.R

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : DialogFragment(), View.OnClickListener {

    lateinit var backButton: ImageButton
    lateinit var btnCreateAccount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.fullScreenDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signin_view, container, false)

        backButton = view.findViewById(R.id.btn_back_button)
        btnCreateAccount = view.findViewById(R.id.btn_create_account)

        backButton.setOnClickListener(this)
        btnCreateAccount.setOnClickListener(this)


        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_button -> {
                dismiss()
            }
            R.id.btn_create_account -> {
                Toast.makeText(requireActivity(), "Cuenta Creada", Toast.LENGTH_SHORT).show()
            }
        }
    }

}