package com.example.sengkhunlim.studentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ShowStudentsActivity extends AppCompatActivity {

    TextView student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);

        student = findViewById( R.id.studentList );
        Scanner scan = null;

        try {

            scan = new Scanner( openFileInput("students.txt" ) );

        } catch ( FileNotFoundException e ) { e.printStackTrace(); }

        String studentList = "";

        while( scan.hasNextLine() ) {

            String student = scan.nextLine();
            student += "\t\t\t";
            studentList += student;

        }

        student.setText( studentList );

    }
}
