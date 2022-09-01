package in.exp.exp8;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox ch1;
    Button btn;
    RadioButton radioButton;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn = findViewById(R.id.btn);
        videoView = findViewById(R.id.video);


        String videoUrl="https://drustii.s3.ap-south-1.amazonaws.com/videos/be551e54-3db6-4762-8556-05c8ed102140.mov?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAU4CAK5XG765EEMPX%2F20220502%2Fap-south-1%2Fs3%2Faws4_request&X-Amz-Date=20220502T180049Z&X-Amz-Expires=12000&X-Amz-Signature=27b0a275b88d66b4df62a1983d765a36ab1818c23743937bfdd0f19f094e44ae&X-Amz-SignedHeaders=host";

        Uri uri = Uri.parse(videoUrl);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
        videoView.setVideoPath(videoUrl);
        videoView.requestFocus();
        videoView.start();




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // starts the video
//                videoView.start();

//                if (ch1.isChecked()) {
//                    Toast.makeText(MainActivity.this, "Thanks for selecting".toString(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Please select check box", Toast.LENGTH_SHORT).show();
//                }
//
//                if (radioButton.isChecked()) {
//                    Toast.makeText(MainActivity.this, "Radio Clicked", Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }
}