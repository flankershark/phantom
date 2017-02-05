package ac.phantom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ac.phantom.model.SearchResult;

/**
 * Created by ron on 1/31/17.
 */

public class ResultAdapter extends ArrayAdapter<SearchResult> {
    public ResultAdapter(Context context, int resource, List<SearchResult> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchResult data = super.getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(super.getContext()).inflate(R.layout.item_result, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_result_image);
        TextView titleView = (TextView) convertView.findViewById(R.id.item_result_title);
        TextView descView  = (TextView) convertView.findViewById(R.id.item_result_desc);

        if (data != null && data.dish != null) {
            if (imageView != null) imageView.setImageResource(data.dish.image);
            if (titleView != null) titleView.setText(data.dish.title);
            if (descView  != null) descView.setText(data.dish.restaurant.name);
        }

        return convertView;
    }
}

//:)~
