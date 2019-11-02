package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.week7.dataModels.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView ListViewStudents;
    private ArrayList<Student> arrayListStudent = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewStudents = findViewById(R.id.ListViewStudent);


        arrayListStudent.add(new Student("Lee Boon Kong", "DIT111","Computer Science"));
        arrayListStudent.add(new Student("LOK", "DIT112","Cyber Security"));
        arrayListStudent.add(new Student("CHUN", "DIT113","Facebook"));
        arrayListStudent.add(new Student("WU", "DIT114","Wechat"));


        StudentAdapter adapter = new StudentAdapter(arrayListStudent, this);

       ListViewStudents.setAdapter(adapter);

       ListViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Student student = (Student) parent.getAdapter().getItem(position);

               Intent i = new Intent(MainActivity.this , StudentProfileActivity.class);

               i.putExtra("name",student.getStudentName());
               i.putExtra("id", student.getStudentID());
               i.putExtra("course", student.getStudentCourse());
               startActivity(i);
           }
       });

    }


}
