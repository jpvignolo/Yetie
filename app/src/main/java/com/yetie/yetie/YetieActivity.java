package com.yetie.yetie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yetie.yetie.fragment.LoginFragment;
import com.yetie.yetie.fragment.RegisterNameFragment;
import com.yetie.yetie.fragment.RegisterPhoneFragment;
import com.yetie.yetie.fragment.RegisterValidCodeFragment;
import com.yetie.yetie.listeners.LoginFragmentListener;

public class YetieActivity extends AppCompatActivity implements LoginFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new LoginFragment();
        fm.beginTransaction().setCustomAnimations(R.anim.enter_from_right,
                R.anim.exit_to_left, 0, 0).add(R.id.root, fragment).commit();
    }

    @Override
    public void onAccountCreate() {
        Log.d("YetieActivity","onAccountCreate");
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new RegisterPhoneFragment();
        fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_NONE).add(R.id.root, fragment).addToBackStack("RegisterNameFragment").commit();
    }

    @Override
    public void onNameRegister() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new RegisterPhoneFragment();
        fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_NONE).add(R.id.root, fragment).addToBackStack("RegisterPhoneFragment").commit();
    }

    @Override
    public void onPhoneRegister(String number) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new RegisterValidCodeFragment();
        fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_NONE).add(R.id.root, fragment).addToBackStack("RegisterPhoneFragment").commit();
    }
}
