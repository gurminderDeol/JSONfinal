package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.json.Model.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstStudentData;
    private ArrayList<Student> studentArrayList;
    private ArrayList<String> iname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processJSON();
        lstStudentData = findViewById(R.id.lst1);
        iname = new ArrayList<>();

        for(Student str: studentArrayList)
        {
         iname.add(str.getSname());


        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,iname);
        lstStudentData.setAdapter(adapter);


        lstStudentData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


              

            }
        });

    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("StudentList.json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void processJSON() {
        String js = loadJSONFromAsset();
        if (js != null) {
            // Log.d("json",js);
            try {
                JSONArray mJSONArray = new JSONArray(js);

                studentArrayList = new ArrayList<>();

                for (int i = 0; i < mJSONArray.length(); i++) {


                    JSONObject mJSONObj = mJSONArray.getJSONObject(i);
                    //  Log.d("mjson", mJSONObj.toString());
                    if (mJSONObj.has("sid")) {


                        String id = mJSONObj.getString("sid");
                        String name = mJSONObj.getString("sname");
                        String gender = mJSONObj.getString("gender");

                        //  Log.d("mjson_ID", String.valueOf(id));
                        //  Log.d("mjson_name", String.valueOf(name));
                        //  Log.d("mjson_gender", String.valueOf(gender));
                        studentArrayList.add(new Student(id, name, gender));
                        Log.d("mjson_ID", String.valueOf(id));




                    }


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }




        }


    }

}
