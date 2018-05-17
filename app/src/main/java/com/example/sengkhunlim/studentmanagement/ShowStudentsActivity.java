package com.example.sengkhunlim.studentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowStudentsActivity extends AppCompatActivity {

    ListView student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);

        Scanner scan = null;
        student = findViewById( R.id.studentList );
        ArrayList<String> studentList = new ArrayList<>();

        try {

            scan = new Scanner( openFileInput("students.txt" ) );

        } catch ( FileNotFoundException e ) { e.printStackTrace(); }

        // Read the information from the txt file into the arraylist
        while( scan.hasNextLine() ) {

            studentList.add( scan.nextLine() );

        }

        StudentInfoAdapter adapter = new StudentInfoAdapter( this, studentList );

        student.setAdapter( adapter );

    }
}
