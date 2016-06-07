package com.yetie.yetie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.yetie.yetie.R;
import com.yetie.yetie.listeners.LoginFragmentListener;

/**
 * Created by jp on 06/06/16.
 */
public class RegisterPhoneFragment extends Fragment implements MaterialDialog.SingleButtonCallback {
    LoginFragmentListener mCallback;
    EditText number;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register_phone, container, false);
        ImageButton next = (ImageButton)v.findViewById(R.id.btn_next);
        number = (EditText)v.findViewById(R.id.input_number);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String confirm = getString(R.string.txt_confirm_number)+" "+number.getText().toString();
                new MaterialDialog.Builder(RegisterPhoneFragment.this.getContext())
                        .content(confirm)
                        .positiveText(R.string.ok)
                        .onPositive(RegisterPhoneFragment.this)
                        .show();
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
