package com.example.book;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class NewBookActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.booklistsql.REPLY";

    private EditText EditTextIsbnNo;
    private EditText EditTextTitle;
    private EditText EditTextAuthor;
    private EditText EditTextDescription;
    private EditText EditTextPublisher;
    private EditText EditTextPublishedDate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        EditTextIsbnNo = findViewById(R.id.editTextIsbnNo);
        EditTextTitle = findViewById(R.id.editTextTitle);
        EditTextAuthor = findViewById(R.id.editTextAuthor);
        EditTextDescription = findViewById(R.id.editTextDescription);
        EditTextPublisher = findViewById(R.id.editTextPublisher);
        EditTextPublishedDate = findViewById(R.id.editTextPublishedDate);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(EditTextIsbnNo.getText()) || TextUtils.isEmpty(EditTextTitle.getText()) || (TextUtils.isEmpty(EditTextTitle.getText()))) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {

                Book book = new Book(EditTextIsbnNo.getText().toString(),EditTextTitle.getText().toString(),
                        EditTextAuthor.getText().toString(), EditTextDescription.getText().toString(),
                        EditTextPublisher.getText().toString(), EditTextPublishedDate.getText().toString() );








                replyIntent.putExtra(EXTRA_REPLY, (Serializable) book);

                setResult(RESULT_OK, replyIntent);

            }
            finish();
        });
    }
}