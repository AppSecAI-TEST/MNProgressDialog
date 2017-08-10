package com.maning.mnprogressdialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.maning.mndialoglibrary.MProgressDialog;
import com.maning.mndialoglibrary.MStatusDialog;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Handler mHandler = new Handler();

    private MProgressDialog mMProgressDialog;

    private MStatusDialog mMStatusDialog;

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn05;
    private Button btn06;
    private Button btn07;
    private Button btn08;
    private Button btn09;
    private Button btn10;
    private Button btn11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();

        mMStatusDialog = new MStatusDialog(this);

    }


    private void initViews() {
        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btn05 = (Button) findViewById(R.id.btn05);
        btn06 = (Button) findViewById(R.id.btn06);
        btn07 = (Button) findViewById(R.id.btn07);
        btn08 = (Button) findViewById(R.id.btn08);
        btn09 = (Button) findViewById(R.id.btn09);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btn05.setOnClickListener(this);
        btn06.setOnClickListener(this);
        btn07.setOnClickListener(this);
        btn08.setOnClickListener(this);
        btn09.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
    }

    private void configDialogDefault() {
        //新建一个Dialog
        mMProgressDialog = new MProgressDialog(this);
        mMProgressDialog.setCanceledOnTouchOutside(true);
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


    /**
     * 带有下载进度的显示
     */
    private void configDialogWithProgress() {
        //新建一个Dialog
        mMProgressDialog = new MProgressDialog(this);
        mMProgressDialog.setProgressRimColor(getMyColor(R.color.colorDialogProgressRimColor));
        mMProgressDialog.setProgressRimWidth(1);

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


    public void showProgressDialog05() {
        configDialogWithProgress();
        mMProgressDialog.showWithProgress();
        initTimer();
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
            case R.id.btn05:
                showProgressDialog05();
                break;
            case R.id.btn06:
                showStatusDialog01();
                break;
            case R.id.btn07:
                showStatusDialog02();
                break;
            case R.id.btn08:
                showStatusDialog03();
                break;
            case R.id.btn09:
                showStatusDialog04();
                break;
            case R.id.btn10:
                showStatusDialog05();
                break;
            case R.id.btn11:
                showStatusDialog06();
                break;
        }
    }

    private void showStatusDialog06() {
        mMStatusDialog = new MStatusDialog(this);
        mMStatusDialog.showToast("OkGo - 3.0 震撼来袭，该库是基于 Http 协议，封装了 OkHttp 的网络请求框架，比 Retrofit 更简单易用，支持 RxJava，RxJava2，支持自定义缓存，支持批量断点下载管理和批量上传管理功能");
    }

    private void showStatusDialog05() {
        mMStatusDialog = new MStatusDialog(this);
        mMStatusDialog.showToast("网络失败");
    }

    private void showStatusDialog01() {
        mMStatusDialog = new MStatusDialog(this);
        mMStatusDialog.showSuccess("保存成功");
    }

    private void showStatusDialog02() {
        mMStatusDialog = new MStatusDialog(this);
        mMStatusDialog.showError("提交数据失败,请重新尝试!");
    }

    private void showStatusDialog03() {
        mMStatusDialog = new MStatusDialog(this);
        mMStatusDialog.showHint("您已经成为了金卡会员,恭喜!!您已经成为了金卡会员,恭喜!!您已经成为了金卡会员,恭喜!!您已经成为了金卡会员,恭喜!!");
    }

    private void showStatusDialog04() {
        //不一样的颜色
        mMStatusDialog.setImageTintColor(Color.YELLOW);
        mMStatusDialog.setBackgroundViewColor(getMyColor(R.color.colorDialogViewBg2));
        mMStatusDialog.setTextColor(getMyColor(R.color.colorDialogTextColor));
        mMStatusDialog.setBackgroundViewCornerRadius(2);
        mMStatusDialog.showError("颜色自定义显示");
    }

    private float currentProgress = 0.0f;
    private Timer timer;
    private TimerTask task;

    private void initTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (currentProgress < 1.0f) {
                            int pro = (int) (currentProgress * 100);
                            mMProgressDialog.setDialogText("视频下载进度: " + pro + "%");
                            mMProgressDialog.setDialogProgress(currentProgress);

                            currentProgress += 0.1;
                        } else {
                            destroyTimer();
                            currentProgress = 0.0f;
                            mMProgressDialog.setDialogProgress(1.0f);
                            mMProgressDialog.setDialogText("完成");
                            //关闭
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mMProgressDialog.dismiss();

                                }
                            }, 500);
                        }
                    }
                });
            }
        };
        timer.schedule(task, 0, 1000); //延时1000ms后执行，1000ms执行一次
    }

    private void destroyTimer() {
        timer.cancel();
        task.cancel();
        timer = null;
        task = null;
    }

}
