package com.yfz.data_structure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yfz.data_structure.linkedList.SingleLinkedListActivity;
import com.yfz.data_structure.linkedList.SingleLoopLinkedListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start_singleLinkedListActivity(View view){
//        startActivity(new Intent(MainActivity.this, SingleLinkedListActivity.class));
        startActivity(new Intent(MainActivity.this, SingleLoopLinkedListActivity.class));

    }
}