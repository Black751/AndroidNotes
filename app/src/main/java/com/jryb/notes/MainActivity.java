package com.jryb.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public static MainActivity instance;

    public  ListView lv;
    public List notesList;
    public HashMap<String, String> notes;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance=this;

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        lv = (ListView)findViewById(R.id.main_lv);
        lv.setOnItemClickListener(this);
        notesList = new ArrayList();
        notes = new HashMap<>();


        String[] list = new String[notesList.size()];
        notesList.toArray(list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setIcon(R.drawable.ic_toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_addNotes:
                onAddNote();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onAddNote(){
        Intent iToAddNoteActivity = new Intent(this, AddNotesActivity.class);
        startActivity(iToAddNoteActivity);
    }


    public void updateList(){
        String[] list = new String[notes.size()];
        notesList.toArray(list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intentToShow = new Intent();
        intentToShow.setClass(this, ShowNoteActivity.class);
        intentToShow.putExtra("position",position);
        startActivity(intentToShow);
    }
}

