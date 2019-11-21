package com.example.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class GridViewAdapter extends BaseAdapter
{
    List<Player> listOfPlayers;
    Context context;

    public GridViewAdapter(@NonNull Context context, int resource, @NonNull List<Player> objects)
    {
        super();
        listOfPlayers = objects;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return listOfPlayers.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfPlayers.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View single_item_view = view;
        //Using this inflated view, we can get the access to the various UI widgets present in the row item XML file.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (single_item_view == null)
            single_item_view = inflater.inflate(R.layout.single_item_long, null);
        final Player player = listOfPlayers.get(i);

        TextView textView1 = single_item_view.findViewById(R.id.textView1);
        TextView textView2 = single_item_view.findViewById(R.id.textView2);
        TextView textView3 = single_item_view.findViewById(R.id.textView3);
        TextView textView4 = single_item_view.findViewById(R.id.textView4);
        ImageView imageView = single_item_view.findViewById(R.id.imageView);
        textView1.setText(player.getName());
        textView2.setText("Age: " + player.getAge());
        textView3.setText(player.getMainSport());
        textView4.setText("Worth: " + player.getWorth());
        imageView.setImageResource(player.getImageResource());

        //Opens ImageViewerActivity onClick listener.
        imageView.setClickable(true);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (context instanceof MainActivity)
                {
                    ((MainActivity) context).startImageViewerActivity(player.getImageResource());
                }
            }
        });

        return  single_item_view;
    }
}
