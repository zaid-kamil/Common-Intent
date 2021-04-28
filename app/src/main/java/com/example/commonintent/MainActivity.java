package com.example.commonintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText editWeb = findViewById(R.id.editWeb);
        TextInputEditText editAddr = findViewById(R.id.editAddr);
        TextInputEditText editShare = findViewById(R.id.editShare);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnAddr = findViewById(R.id.btnAddr);
        Button btnShare = findViewById(R.id.btnShare);
        btnWeb.setOnClickListener(view -> {
            String url = editWeb.getText().toString();
            Uri webPage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
            startActivity(intent);
        });
        btnAddr.setOnClickListener(view -> {
            String addr = editAddr.getText().toString();
            Uri loc = Uri.parse("geo:0,0?q=" + addr);
            Intent intent = new Intent(Intent.ACTION_VIEW, loc);
            startActivity(intent);
        });
        btnShare.setOnClickListener(view -> {
            String text = editShare.getText().toString();
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder.from(this)
                    .setText(text)
                    .setType(mimeType)
                    .setChooserTitle("Share with Frds")
                    .startChooser();
        });
    }
}