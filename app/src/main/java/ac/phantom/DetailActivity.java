package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView;

public class DetailActivity extends Activity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = (TextView) findViewById(R.id.textView);//text view reference

        String string = "Egg McMuffin\n\n\nDetail\b\n\n Restaurant name : McDonald's\n Address : 1380 Collage Square, Ottawa, ON\n Phone number : +1 (613) 255-0000 \n\n\n Nutrition :\n\n Calories : 290 Kcal\n Carbohydrate : 29 g\n Fat : 11 g\n\n Ingredients : \n\n\n\n" ;

        textView.setText(string);
       // entry_headword


        //imageView.setImageIcon(image);
    }

    public void mapOnClick(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        super.startActivity(intent);
    }
}


