package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class GridViewActivity extends AppCompatActivity
{
    ListView listView;
    GridView gridView;
    List<Player> list;
    boolean isListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gridview);
        gridView = findViewById(R.id.gridView);
        list= getPlayers();
        GridViewAdapter adapter = new GridViewAdapter(this, R.id.gridView, list);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);
//        isListView = true;

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
}
