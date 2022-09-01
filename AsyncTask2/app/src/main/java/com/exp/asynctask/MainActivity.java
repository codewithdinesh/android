package com.exp.asynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button downloadBtn;
    ImageView image;
    ProgressDialog progressDialog;
    URL imageUrl = null;
    InputStream inputStream = null;
    Bitmap bitmapImg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadBtn = findViewById(R.id.downloadImage);
        image = findViewById(R.id.image);

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTaskC obj = new AsyncTaskC();
                obj.execute("https://www.industrialempathy.com/img/remote/ZiClJf-1920w.jpg");
            }
        });
    }

    public class AsyncTaskC extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Image in downloading process");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }


        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                imageUrl = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                inputStream = conn.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmapImg = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmapImg;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            if (image != null) {
                progressDialog.hide();
                image.setImageBitmap(bitmapImg);
            } else {
                progressDialog.show();
            }


        }

    }


}