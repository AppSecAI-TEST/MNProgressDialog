package com.maning.mndialoglibrary;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 * Created by maning on 2017/8/11.
 */

public class MToastConfig {

    public enum MToastGravity {
        CENTRE, BOTTOM
    }

    public int ToastTextColor = Color.parseColor("#FFFFFF");
    public int ToastBackgroundColor = Color.parseColor("#DD000000");
    public float ToastBackgroundCornerRadius = 10.0f;
    public MToastGravity ToastGravity = MToastGravity.BOTTOM;


    private MToastConfig() {
    }

    public static class Builder {

        private MToastConfig mToastConfig = null;

        public Builder() {
            mToastConfig = new MToastConfig();
        }

        public MToastConfig build() {
            return mToastConfig;
        }

        public Builder setTextColor(@ColorInt int textColor) {
            mToastConfig.ToastTextColor = textColor;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int backgroundColor) {
            mToastConfig.ToastBackgroundColor = backgroundColor;
            return this;
        }

        public Builder setBackgroundCornerRadius(float radius) {
            mToastConfig.ToastBackgroundCornerRadius = radius;
            return this;
        }

        public Builder setGravity(MToastGravity toastGravity) {
            mToastConfig.ToastGravity = toastGravity;
            return this;
        }
    }

}
