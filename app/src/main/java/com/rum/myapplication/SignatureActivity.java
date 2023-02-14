package com.rum.myapplication;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.rum.myapplication.databinding.ActivitySignatureBinding;
import com.rum.myapplication.generalHelper.DrawingView;

public class SignatureActivity extends AppCompatActivity {

    private Context mContext;
    private ActivitySignatureBinding binding;

    private boolean isPaintEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signature);

        initComponents();
        setListeners();

    }

    private void initComponents() {
        hideProgress();
        hidePaint();
        initDrawingView();
        initAndPlayVideo();
    }

    private void setListeners() {
        binding.btnStartStop.setOnClickListener(view -> {
            if (isPaintEnabled) {
                hidePaint();
            } else {
                showPaintOption();
            }
        });
    }

    private void initDrawingView() {
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(ContextCompat.getColor(mContext, R.color.colorOrange));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(8);
        DrawingView drawingView = new DrawingView(mContext, mPaint);

        binding.llSignatureView.addView(drawingView);
        binding.llSignatureView.invalidate();
    }

    private void initAndPlayVideo() {


    }

    private void showPaintOption() {
        isPaintEnabled = true;
        binding.llSignatureView.setVisibility(View.VISIBLE);
    }

    private void hidePaint() {
        isPaintEnabled = false;
        binding.llSignatureView.setVisibility(View.GONE);
    }

    private void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        binding.progressBar.setVisibility(View.GONE);
    }
}