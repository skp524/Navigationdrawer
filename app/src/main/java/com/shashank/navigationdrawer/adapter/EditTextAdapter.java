package com.shashank.navigationdrawer.adapter;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.shashank.navigationdrawer.MaintainenceServiceFragment;
import com.shashank.navigationdrawer.R;
import com.shashank.navigationdrawer.model.EditModel;

import java.util.ArrayList;


public class EditTextAdapter extends BaseAdapter {

    private Fragment context;
    public static ArrayList<EditModel> editModelArrayList;

    public EditTextAdapter(Fragment context, ArrayList<EditModel> editModelArrayList) {

        this.context = context;
        this.editModelArrayList = editModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return editModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return editModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.edit_text_list_view, null, true);

            holder.editText = (EditText) convertView.findViewById(R.id.editid);
            holder.title=(TextView)convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.editText.setText(editModelArrayList.get(position).getEditTextValue());
        holder.title.setText(editModelArrayList.get(position).getTitle());
        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editModelArrayList.get(position).setEditTextValue(holder.editText.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return convertView;
    }

    private class ViewHolder {

        protected EditText editText;
        protected TextView title;
    }
}
