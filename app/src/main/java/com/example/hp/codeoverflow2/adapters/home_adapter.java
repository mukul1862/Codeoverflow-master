package com.example.hp.codeoverflow2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.codeoverflow2.R;
import com.example.hp.codeoverflow2.model.Articlelist;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Bansal on 10/1/2017.
 */

public class home_adapter extends ArrayAdapter<Articlelist> {

    private final Context context;
    public TextView title, tags;

    public home_adapter(Context context, ArrayList<Articlelist> objects) {
        super(context, 0, objects);
        this.context = context;
    }
    public class Holder {
        TextView title;
        TextView tags;
        ImageView im_language;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.modifiedarticlelist, null);

        holder.title=(TextView) view.findViewById(R.id.textView2);
        holder.title.setText(getItem(position).title);
        holder.tags=(TextView) view.findViewById(R.id.text4);
        holder.tags.setText(getItem(position).tags);
        return view;
    }
}
