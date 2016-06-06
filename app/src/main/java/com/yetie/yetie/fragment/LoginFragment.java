package com.yetie.yetie.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yetie.yetie.R;
import com.yetie.yetie.listeners.LoginFragmentListener;

/**
 * Created by Jean-Philippe on 05/06/2016.
 */
public class LoginFragment extends Fragment implements Animator.AnimatorListener {

    private static final String TAG = "LoginFragment";

    private static final int STEP_FADE_OUT_CONTAINER = 1;
    private static final int STEP_FADE_IN_PRESENTATION = 2;
    private static final int STEP_FADE_IN_POINT_1 = 3;
    private static final int STEP_FADE_IN_POINT_2 = 4;
    private static final int STEP_FADE_IN_POINT_3 = 5;
    private static final int STEP_FINISH = 0;

    LoginFragmentListener mCallback;
    private TextView presentationTxt;
    private TextView presentationTxt2;
    private LinearLayout presentationContainer1;
    private LinearLayout presentationPointContainer;
    private LinearLayout presentationPoint1;
    private LinearLayout presentationPoint2;
    private LinearLayout presentationPoint3;
    private AnimatorSet fade_in;
    private AnimatorSet fade_in_2;
    private AnimatorSet fade_in_point_1;
    private AnimatorSet fade_in_point_2;
    private AnimatorSet fade_in_point_3;
    private AnimatorSet fade_out;
    private int animation_step = 0;
    private Button btnAccountCreate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        presentationTxt = (TextView)v.findViewById(R.id.presentation_txt);
        presentationTxt2 = (TextView)v.findViewById(R.id.presentation_txt_2);
        presentationContainer1 = (LinearLayout) v.findViewById(R.id.presentation_container_1);
        presentationPointContainer = (LinearLayout) v.findViewById(R.id.presentation_points_container);
        presentationPoint1 = (LinearLayout) v.findViewById(R.id.presentation_point_1);
        presentationPoint2 = (LinearLayout) v.findViewById(R.id.presentation_point_2);
        presentationPoint3 = (LinearLayout) v.findViewById(R.id.presentation_point_3);
        btnAccountCreate = (Button) v.findViewById(R.id.btn_account_create);

        return v;
    }

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);

        fade_in = (AnimatorSet) AnimatorInflater.loadAnimator(ctx,
                R.animator.fade_in);
        fade_in_2 = (AnimatorSet) AnimatorInflater.loadAnimator(ctx,
                R.animator.fade_in);
        fade_in_point_1 = (AnimatorSet) AnimatorInflater.loadAnimator(ctx,
                R.animator.fade_in);
        fade_in_point_2 = (AnimatorSet) AnimatorInflater.loadAnimator(ctx,
                R.animator.fade_in);
        fade_in_point_3 = (AnimatorSet) AnimatorInflater.loadAnimator(ctx,
                R.animator.fade_in);
        fade_out = (AnimatorSet) AnimatorInflater.loadAnimator(ctx,
                R.animator.fade_out);
        try {
            mCallback = (LoginFragmentListener) ctx;
        } catch (ClassCastException e) {
            throw new ClassCastException(ctx.toString()
                    + " must implement SearchFragmentListener");
        }
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {

        Animation anim = AnimationUtils.loadAnimation(getActivity(), nextAnim);

        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG, "Animation started.");
                // additional functionality
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d(TAG, "Animation repeating.");
                // additional functionality
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "Animation ended.");
                fade_in.setTarget(presentationTxt);
                fade_in.addListener(LoginFragment.this);
                animation_step = STEP_FADE_OUT_CONTAINER;
                fade_in.start();
            }
        });

        return anim;
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {
        Log.d(TAG,"onAnimationEnd "+animation_step);
        switch (animation_step) {
            case STEP_FADE_OUT_CONTAINER:
                fade_out.setTarget(presentationContainer1);
                fade_out.setStartDelay(750);
                fade_out.addListener(LoginFragment.this);
                animation_step = STEP_FADE_IN_PRESENTATION;
                fade_out.start();
                break;
            case STEP_FADE_IN_PRESENTATION:
                fade_in_2.setTarget(presentationTxt2);
                fade_in_2.addListener(LoginFragment.this);
                animation_step = STEP_FADE_IN_POINT_1;
                fade_in_2.start();
                break;
            case STEP_FADE_IN_POINT_1:
                fade_in_point_1.setTarget(presentationPoint1);
                fade_in_point_1.addListener(LoginFragment.this);
                animation_step = STEP_FADE_IN_POINT_2;
                fade_in_point_1.start();
                break;
            case STEP_FADE_IN_POINT_2:
                fade_in_point_2.setTarget(presentationPoint2);
                fade_in_point_2.addListener(LoginFragment.this);
                animation_step = STEP_FADE_IN_POINT_3;
                fade_in_point_2.start();
                break;
            case STEP_FADE_IN_POINT_3:
                fade_in_point_3.setTarget(presentationPoint3);
                fade_in_point_3.addListener(LoginFragment.this);
                animation_step = STEP_FINISH;
                fade_in_point_3.start();
                break;
            case STEP_FINISH:
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presentationPointContainer.setVisibility(View.GONE);
                        presentationTxt2.setVisibility(View.GONE);
                        presentationTxt.setAlpha(1);
                        presentationTxt.setText(getText(R.string.welcome));
                        presentationContainer1.setAlpha(1);
                        btnAccountCreate.setVisibility(View.VISIBLE);
                    }
                }, 1000);
                break;
        }
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
