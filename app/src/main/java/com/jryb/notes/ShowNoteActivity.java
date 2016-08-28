package com.jryb.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Youss on 27/08/2016.
 */
public class ShowNoteActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        Toolbar toolbar = (Toolbar)findViewById(R.id.show_note_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);

        String strTitle = MainActivity.instance.notesList.get(position).toString();
        String strContent = MainActivity.instance.notes.get(strTitle);

        TextView title = (TextView)findViewById(R.id.show_note_title);
        title.setText(strTitle);
        TextView content = (TextView)findViewById(R.id.show_note_content);
        content.setText(strContent);
    }

}
