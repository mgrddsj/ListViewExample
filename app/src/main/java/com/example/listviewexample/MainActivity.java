package com.example.listviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    ListView listView;
    GridView gridView;
    List<Player> list;
    boolean isListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        gridView = findViewById(R.id.gridView);
        list= getPlayers();
        MyAdapter adapter=new MyAdapter(this,R.id.listview,list);
        listView.setAdapter(adapter);
        isListView = true;

    }

    public List getPlayers()
    {
        List<Player> list = Arrays.asList(new Player[]{
                new Player("Doris", 16, 100000, "Basketball", R.drawable.member_placeholder_female),
                new Player("LeBron James", 34, 40000000, "Basketball", R.drawable.team_man_placeholder),
                new Player("Kevin Durant", 31, 30000000, "Basketball", R.drawable.team_man_placeholder),
                new Player("Kyrie Irving", 27, 20100000, "Basketball", R.drawable.team_man_placeholder),
                new Player("James Harden", 30, 28300000, "Basketball", R.drawable.team_man_placeholder),
                new Player("Stephen Curry", 31, 37460000, "Basketball", R.drawable.team_man_placeholder),
                new Player("Lionel Messi",32,44224400.00,"football",R.drawable.mesi),
                new Player("David Robert Joseph Beckham",44,1291800.00,"football",R.drawable.beckham),
                new Player("Hanyu Yuzulu",24,500000,"figure skating",R.drawable.hanyu),
                new Player("Zhang Jike",31,500000,"Ping-pong",R.drawable.zhang),
        });
        return list;
    }

    public void startImageViewerActivity(int imageResource)
    {
        Intent intent = new Intent(this, ImageViewerActivity.class);
        intent.putExtra("image", imageResource);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.switch_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_switch:
                if (isListView)
                {
                    changeToGridView();
                }
                else
                {
                    changeToListView();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeToGridView()
    {
        setContentView(R.layout.activity_main_gridview);
        GridViewAdapter adapter = new GridViewAdapter(this, R.id.gridView, list);
        gridView.setAdapter(adapter);
        isListView = false;
    }

    public void changeToListView()
    {
        setContentView(R.layout.activity_main);
        MyAdapter adapter = new MyAdapter(this,R.id.listview, list);
        listView.setAdapter(adapter);
        isListView = true;
    }
}
