package com.shashank.navigationdrawer.Dashboard;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.shashank.navigationdrawer.R;
public class HardwareService extends Fragment
{

   private ListView listView;
    private String mTitle[] = {"Laptop", "Motherboard ", "CPU", "Keyboard","Server"};
   private String mDescription[] = {"All reparing Service", "Installation of softwres,windows,etc", "Anual Maintance", "New IT Setup","Buy a Pc"};
   private int images[] = {R.drawable.laptop, R.drawable.cpu, R.drawable.laptop, R.drawable.laptop, R.drawable.cpu};
    // so our images and other things are set in array

    // now paste some images in drawable

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_hardware, container, false);

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


