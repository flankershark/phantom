package ac.phantom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ac.phantom.model.User;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void loginOnClick(View view) {
        EditText email = (EditText) findViewById(R.id.email_id);
        EditText passwd = (EditText) findViewById(R.id.textPassword);
        User user = DummyDataSource.login(email.getText().toString(), passwd.getText().toString());

        if (user != null) {
            Intent intent = new Intent(this, SearchActivity.class);
            intent.putExtra(DummyDataSource.EXTRA_RESTRICT, user.restrictions.toString());
            super.startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "Failed to login", Toast.LENGTH_SHORT).show();
        }
    }

}
