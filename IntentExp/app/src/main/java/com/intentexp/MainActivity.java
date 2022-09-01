package com.intentexp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editText;
    static int PICK_IMG = 200;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.Btn);
        editText = findViewById(R.id.editText);
        imgView = findViewById(R.id.imgView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open link on browser

                String url = editText.getText().toString();

                // Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                // startActivity(i);

                //open call dial
                // Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7410102940"));
                // startActivity(i);

                //open call
                // Intent i = new Intent(Intent.ACTION_CALL);
                // i.setData(Uri.parse("tel:" + url));


                // PICK IMAGE
                 Intent i=new Intent(Intent.ACTION_PICK);
                // startActivityForResult(i,PICK_IMG);

                // Image Chooser
//                 Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivityForResult(i, PICK_IMG);


            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMG) {
            Uri uri = data.getData();
//            Bitmap img = (Bitmap) data.getExtras().get("data");
            if (data != null) {
//                imgView.setImageBitmap(img);
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setType("image/jpeg");
                startActivity(Intent.createChooser(shareIntent, "hello_this_image"));
            }
        }
    }
}