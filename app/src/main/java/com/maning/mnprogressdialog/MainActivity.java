package com.maning.mnprogressdialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.maning.mndialoglibrary.MProgressDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Handler mHandler = new Handler();

    private MProgressDialog mMProgressDialog;

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();

    }


    private void initViews() {
        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
    }

    private void configDialogDefault() {
        //新建一个Dialog
        mMProgressDialog = new MProgressDialog(this);
        mMProgressDialog.setOnDialogDismissListener(new MProgressDialog.OnDialogDismissListener() {
            @Override
            public void dismiss() {
                mHandler.removeCallbacksAndMessages(null);
            }
        });
    }

    private void configDialogCustom() {
        //新建一个Dialog
        mMProgressDialog = new MProgressDialog(this);

        mMProgressDialog.setCanceledOnTouchOutside(true);
        mMProgressDialog.setBackgroundWindowColor(getMyColor(R.color.colorDialogWindowBg));
        mMProgressDialog.setBackgroundViewColor(getMyColor(R.color.colorDialogViewBg));
        mMProgressDialog.setProgressColor(getMyColor(R.color.colorDialogProgressBarColor));
        mMProgressDialog.setDialogTextColor(getMyColor(R.color.colorDialogTextColor));
        mMProgressDialog.setProgressWidth(3);
        mMProgressDialog.setBackgroundViewCornerRadius(20);
        mMProgressDialog.setOnDialogDismissListener(new MProgressDialog.OnDialogDismissListener() {
            @Override
            public void dismiss() {
                mHandler.removeCallbacksAndMessages(null);
            }
        });
    }

    private int getMyColor(int colorID) {
        return mContext.getResources().getColor(colorID);
    }


    private void showProgressDialog01() {
        configDialogDefault();
        mMProgressDialog.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }

    public void showProgressDialog02() {
        configDialogDefault();
        mMProgressDialog.show("我是一个很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的文案");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }

    public void showProgressDialog03() {
        configDialogDefault();
        mMProgressDialog.showNoText();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }

    public void showProgressDialog04() {
        configDialogCustom();
        mMProgressDialog.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMProgressDialog.dismiss();
            }
        }, 3000);
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn01:
                showProgressDialog01();
                break;
            case R.id.btn02:
                showProgressDialog02();
                break;
            case R.id.btn03:
                showProgressDialog03();
                break;
            case R.id.btn04:
                showProgressDialog04();
                break;

        }
    }
}
