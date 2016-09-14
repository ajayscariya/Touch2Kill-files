package com.wTouch2KiLL.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;
import java.util.Locale;

public class TimePreference extends DialogPreference {
    private int lastHour;
    private int lastMinute;
    private TimePicker picker;

    public static int getHour(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    public static int getMinute(String time) {
        return Integer.parseInt(time.split(":")[1]);
    }

    public TimePreference(Context ctxt, AttributeSet attrs) {
        super(ctxt, attrs);
        this.lastHour = 0;
        this.lastMinute = 0;
        this.picker = null;
        setPositiveButtonText("Set");
        setNegativeButtonText("Cancel");
    }

    protected View onCreateDialogView() {
        this.picker = new TimePicker(getContext());
        return this.picker;
    }

    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        this.picker.setCurrentHour(Integer.valueOf(this.lastHour));
        this.picker.setCurrentMinute(Integer.valueOf(this.lastMinute));
    }

    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
        if (positiveResult) {
            this.lastHour = this.picker.getCurrentHour().intValue();
            this.lastMinute = this.picker.getCurrentMinute().intValue();
            String time = String.format(Locale.US, "%02d", new Object[]{Integer.valueOf(this.lastHour)}) + ":" + String.format(Locale.US, "%02d", new Object[]{Integer.valueOf(this.lastMinute)});
            if (callChangeListener(time)) {
                persistString(time);
            }
        }
    }

    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        String time;
        if (!restoreValue) {
            time = defaultValue.toString();
        } else if (defaultValue == null) {
            time = getPersistedString("00:00");
        } else {
            time = getPersistedString(defaultValue.toString());
        }
        this.lastHour = getHour(time);
        this.lastMinute = getMinute(time);
    }
}
