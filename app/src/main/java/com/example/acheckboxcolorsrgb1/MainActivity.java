package com.example.acheckboxcolorsrgb1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.acheckboxcolorsrgb1.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private CheckBox redCheckBox, greenCheckBox, blueCheckBox;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rgb_layout);
        layout = findViewById(R.id.rgb1);
        redCheckBox = findViewById(R.id.redCheckBox);
        greenCheckBox = findViewById(R.id.greenCheckBox);
        blueCheckBox = findViewById(R.id.blueCheckBox);
        textView = findViewById(R.id.textView);
        redCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateBackgroundColor());
        greenCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateBackgroundColor());
        blueCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateBackgroundColor());
        ViewCompat.setOnApplyWindowInsetsListener(layout, (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });
    }
    private void updateBackgroundColor()
    {
        int red = redCheckBox.isChecked() ? 255 : 0;
        int green = greenCheckBox.isChecked() ? 255 : 0;
        int blue = blueCheckBox.isChecked() ? 255 : 0;
        int backgroundColor = Color.rgb(red, green, blue);
        layout.setBackgroundColor(backgroundColor);
        int textColor = Color.rgb(255 - red, 255 - green, 255 - blue);
        textView.setTextColor(textColor);
    }
}
