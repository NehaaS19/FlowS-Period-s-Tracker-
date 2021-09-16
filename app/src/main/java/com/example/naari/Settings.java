package com.example.naari;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class Settings extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button b2;
    EditText e1, e2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String cycledays;
    private String periodlength;
    private String cycledays_edit = "";
    private String perioddays_edit = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        e1 =  findViewById(R.id.editText);
        e2 =  findViewById(R.id.editText2);
        b2 =  findViewById(R.id.button2);
        b2.setOnClickListener(this);

        sharedPreferences = this.getSharedPreferences("com.example.knowyourdate.ui.main", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        cycledays = sharedPreferences.getString("cycledays", "");
        periodlength = sharedPreferences.getString("periodlength", "");

        e1.setText(cycledays);
        e2.setText(periodlength);

        cycledays_edit = e1.getText().toString();
        perioddays_edit = e2.getText().toString();

        editor.putString("cycledays", cycledays_edit);
        editor.putString("periodlength", perioddays_edit);


    }

    @Override
    public void onClick(View v) {
        e1 = (EditText) this.findViewById(R.id.editText);
        e2 = (EditText) this.findViewById(R.id.editText2);
        Log.i("e1", e1.getText().toString());
        cycledays_edit = e1.getText().toString();
        perioddays_edit = e2.getText().toString();

        editor.putString("cycledays", cycledays_edit);
        editor.commit();
        editor.putString("periodlength", perioddays_edit);
        editor.commit();
    }
}