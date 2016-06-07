package com.yetie.yetie.listeners;

/**
 * Created by Jean-Philippe on 05/06/2016.
 */
public interface LoginFragmentListener {
    void onAccountCreate();

    void onNameRegister();

    void onPhoneRegister(String number);
}
