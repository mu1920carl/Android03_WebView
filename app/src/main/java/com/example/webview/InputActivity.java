package com.example.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputActivity extends AppCompatActivity {
    static String ExtraValue = "ExtraValue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button webButton;
        EditText webURL;


        webButton = findViewById(R.id.webButton);
        webURL = findViewById(R.id.urlEditText);

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlText = webURL.getText().toString();
                Intent webIntent = new Intent(InputActivity.this, WebActivity.class);
                webIntent.putExtra(ExtraValue, urlText);
                startActivity(webIntent);

            }
        });

    }
}