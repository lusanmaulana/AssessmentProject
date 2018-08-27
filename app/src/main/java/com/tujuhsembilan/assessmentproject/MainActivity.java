package com.tujuhsembilan.assessmentproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    Intent login;
    TextView tvName, tvRole;
    String name, role;

    Spinner sProject;
    ArrayList<String> projects = new ArrayList<>();
    ArrayAdapter<String> spinAdapter;

    CalendarView cvWeek;
    Long maxDate, minDate;
    Boolean cStatus;

    ListView lvMember;
    ArrayList<DataMember> memberList = new ArrayList<>();
    CustomListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvRole = findViewById(R.id.tvRole);
        sProject = findViewById(R.id.sProject);
        cvWeek = findViewById(R.id.calendarView);
        lvMember = findViewById(R.id.lvMember);

        login = new Intent(getIntent());
        name = "Username : " + login.getStringExtra(LoginActivity.STRING_EXTRA_MSG);
        role = "Role : Member";
        tvName.setText(name);
        tvRole.setText(role);

        for(int i=0; i<10; i++){
            projects.add("Project " + (i+1));
            memberList.add(new DataMember("Photo " + (i+1),"Udin " + (i+1), "Member " + (i+1)));
        }

        spinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, projects);
        sProject.setAdapter(spinAdapter);
        sProject.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> spinAdapter, View view, int position, long l) {
                String project = spinAdapter.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), project, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        maxDate = Calendar.getInstance().getTimeInMillis();
        minDate = maxDate - (86400000 * 6);
        cvWeek.setMaxDate(maxDate);
        cvWeek.setMinDate(minDate);
        cvWeek.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), "Selected Date: " + day + "-" + (month+1) + "-" + year, Toast.LENGTH_SHORT).show();
            }
        });
        cvWeek.setVisibility(View.GONE);
        cStatus = false;

        listAdapter = new CustomListAdapter(this, memberList);
        lvMember.setAdapter(listAdapter);
    }

    public void btnDateOnClick(View view){
        if(!cStatus){
            cvWeek.setVisibility(View.VISIBLE);
        }else{
            cvWeek.setVisibility(View.GONE);
        }
        cStatus = !cStatus;
    }

    public void btnSubmitOnClick(View view){
        Toast.makeText(getApplicationContext(), "Data sent.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed(){
        login = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(login);
        this.finish();
    }
}
