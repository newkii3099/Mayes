package com.newlab.mayes.launcher.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import com.newlab.mayes.game.SAMP;

@SuppressLint("AppCompatCustomView")
public class CustomEditText extends EditText {
    private Context mContext = null;

    public CustomEditText(Context context) {
        super(context);
        mContext = context;
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void SetBackListener(Context context) {
        mContext = context;
    }

    private Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            Context ctx = (mContext != null) ? mContext : getContext();
            Activity act = getActivity(ctx);
            if (act instanceof SAMP) {
                ((SAMP) act).onEventBackPressed();
                return true;
            } else if (SAMP.getInstance() != null) {
                SAMP.getInstance().onEventBackPressed();
                return true;
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
