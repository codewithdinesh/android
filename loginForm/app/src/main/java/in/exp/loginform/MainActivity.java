package in.exp.loginform;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Btn;
    private int PICK_IMAGE = 200;
    ImageView userImage;
    Uri selectedImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn = findViewById(R.id.Btn);
        userImage = findViewById(R.id.userImage);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
                // pickImage();
            }
        });

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open web broweser
                // Intent intent=new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.drustii.in"));
                //startActivity(intent);

                // Send TExt
                // Intent sendIntent = new Intent();
                // sendIntent.setAction(Intent.ACTION_SEND);
                // sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                // sendIntent.setType("text/plain");
                // Intent shareIntent = Intent.createChooser(sendIntent, null);
                // startActivity(shareIntent);

                //sendImg();
                //openCamera();


            }
        });
    }


    //Open camera
    public void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(intent, PICK_IMAGE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    // Image picker
    public void pickImage() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Select image"), PICK_IMAGE);

    }


    //Function when user selects the image from pickImage()

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if user choosed image
        if (resultCode == RESULT_OK) {

            if (requestCode == PICK_IMAGE) {
                // GET the url of image from data
                selectedImageUri = data.getData();
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");

                userImage.setImageBitmap(imageBitmap);

                if (null != selectedImageUri) {
//                    userImage.setImageURI(selectedImageUri);
                    userImage.setImageBitmap(imageBitmap);

                }

            }
        }
    }

    public void sendImg() {
        //Send Image
        Uri uriToImage = selectedImageUri;
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, null));
    }

}