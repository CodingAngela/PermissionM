package com.example.permisssonm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PermissionAdapter extends ArrayAdapter<PermissionUtils> {
    private int resourceId;
    public PermissionAdapter(Context context, int textViewResourceId, List<PermissionUtils> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PermissionUtils permissionUtils = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }
        else {
            view = convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.text_name);
        textView.setText(permissionUtils.getName());
//        Button button = (Button) view.findViewById(R.id.bottom1);
//        button.setText(permission.getName());
        return view;
    }
}