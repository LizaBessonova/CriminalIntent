package com.bignerdranch.android.supportintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SupportLoginPage extends Fragment {
    private EditText mUserNameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_login_page, container, false);

       mUserNameEditText = (EditText)v.findViewById(R.id.username_field);

       mPasswordEditText = (EditText)v.findViewById(R.id.password_field);

       mLoginButton = (Button)v.findViewById(R.id.login_button);
       mLoginButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               if(mUserNameEditText.getText().toString().equals("admin") &&
                       mPasswordEditText.getText().toString().equals("111")  ) {
                   Intent intent = new Intent(getActivity(), SupportListActivity.class);
                   startActivity(intent);
               } else {
                   Toast.makeText(getActivity(),"Wrong User Name or Password", Toast.LENGTH_SHORT).show();
                   }
               }                                       }
       );
        return v;
    }
}
