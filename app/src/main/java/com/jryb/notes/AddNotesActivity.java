package com.jryb.notes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Youss on 26/08/2016.
 */
public class AddNotesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        toolbar = (Toolbar)findViewById(R.id.add_notes_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("test");
        getSupportActionBar().setIcon(R.drawable.ic_toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_add_note,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_validNote:
                onValidNote();
        }
        return super.onOptionsItemSelected(item);
    }
    private void onValidNote(){
        EditText title = (EditText)findViewById(R.id.add_notes_title);
        EditText content = (EditText)findViewById(R.id.add_notes_content);

        if(title.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Le titre ne peux être vide",Toast.LENGTH_SHORT).show();
            return;
        }
        if(content.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Le contenu ne peux être vide",Toast.LENGTH_SHORT).show();
            return;
        }
        MainActivity.instance.notesList.add(title.getText().toString());
        MainActivity.instance.notes.put(title.getText().toString(), content.getText().toString());

        MainActivity.instance.updateList();
        Toast.makeText(this, "Note créé", Toast.LENGTH_SHORT).show();
        finish();
    }
}
