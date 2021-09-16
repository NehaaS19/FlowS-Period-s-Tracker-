package com.example.naari;

import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static android.content.Context.MODE_PRIVATE;


public class SignupTabFragment extends Fragment {
    EditText email, pass, name ,confirmpass;
    Button signup;
    private float v;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        init(root);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        return root;
    }

    private void validate() {
        String email_in = email.getText().toString();
        String Fullname = name.getText().toString();
        String password_in = pass.getText().toString();
        String re_password = confirmpass.getText().toString();
        if (!TextUtils.isEmpty(Fullname)  && !TextUtils.isEmpty(email_in) && !TextUtils.isEmpty(password_in)){
            if (email_in.contains("@")){
                if (password_in.equals(re_password)){
                    startMainActivity();
                    startRegistration(email_in,Fullname, password_in);
                }else {
                    Toast.makeText(getActivity(), getString(R.string.password_mismatch), Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(getActivity(), getString(R.string.email_not_valid), Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getActivity(), getString(R.string.check_fields), Toast.LENGTH_LONG).show();
        }
    }

    private void startRegistration( String email_in,String name, String password_in) {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EMAIL",email_in);
        editor.putString("NAME",name);
        editor.putString("PASSWORD",password_in);
        editor.putBoolean("ISLOGGEDIN",true);
        editor.apply();
        startMainActivity();

    }

    private void startMainActivity() {
       /* Intent intent=new Intent(SignUpTagFragment.this.getActivity(),HomeActivity.class);
        startActivity(intent);
        System.out.println("neha");*/
        MainActivity.start(getActivity());
        getActivity().finish();
    }

    private void init(View view) {
        email = view.findViewById(R.id.email);
        name = view.findViewById(R.id.name);
        pass = view.findViewById(R.id.pass);
        confirmpass = view.findViewById(R.id.confirmpass);
        signup = view.findViewById(R.id.signup);

        email.setAlpha(v);
        pass.setAlpha(v);
        name.setAlpha(v);
        email.animate().translationX(0).alpha(1).setDuration(800).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).start();
        name.animate().translationX(0).alpha(1).setDuration(800).start();
    }


}

