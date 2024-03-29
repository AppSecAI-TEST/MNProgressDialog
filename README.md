# MNProgressDialog [![](https://jitpack.io/v/maning0303/MNProgressDialog.svg)](https://jitpack.io/#maning0303/MNProgressDialog)
一个常用的自定义加载ProgressDialog,方面以后使用！


## 截图：
![](https://github.com/maning0303/MNProgressDialog/raw/master/screenshots/mn_dialog_01.png)


## 如何添加
### 1:Gradle添加：
#### 1.在Project的build.gradle中添加仓库地址

``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### 2.在app目录下的build.gradle中添加依赖
``` gradle
	dependencies {
	     compile 'com.github.maning0303:MNProgressDialog:V1.0.0'
	}
```

### 2:源码Module添加：
#### 直接关联mndialoglibrary

``` gradle

	compile project(':mndialoglibrary')

```


## 使用方法(查看Demo详情):

### 1:代码使用:
``` java

        //新建一个ProgressDialog
        MProgressDialog mMProgressDialog = new MProgressDialog(this);
        //设置点击外面消失
        mMProgressDialog.setCanceledOnTouchOutside(false);
        //设置窗体的背景色
        mMProgressDialog.setBackgroundWindowColor(color01);
        //设置ProgressDialog的背景色
        mMProgressDialog.setBackgroundViewColor(color02);
        //设置Progress颜色
        mMProgressDialog.setProgressColor(color03);
        //设置Progress宽度(db)
        mMProgressDialog.setProgressWidth(progressWidth);
        //设置文本的颜色
        mMProgressDialog.setDialogTextColor(color04);
        //设置ProgressDialog的背景的圆角大小(db)
        mMProgressDialog.setBackgroundViewCornerRadius(cornerRadius);

        //显示
        mMProgressDialog.show();
        //mMProgressDialog.showNoText();
        //mMProgressDialog.show("自定义文案");

        //Dialog消失的监听
        mMProgressDialog.setOnDialogDismissListener(new MProgressDialog.OnDialogDismissListener() {
            @Override
            public void dismiss() {

            }
        });

```

## 感谢：
#### 源码里面的MNProgressWheel 使用的是下面的这个库,改了个名字,以免冲突!
#### [materialish-progress](https://github.com/pnikosis/materialish-progress)
#### 示例中的颜色选择器
#### [hsv-alpha-color-picker-android](https://github.com/martin-stone/hsv-alpha-color-picker-android)
