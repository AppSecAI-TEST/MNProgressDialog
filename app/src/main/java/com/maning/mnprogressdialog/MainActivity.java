package com.maning.mnprogressdialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.maning.mndialoglibrary.MProgressDialog;
import com.rarepebble.colorpicker.ColorPickerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Handler mHandler = new Handler();

    private MProgressDialog mMProgressDialog;

    private ColorPickerView mColorPickerView;
    private RelativeLayout rl_picker_bg;
    private RelativeLayout colorView01;
    private RelativeLayout colorView02;
    private RelativeLayout colorView03;
    private RelativeLayout colorView04;
    private EditText editText;
    private EditText editText02;
    private CheckBox checkbox;

    private int flag = 0;

    private int color01;    //Window颜色
    private int color02;    //Dialog背景色
    private int color03;    //Progress颜色
    private int color04;    //Text颜色
    private float cornerRadius;    //圆角大小
    private int progressWidth;    //Progress大小

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();

        initConfig();

        initDailog();

    }


    private void initViews() {

        mColorPickerView = (ColorPickerView) findViewById(R.id.colorPicker);
        rl_picker_bg = (RelativeLayout) findViewById(R.id.rl_picker_bg);

        colorView01 = (RelativeLayout) findViewById(R.id.colorView01);
        colorView02 = (RelativeLayout) findViewById(R.id.colorView02);
        colorView03 = (RelativeLayout) findViewById(R.id.colorView03);
        colorView04 = (RelativeLayout) findViewById(R.id.colorView04);
        editText = (EditText) findViewById(R.id.editText);
        editText02 = (EditText) findViewById(R.id.editText02);
        checkbox = (CheckBox) findViewById(R.id.checkbox);

        rl_picker_bg.setVisibility(View.GONE);

        colorView01.setOnClickListener(this);
        colorView02.setOnClickListener(this);
        colorView03.setOnClickListener(this);
        colorView04.setOnClickListener(this);
        rl_picker_bg.setOnClickListener(this);

    }

    private void initConfig() {
        color01 = getMyColor(R.color.colorDialogWindowBg);
        color02 = getMyColor(R.color.colorDialogViewBg);
        color03 = getMyColor(R.color.colorDialogProgressBarColor);
        color04 = getMyColor(R.color.colorDialogTextColor);
        cornerRadius = 6;
        progressWidth = 2;

        colorView01.setBackgroundColor(color01);
        colorView02.setBackgroundColor(color02);
        colorView03.setBackgroundColor(color03);
        colorView04.setBackgroundColor(color04);

    }

    private void initDailog() {

        mMProgressDialog = new MProgressDialog(this);
        mMProgressDialog.setOnDialogDismissListener(new MProgressDialog.OnDialogDismissListener() {
            @Override
            public void dismiss() {
                mHandler.removeCallbacksAndMessages(null);
            }
        });

    }

    private void configDialog() {
        //新建一个Dialog
        mMProgressDialog = new MProgressDialog(this);

        //圆角
        String input01 = editText.getText().toString();
        if (TextUtils.isEmpty(input01)) {
            input01 = "6";
        }
        cornerRadius = Float.parseFloat(input01);
        //Progress宽度
        String input02 = editText02.getText().toString();
        if (TextUtils.isEmpty(input02)) {
            input02 = "2";
        }
        progressWidth = Integer.parseInt(input02);

        mMProgressDialog.setCanceledOnTouchOutside(checkbox.isChecked());
        mMProgressDialog.setBackgroundWindowColor(color01);
        mMProgressDialog.setBackgroundViewColor(color02);
        mMProgressDialog.setProgressColor(color03);
        mMProgressDialog.setProgressWidth(progressWidth);
        mMProgressDialog.setDialogTextColor(color04);
        mMProgressDialog.setBackgroundViewCornerRadius(cornerRadius);
    }

    private int getMyColor(int colorID) {
        int color = mContext.getResources().getColor(colorID);
        return color;
    }


    public void btnShowProgressDialog(View view) {
        configDialog();
        mMProgressDialog.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }

    public void btnShowProgressDialog02(View view) {
        configDialog();
        mMProgressDialog.show("我是一个很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的文案");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }

    public void btnShowProgressDialog03(View view) {
        configDialog();
        mMProgressDialog.showNoText();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }



    public void btnGetColor(View view) {
        rl_picker_bg.setVisibility(View.GONE);
        int color = mColorPickerView.getColor();
        if (flag == 1) {
            color01 = color;
            colorView01.setBackgroundColor(color01);
        } else if (flag == 2) {
            color02 = color;
            colorView02.setBackgroundColor(color02);
        } else if (flag == 3) {
            color03 = color;
            colorView03.setBackgroundColor(color03);
        } else if (flag == 4) {
            color04 = color;
            colorView04.setBackgroundColor(color04);
        }
    }

    public void btnCancle(View view) {
        rl_picker_bg.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.colorView01:
                flag = 1;
                mColorPickerView.setColor(color01);
                rl_picker_bg.setVisibility(View.VISIBLE);
                break;
            case R.id.colorView02:
                flag = 2;
                mColorPickerView.setColor(color02);
                rl_picker_bg.setVisibility(View.VISIBLE);
                break;
            case R.id.colorView03:
                flag = 3;
                mColorPickerView.setColor(color03);
                rl_picker_bg.setVisibility(View.VISIBLE);
                break;
            case R.id.colorView04:
                flag = 4;
                mColorPickerView.setColor(color04);
                rl_picker_bg.setVisibility(View.VISIBLE);
                break;
        }
    }
}
