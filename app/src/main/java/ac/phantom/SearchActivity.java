package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchActivity extends Activity {
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter
            = ArrayAdapter.createFromResource(this,R.array.allergies,android.R.layout.simple_spinner_item);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void searchOnClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        super.startActivity(intent);
    }
}
