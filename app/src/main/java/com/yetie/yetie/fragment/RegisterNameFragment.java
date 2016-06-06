package com.yetie.yetie.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.yetie.yetie.R;
import com.yetie.yetie.listeners.LoginFragmentListener;

/**
 * Created by jp on 06/06/16.
 */
public class RegisterNameFragment extends Fragment {

    LoginFragmentListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        ImageButton next  = (ImageButton) v.findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onNameRegister();
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
}
