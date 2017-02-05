package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_result);

        ListView resultList = (ListView) super.findViewById(R.id.result_list);
        if (resultList != null) {
            resultList.setAdapter(new ResultAdapter(this, R.layout.item_result, DummyDataSource.search()));
            resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ResultActivity.this, DetailActivity.class);
                    ResultActivity.super.startActivity(intent);
                }
            });
        }
    }
}
