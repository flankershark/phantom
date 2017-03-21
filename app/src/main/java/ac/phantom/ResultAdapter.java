package ac.phantom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ac.phantom.model.Dish;

/**
 * Created by ron on 1/31/17.
 */

public class ResultAdapter extends ArrayAdapter<Dish> {
    public ResultAdapter(Context context, int resource, List<Dish> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Dish data = super.getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(super.getContext()).inflate(R.layout.item_result, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_result_image);
        TextView titleView = (TextView) convertView.findViewById(R.id.item_result_title);
        TextView descView  = (TextView) convertView.findViewById(R.id.item_result_desc);
        TextView restrictView = (TextView) convertView.findViewById(R.id.item_result_restrict);

        if (data != null) {
            if (imageView != null) imageView.setImageResource(data.image);
            if (titleView != null) titleView.setText(data.title);
            if (descView  != null) descView.setText(data.restaurant.name);
            if (restrictView != null) restrictView.setText(data.restrictions.toString());
        }

        return convertView;
    }
}

//:)~
