package nyc.c4q.sharepreferencefood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS_KEY = "sharedPrefsTEsting";

   // ArrayList<String> foodList= new ArrayList<>();
    private EditText favourite_food;
    private Button saveButton;
    private Button guess;
    private SharedPreferences save;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        favourite_food =(EditText) findViewById(R.id.favourite_food_edittext);
        saveButton =(Button) findViewById(R.id.save_button);
        guess =(Button) findViewById(R.id.guess_food_button);

       save = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);

       saveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences.Editor editor = save.edit();
               editor.putString(favourite_food.getText().toString(), favourite_food.getText().toString());
            //   foodList.add( favourite_food.getText().toString());
               editor.commit();
               Toast t = Toast.makeText(getApplicationContext(), ""+favourite_food.getText(), Toast.LENGTH_LONG);
               t.show();

           }

       });
       guess.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, GuessActivity.class);
               startActivity(intent);

           }
       });

    }
}