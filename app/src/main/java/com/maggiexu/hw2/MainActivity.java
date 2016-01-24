package com.maggiexu.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ToDoListView = (ListView) findViewById(R.id.ToDoList);
        ToDoListView.setOnItemClickListener(this);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        ToDoListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
        ListView ToDoListView = (ListView) findViewById(R.id.ToDoList);
        list.remove(position);
        adapter.notifyDataSetChanged();

    }

    public void add(View view) {
        EditText text = (EditText) findViewById(R.id.NewItem);
        list.add(text.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
