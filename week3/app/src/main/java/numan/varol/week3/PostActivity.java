package numan.varol.week3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {

    ImageView img;
    TextView txtMessage;
    ImageButton btnOk;
    ImageButton btnCancel;
    static final int CAPTURE_IMAGE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        txtMessage = (EditText)findViewById(R.id.txtMessage);
        img = findViewById(R.id.imageView);

        img.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 if (intent.resolveActivity(getPackageManager()) != null){
                     startActivityForResult(intent, CAPTURE_IMAGE);
                 }


             }
         });
                btnCancel = (ImageButton) findViewById(R.id.btnCancel);
                btnOk = (ImageButton) findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("msg", txtMessage.getText());
                        bundle.putParcelable("bitmap", ((BitmapDrawable) img.getDrawable()).getBitmap());
                        intent.putExtras(bundle);
                        setResult(Activity.RESULT_OK);
                        finish();
                    }
                });


                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setResult(Activity.RESULT_CANCELED);
                        finish();
                    }
                });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAPTURE_IMAGE && resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                Bitmap image = (Bitmap) bundle.get("data");
                img.setImageBitmap(image);
            }
        }



}