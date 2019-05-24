package cn.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrz.R;

import org.example.entity.Fruit;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
    private Context context;
    private static final String TAG = "ListViewAdapter";

    public ListViewAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHoder viewHoder;
        if (convertView != null){
            view = convertView;
            viewHoder = (ViewHoder) view.getTag();
        }else {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false);
            viewHoder = new ViewHoder();
            viewHoder.imageView = (ImageView) view.findViewById(R.id.ListView_item_img);
            viewHoder.textView =  (TextView) view.findViewById(R.id.ListView_item_name);
            view.setTag(viewHoder);
        }
        viewHoder.imageView.setImageResource(fruit.getImageId());
        viewHoder.textView.setText(fruit.getName());
        return view;
    }

    class ViewHoder{
        ImageView imageView;
        TextView textView;

    }
}
