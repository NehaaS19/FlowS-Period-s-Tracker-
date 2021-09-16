package com.example.naari;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import static android.content.Context.MODE_PRIVATE;

public class LoginTabFragment extends Fragment {
    EditText email,pass;
    private float v;
    Button login;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root=(ViewGroup)inflater.inflate(R.layout.login_tab_fragment,container,false);
        sharedPreferences = this.getActivity().getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
        final Boolean isloggedin = sharedPreferences.getBoolean("ISLOGGEDIN",false);

        final String required_email = sharedPreferences.getString("EMAIL","DEFAULT_EMAIL");
        final String required_password = sharedPreferences.getString("PASSWORD","DEFAULT_PASSWORD");
        email=root.findViewById(R.id.email);
        pass=root.findViewById(R.id.pass);
        login=root.findViewById(R.id.login);

        email.setAlpha(v);
        pass.setAlpha(v);
        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(required_email, required_password);
            }
        });

        return root;
    }



    private void validate(String required_email, String required_password) {
        String email_in = email.getText().toString();
        String password_in = pass.getText().toString();
        if (!TextUtils.isEmpty(email_in) && !TextUtils.isEmpty(password_in)){
            if (email_in.contains("@")){
                isEmailLogin(email_in, password_in, required_email, required_password);
            }
        }else {
            Toast.makeText(getActivity(),"Please check the fields",Toast.LENGTH_LONG).show();
        }
    }

    private void isEmailLogin(String email, String password, String required_email, String required_password) {
        if(email.equals(required_email) && password.equals(required_password)) {
            sharedPreferences.edit().putBoolean("ISLOGGEDIN",true).apply();
            startMainActivity();
        }
        else {
            Toast.makeText(getActivity(),"Email address or password is incorrect",Toast.LENGTH_LONG).show();
        }
    }

    private void startMainActivity() {
        MainActivity.start(getActivity());
        getActivity().finish();
    }
}
