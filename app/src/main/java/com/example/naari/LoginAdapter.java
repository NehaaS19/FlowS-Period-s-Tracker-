package com.example.naari;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class LoginAdapter extends FragmentStatePagerAdapter{
    private Context context;
    String title[]={"Login","Register"};
    public LoginAdapter(FragmentManager fm,Context context){
        super(fm);
        this.context=context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment=new LoginTabFragment();
                return  loginTabFragment;
            case 1:
                SignupTabFragment signUpTagFragment=new SignupTabFragment();
                return  signUpTagFragment;
            default:return null;
        }
    }

}
