package com.netaq.mealordering.fragments;

/**
 * Created by RABOOK on 2018/4/28.
 */

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Toast;

import com.netaq.mealordering.BasicUser;
import com.netaq.mealordering.R;
import com.netaq.mealordering.activity.MainActivity;
import com.netaq.mealordering.netWorkCon;

import java.io.IOError;
import java.io.IOException;

public class LoginFragment extends android.support.v4.app.Fragment{

    View view;
    EditText usernameEdit,passwordEdit;

    Button regButton,loginButton;

    private String un;
    private String pa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.login_layout,container,false); //加载personal  layout

        usernameEdit = view.findViewById(R.id.usernameEdit);
        passwordEdit = view.findViewById(R.id.passwordEdit);

        regButton = view.findViewById(R.id.regesterButton);
        loginButton = view.findViewById(R.id.denglubuttonn);

        un = usernameEdit.getText().toString();
        pa = passwordEdit.getText().toString();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = usernameEdit.getText().toString();
                final String pass = passwordEdit.getText().toString();

                //判断用户名和密码是否为空
                if(TextUtils.isEmpty(name.trim())||TextUtils.isEmpty(pass.trim())){
                    Toast.makeText(getActivity(),"用户名或密码不能为空！请重新输入",Toast.LENGTH_SHORT).show();
                }else {

                    Log.i("jijijijsdsdsadsa",name);
                    new LoginTask().execute(name,pass);

                }

            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = usernameEdit.getText().toString();
                final String pass = passwordEdit.getText().toString();

                Log.i("这里能读到吗",name);
                Log.i("这里能读到吗ssss",pass);

                //判断用户名和密码是否为空
                if(TextUtils.isEmpty(name.trim())||TextUtils.isEmpty(pass.trim())){
                    Toast.makeText(getActivity(),"用户名或密码不能为空！请重新输入",Toast.LENGTH_SHORT).show();
                }else {

                    Log.i("jijijijsdsdsadsa",name);
                    new RegisterTask().execute(name,pass);

                }
            }
        });

        return view;
    }

    private class RegisterTask extends  AsyncTask<String,Void,BasicUser>{

        @Override
        protected BasicUser doInBackground(String... strings) {
            netWorkCon net = new netWorkCon(getActivity());
            BasicUser user = null;
            try{
                user = net.register(strings[0],strings[1]);
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }
            return user;
        }

        @Override
        protected void onPostExecute(BasicUser basicUser) {
//            super.onPostExecute(basicUser);
            if(basicUser == null){
                Toast.makeText(getActivity(),"注册失败！已经有相同的账户",Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(getActivity(),"注册成功！已经自动登录",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra("username",basicUser.getAccount());
            intent.putExtra("userid",basicUser.getId());
            intent.putExtra("password",basicUser.getPassword());
            intent.putExtra("photoLink",basicUser.getPhotoLink());
            intent.putExtra("address",basicUser.getAddess());
            startActivity(intent);
        }
    }

    private class LoginTask extends AsyncTask<String,Void,BasicUser>{


        @Override
        protected BasicUser doInBackground(String... strings) {

            netWorkCon net = new netWorkCon(getActivity());

            BasicUser user = null;

            try{
                user = net.login(strings[0],strings[1]);
            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return user;
        }

        @Override
        protected void onPostExecute(BasicUser user) {
//            super.onPostExecute(aVoid);
            if(user == null){
                Toast.makeText(getActivity(),"登陆失败！",Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(getActivity(),"登录成功！",Toast.LENGTH_SHORT).show();

//            userMemoryStore.setUserName(getApplicationContext(),username.getText().toString());
//            userMemoryStore.setPassword(getApplicationContext(),password.getText().toString());

//            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            Intent intent = new Intent(getActivity(), MainActivity.class);
//                    getActivity().newIntent(loginActivity.this,user.getType());

//            Log.i(TAG,user.getType());

            Log.i("userid有没有",""+user.getId());

            intent.putExtra("username",user.getAccount());
            intent.putExtra("userid",user.getId());
            intent.putExtra("password",user.getPassword());
            intent.putExtra("photoLink",user.getPhotoLink());
            intent.putExtra("address",user.getAddess());

            startActivity(intent);

//            if(user.getType().equals("teacher")){
//                //这里写startActivity
//            }else{
//
//            }
        }
    }

}
