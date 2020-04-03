package com.shashank.navigationdrawer.Dashboard;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.navigationdrawer.ITSetupFragment;
import com.shashank.navigationdrawer.MaintainenceServiceFragment;
import com.shashank.navigationdrawer.R;


public class DashboardFragment extends Fragment
{

    ListView listView;
    String mTitle[] = {"Hardware Issue", "Software Issue", "Maintenance Service", "IT Setup","Consult & Buy"};
    String mDescription[] = {"All reparing Service", "Installation of softwres,windows,etc", "Anual Maintance", "New IT Setup","Buy a Pc"};
    int images[] = {R.drawable.laptop, R.drawable.cpu, R.drawable.laptop, R.drawable.laptop, R.drawable.cpu};
    // so our images and other things are set in array

    // now paste some images in drawable

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dashboard, container, false);

        listView = v.findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(getActivity(), mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0)
                {

                    FragmentManager ft = getFragmentManager();
                    FragmentTransaction fragmentTransaction =ft.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, new HardwareService());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                if (position ==  1) {

                }
                if (position ==  2) {
                    FragmentManager ft = getFragmentManager();
                    FragmentTransaction fragmentTransaction =ft.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, new MaintainenceServiceFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                if (position ==  3) {
                    FragmentManager ft = getFragmentManager();
                    FragmentTransaction fragmentTransaction =ft.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, new ITSetupFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
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

class MyAdapter extends ArrayAdapter<String> {

    Context context;
    String rTitle[];
    String rDescription[];
    int rImgs[];

    MyAdapter(Context c, String title[], String description[], int imgs[]) {
        super(c, R.layout.dashboard_list_item, R.id.textView1, title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = description;
        this.rImgs = imgs;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.dashboard_list_item, parent, false);
        ImageView images = row.findViewById(R.id.image);
        TextView myTitle = row.findViewById(R.id.textView1);
        TextView myDescription = row.findViewById(R.id.textView2);

        // now set our resources on views
        images.setImageResource(rImgs[position]);
        myTitle.setText(rTitle[position]);
        myDescription.setText(rDescription[position]);


        return row;
    }
}
