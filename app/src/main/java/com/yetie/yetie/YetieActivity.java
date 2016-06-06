package com.yetie.yetie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yetie.yetie.fragment.LoginFragment;
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
}
