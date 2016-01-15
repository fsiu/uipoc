package net.darkwire.uipoc.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by fsiu on 1/12/16.
 */
public class TransitionButton extends Button {
    public TransitionButton(Context context) {
        super(context);
        setupTransition();
    }

    public TransitionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTransition();
    }

    public TransitionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTransition();
    }

    private void setupTransition() {
        final Drawable drawable = getBackground();
        if(drawable!=null && drawable.getClass() == TransitionDrawable.class) {
            final TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
            transitionDrawable.setCrossFadeEnabled(true);
        }
    }


}
