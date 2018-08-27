package com.tujuhsembilan.assessmentproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    private ArrayList<DataMember> memberList;
    private Context context;

    private static class ViewHolder {
        ImageView photoList;
        TextView nameList;
        TextView roleList;
        Button rateList;
    }

    CustomListAdapter(Context context, ArrayList<DataMember> memberList){
        super(context, R.layout.custom_list, memberList);
        this.memberList = memberList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent){
        DataMember memberData = memberList.get(position);
        ViewHolder viewHolder = new ViewHolder();

        final String name;
        final View result;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.custom_list, parent, false);
            viewHolder.photoList = view.findViewById(R.id.ivProfile);
            viewHolder.nameList = view.findViewById(R.id.tvNameList);
            viewHolder.roleList = view.findViewById(R.id.tvRoleList);
            viewHolder.rateList = view.findViewById(R.id.btnRate);
            result = view;
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            result = view;
        }

        name = viewHolder.nameList.getText().toString();
        viewHolder.photoList.setContentDescription(memberData.getPhotoList());
        viewHolder.nameList.setText(memberData.getNameList());
        viewHolder.roleList.setText(memberData.getRoleList());
        viewHolder.rateList.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });

        return result;
    }
}
