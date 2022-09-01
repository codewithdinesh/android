package in.exp.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Handler handler = new Handler();
    TextView textView, percentageProgress;
    LinearLayout progressContainer;
    Button btn, stopbtn;
    Thread thread;
    int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.progressStatus);
        btn = findViewById(R.id.downloadFile);
        progressContainer = findViewById(R.id.progressContainer);
        percentageProgress = findViewById(R.id.percentage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressContainer.setVisibility(View.VISIBLE);
                btn.setVisibility(View.GONE);

                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 5;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    textView.setText(progressStatus + "/" + progressBar.getMax());
                                    percentageProgress.setText(progressStatus + "%");
                                }
                            });
                            try {
                                Thread.sleep(200);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        });

    }
}