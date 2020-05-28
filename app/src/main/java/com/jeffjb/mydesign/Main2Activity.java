package com.jeffjb.mydesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {



    ListView listView;

//    private  Toolbar mTopToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


//        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(mTopToolbar);


        final String[]title = getResources().getStringArray(R.array.Title);
        final String[]detail = getResources().getStringArray(R.array.Detail);
//        final String[]detail1 = getResources().getStringArray(R.array.Subtitle);

        listView = findViewById(R.id.list);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, title);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = detail [position];
//                String s = detail1 [position];
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("detail", t);
//                intent.putExtra("detail1", s);
                startActivity(intent);

            }
        });

    }



@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu,menu);


    return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                Toast.makeText(this, "you clicked about", Toast.LENGTH_SHORT).show();
                return true;
//            case R.id.action_favorite:
//                Intent intent = new Intent(Main2Activity.this, Contact.class);
//                startActivity(intent);
//
//                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

}


