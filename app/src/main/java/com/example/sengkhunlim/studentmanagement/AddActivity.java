package com.example.sengkhunlim.studentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity {

    EditText inputId, inputName, inputAddress, inputYear;
    RadioGroup btnSex;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Add");

        inputId = findViewById( R.id.inputId );
        inputName = findViewById( R.id.inputName );
        btnSex = findViewById( R.id.btnSex );
        inputAddress = findViewById( R.id.inputAddress );
        inputYear = findViewById( R.id.inputYearOfStudy );
        btnSave = findViewById( R.id.btnSave );

        btnSex.check( R.id.btnMale );

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String id, name, sex, address;
                int year;

                id = inputId.getText().toString();
                name = inputName.getText().toString();
                sex = getRadioButtonText( btnSex.getCheckedRadioButtonId() );
                address = inputAddress.getText().toString();
                year = Integer.parseInt( inputYear.getText().toString() );

                try {

                    PrintStream out = new PrintStream( openFileOutput( "students.txt", MODE_APPEND ) );
                    out.println(
                            id + ", " +
                            name + ", " +
                            sex + ", " +
                            address + ", " +
                            + year
                    );
                    out.close();

                } catch ( FileNotFoundException e ) { e.printStackTrace(); }

                Toast.makeText(getApplicationContext(), "New student has successfully added", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }

        });

    }

    public static String getRadioButtonText( int id ) {

        String result = "";

        switch ( id ) {

            case R.id.btnMale:
                result = "Male";
                break;

            case R.id.btnFemale:
                result = "Female";
                break;

        }

        return result;

    }

}
