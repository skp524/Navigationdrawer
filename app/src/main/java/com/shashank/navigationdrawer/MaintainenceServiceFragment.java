package com.shashank.navigationdrawer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.shashank.navigationdrawer.adapter.EditTextAdapter;
import com.shashank.navigationdrawer.model.EditModel;
import java.util.ArrayList;

public class MaintainenceServiceFragment extends Fragment
{
    private ListView lv;
    private EditTextAdapter editTextAdapter;
    public ArrayList<EditModel> editModelArrayList;

    String mTitle[] = {"Laptop", "Desktop", "Printer", "Server","Cartridge","Software"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_maintainence_service, container, false);
        lv = v.findViewById(R.id.listView);

        editModelArrayList = populateList();
        editTextAdapter = new EditTextAdapter(this,editModelArrayList);
        lv.setAdapter(editTextAdapter);

        return v;

    }

    private ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(int i = 0; i < mTitle.length; i++){
            EditModel editModel = new EditModel();
            editModel.setTitle(mTitle[i]);
            list.add(editModel);
        }

        return list;
    }

}
