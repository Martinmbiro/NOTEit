package com.vickikbt.notekeeper.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.vickikbt.notekeeper.R;
import com.vickikbt.notekeeper.UI.MainActivity;

public class AddEditNoteActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextDescription;
    private NumberPicker numberPickerPriority;

    public static final String EXTRA_ID="EXTRA_ID";
    public static final String EXTRA_TITLE="VickiKbt";
    public static final String EXTRA_DESCRIPTION="Victor Kabata";
    public static final String EXTRA_PRIORITY="10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle=findViewById(R.id.editText_title);
        editTextDescription=findViewById(R.id.editText_description);

        numberPickerPriority=findViewById(R.id.numberPicker_priority);
        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

       Intent intent=getIntent();
               if(intent.hasExtra(EXTRA_ID)){
                   setTitle("Edit Note");
                   editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
                   editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
                   numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
               }
               else {
                   setTitle("Add Note");
               }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_save:
                saveNote();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title=editTextTitle.getText().toString();
        String description=editTextDescription.getText().toString();
        int priority=numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "One of the fields is empty", Toast.LENGTH_SHORT).show();
        }

        Intent data=new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        int id=getIntent().getIntExtra(EXTRA_ID, -1);
        if (id!=-1){
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);


    }
}