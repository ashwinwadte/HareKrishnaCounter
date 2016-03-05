package com.example.ashwin.harekrishna;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends Activity implements View.OnClickListener {
    TextView beads, rounds, resetBeads, resetRounds;
    Button increment, decrement;
    int i;
    int b, r;

    //BufferedWriter out;
    //BufferedReader in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            init();
        } catch (IOException e) {
            Log.d("HareKrishna", "Error in init: " + e);
        }
    }

    private void init() throws IOException {
        beads = (TextView) findViewById(R.id.tvBeads);
        rounds = (TextView) findViewById(R.id.tvRounds);
        resetBeads = (TextView) findViewById(R.id.tvResetBeads);
        resetRounds = (TextView) findViewById(R.id.tvResetRounds);
        increment = (Button) findViewById(R.id.bIncrement);
        decrement = (Button) findViewById(R.id.bDecrement);

        b = 0;
        r = 0;
        beads.setText(String.valueOf(b));
        rounds.setText(String.valueOf(r));

        increment.setOnClickListener(this);
        decrement.setOnClickListener(this);
        resetBeads.setOnClickListener(this);
        resetRounds.setOnClickListener(this);

        /*out = new BufferedWriter(new FileWriter("data.hk"));
        in = new BufferedReader(new FileReader("data.hk"));

        if (in.readLine() != null) {
            String[] s = in.readLine().split(" ");
            b = Integer.parseInt(s[0]);
            r = Integer.parseInt(s[1]);

            beads.setText(String.valueOf(b));
            rounds.setText(String.valueOf(r));
        } else {
            b = 0;
            r = 0;
        }*/
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bIncrement:
                try {
                    b = b + 1;
                    beads.setText(String.valueOf(b));

                    i = Integer.parseInt(beads.getText().toString());
                    if (i == 108) {
                        b = 0;
                        r = r + 1;
                        beads.setText(String.valueOf(b));
                        rounds.setText(String.valueOf(r));
                    }

                    //save file
                    //out.write(String.format("%d %d", b, r));
                } catch (Exception e) {
                    Log.d("HareKrishna", "Error in 1st switch case: " + e);
                }
                break;

            case R.id.bDecrement:
                try {
                    b = b - 1;
                    beads.setText(String.valueOf(b));

                    i = Integer.parseInt(beads.getText().toString());
                    if (i == -1 && r != 0) {
                        b = 107;
                        r = r - 1;
                        beads.setText(String.valueOf(b));
                        rounds.setText(String.valueOf(r));
                    } else if (i == -1 && r == 0) {
                        b = 0;
                        r = 0;
                        beads.setText(String.valueOf(b));
                        rounds.setText(String.valueOf(r));
                    }

                    //save file
                    //out.write(String.format("%d %d", b, r));
                } catch (Exception e) {
                    Log.d("HareKrishna", "Error in 2nd switch case: " + e);
                }
                break;

            case R.id.tvResetBeads:
                b = 0;
                /*try {
                    out.write(String.format("%d %d", b, r));
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                beads.setText(String.valueOf(b));
                break;

            case R.id.tvResetRounds:
                r = 0;
                rounds.setText(String.valueOf(r));
                break;
        }
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            out.close();
            in.close();
        } catch (IOException e) {
            Log.d("HareKrishna", "Error in onDestroy: " + e);
        }
    }*/
}
