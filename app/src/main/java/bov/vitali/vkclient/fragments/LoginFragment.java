package bov.vitali.vkclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bov.vitali.vkclient.R;
import bov.vitali.vkclient.fragments.callbacks.LoginCallback;

/**
 * Created by vitali on 13.03.17.
 */

public  class LoginFragment extends android.support.v4.app.Fragment {

    /**
     * Default constructor.
     */
    public LoginFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        v.findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginCallback!=null)
                    loginCallback.vkSDKLogin();
            }
        });
        return v;
    }

    /**
     * Login callback.
     */
    private LoginCallback loginCallback;

    /**
     * Sets login callback.
     * @param loginCallback Login callback.
     */
    public void setLoginCallback(LoginCallback loginCallback){
        this.loginCallback = loginCallback;
    }
}