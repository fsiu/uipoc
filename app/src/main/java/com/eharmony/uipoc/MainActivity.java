package com.eharmony.uipoc;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int transitionTimeInMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        Button button = (Button)findViewById(R.id.transitionButton);
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = view.getBackground();
                if(drawable!=null && drawable.getClass() == TransitionDrawable.class) {
                    ((TransitionDrawable)drawable).startTransition(100);
                    //((TransitionDrawable)drawable).reverseTransition(100);
                }
            }
        });
        */

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean result = false;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    result = true;
                    Drawable drawable = view.getBackground();
                    if(drawable!=null && drawable.getClass() == TransitionDrawable.class) {
                        ((TransitionDrawable)drawable).resetTransition();
                        ((TransitionDrawable)drawable).startTransition(transitionTimeInMillis);
                    }
                }

                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    result = true;
                    Drawable drawable = view.getBackground();
                    if(drawable!=null && drawable.getClass() == TransitionDrawable.class) {
                        ((TransitionDrawable)drawable).resetTransition();
                        ((TransitionDrawable)drawable).reverseTransition(transitionTimeInMillis);
                    }
                }
                return result;
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                boolean result = false;
                Drawable drawable = view.getBackground();
                if(drawable!=null && drawable.getClass() == TransitionDrawable.class) {
                    result = true;
                    ((TransitionDrawable)drawable).resetTransition();
                    ((TransitionDrawable)drawable).startTransition(transitionTimeInMillis);
                }

                return result;
            }
        });

        final TextView textView = (TextView) findViewById(R.id.transitionTimeDisplay);


        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        final int step = 1;
        final int max = 500;
        final int min = 0;

        transitionTimeInMillis = min;
        textView.setText(min+"\nms");

        seekBar.setMax((max-min)/step);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                transitionTimeInMillis = (min + (progress * step));
                Log.d("position:", transitionTimeInMillis+"");
                textView.setText(transitionTimeInMillis+"\nms");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
