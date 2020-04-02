package com.shashank.navigationdrawer;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MaintainenceServiceFragment extends Fragment
{

    ListView listView;

    String mTitle[] = {"Laptop", "Desktop", "Printer", "Server","Cartridge","Software"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_maintainence_service, container, false);

        listView = v.findViewById(R.id.listView);
        // now create an adapter class

        MyAdapterr adapter = new MyAdapterr(getActivity(), mTitle);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0)
                {

                }
                if (position ==  1) {
                    Toast.makeText(getContext(), "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(getContext(), "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(getContext(), "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(getContext(), "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // so item click is done now check list view


        return v;
    }
}

class MyAdapterr extends ArrayAdapter<String> {

    Context context;
    String rTitle[];


    MyAdapterr(Context c, String title[]) {
        super(c, R.layout.row, R.id.checkBox, title);
        this.context = c;
        this.rTitle = title;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.row, parent, false);
        TextView myTitle = row.findViewById(R.id.checkBox);

        // now set our resources on views

        myTitle.setText(rTitle[position]);


        return row;
    }
}
