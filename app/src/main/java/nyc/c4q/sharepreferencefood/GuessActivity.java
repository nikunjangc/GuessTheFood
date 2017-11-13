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
import java.util.Map;

public class GuessActivity extends AppCompatActivity {

    private EditText guess_food;
    private Button checkButton;
    private SharedPreferences check;
    boolean test=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        guess_food =(EditText) findViewById(R.id.guess_food_Edittext);
        checkButton =(Button) findViewById(R.id.check_button);
        check = getApplicationContext().getSharedPreferences(MainActivity.SHARED_PREFS_KEY, MODE_PRIVATE);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,?> keys=check.getAll();

                for (Map.Entry<String,?> entry:keys.entrySet()) {

                    if (entry.getKey().equals(guess_food.getText().toString())) {
                        test=true;
                        break;
                    }
                }
                if (true) {
                    Toast t = Toast.makeText(getApplicationContext(), "YOu gussed that right.", Toast.LENGTH_LONG);
                    t.show();
                }
                   else {
                        Toast t = Toast.makeText(getApplicationContext(), "YOu gussed it wrong.", Toast.LENGTH_LONG);
                        t.show();

                    }
                }
        });
    }
}
