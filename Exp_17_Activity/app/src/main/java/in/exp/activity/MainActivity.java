package in.exp.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("msg", "In the onCreate LifeCycle");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("msg", "In the onStart LifeCycle");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("msg", "In the onStop LifeCycle");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("msg", "In the onDestroy LifeCycle");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("msg", "In the onPause LifeCycle");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("msg", "In the onResume LifeCycle");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("msg", "In the onRestart LifeCycle");

    }
}