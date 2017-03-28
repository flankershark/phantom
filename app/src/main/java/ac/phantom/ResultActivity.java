package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ac.phantom.model.Dish;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_result);

        super.setTitle(String.format("!%s, %s",
                super.getIntent().getStringExtra(DummyDataSource.EXTRA_RESTRICT),
                super.getIntent().getStringExtra(DummyDataSource.EXTRA_QUERY)));
        ListView resultList = (ListView) super.findViewById(R.id.result_list);
        if (resultList != null) {
            resultList.setAdapter(new ResultAdapter(this, R.layout.item_result, DummyDataSource.search(
                    super.getIntent().getStringExtra(DummyDataSource.EXTRA_QUERY),
                    super.getIntent().getStringExtra(DummyDataSource.EXTRA_RESTRICT))));
            resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ResultActivity.super.startActivity(
                        new Intent(ResultActivity.this, DetailActivity.class).putExtra(
                            DummyDataSource.EXTRA_DISH,
                            ((Dish) parent.getItemAtPosition(position)).id
                        )
                    );
                }
            });
        }
    }
}
