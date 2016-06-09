package com.yetie.yetie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jipouille.usefullviews.views.TextViewPlus;
import com.yetie.yetie.R;
import com.yetie.yetie.listeners.LoginFragmentListener;

import me.philio.pinentry.PinEntryView;


/**
 * Created by jp on 06/06/16.
 */
public class RegisterValidCodeFragment extends Fragment {
    private static final String TAG = "RegisterPhoneFragment";
    LoginFragmentListener mCallback;
    PinEntryView code;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String fulldesc = null;

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register_valid_code, container, false);
        Bundle bundle = getArguments();
        ImageButton next = (ImageButton)v.findViewById(R.id.btn_next);
        TextView description = (TextView) v.findViewById(R.id.desc);
        if (bundle.getString("phonenumber") != null)
            fulldesc = description.getText().toString()+" "+bundle.getString("phonenumber");
        description.setText(fulldesc);
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
}
