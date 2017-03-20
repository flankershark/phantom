package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {
EditText textBox;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        textBox  = (EditText) findViewById(R.id.Search_Edit_Text);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter
                = ArrayAdapter.createFromResource(this,R.array.allergies,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setPrompt("Allergies");

    }

    public void searchOnClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(DummyDataSource.EXTRA_QUERY, textBox.getText().toString());
        intent.putExtra(DummyDataSource.EXTRA_RESTRICT, spinner.getSelectedItem().toString());
        super.startActivity(intent);
    }
}
