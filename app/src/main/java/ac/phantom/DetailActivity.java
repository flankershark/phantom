package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public void mapOnClick(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        super.startActivity(intent);
    }
}
