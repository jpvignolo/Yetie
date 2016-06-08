package com.yetie.yetie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jipouille.usefullviews.views.EditTextPlusPhoneNumber;
import com.yetie.yetie.R;
import com.yetie.yetie.listeners.LoginFragmentListener;


/**
 * Created by jp on 06/06/16.
 */
public class RegisterValidCodeFragment extends Fragment implements MaterialDialog.SingleButtonCallback {
    private static final String TAG = "RegisterPhoneFragment";
    LoginFragmentListener mCallback;
    EditTextPlusPhoneNumber number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register_valid_code, container, false);

        ImageButton next = (ImageButton)v.findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);

        try {
            mCallback = (LoginFragmentListener) ctx;
        } catch (ClassCastException e) {
            throw new ClassCastException(ctx.toString()
                    + " must implement SearchFragmentListener");
        }
    }

    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
        mCallback.onPhoneRegister(number.getText().toString());
    }
}
