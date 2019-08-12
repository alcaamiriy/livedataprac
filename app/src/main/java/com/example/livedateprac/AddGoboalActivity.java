package com.example.livedateprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class AddGoboalActivity extends AppCompatActivity {
    private GobolViewModel mGobolViewModel;
    private Button mSaveBtn;
    private EditText mGobolEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goboal);

        mSaveBtn = findViewById(R.id.save_btn);
        mGobolEditText = findViewById(R.id.gobol_edt);
        mGobolEditText.setImeActionLabel("Done", KeyEvent.KEYCODE_ENTER);

        mGobolViewModel = new GobolViewModel(getApplication());

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("gobolName", mGobolEditText.getText());
                setResult(2, intent);
                finish();
            }
        });
    }
}
