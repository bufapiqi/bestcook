package com.netaq.mealordering.fragments;


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

import com.google.gson.Gson;
import com.netaq.mealordering.BasicUser;
import com.netaq.mealordering.R;
import com.netaq.mealordering.netWorkCon;

import java.io.IOException;

/**
 * Created by RABOOK on 2018/4/27.
 */

public class UserUpdateInfoFragment extends android.support.v4.app.Fragment{

    View view;
    TextView t1,t2,t3;
    EditText e1,e2,e3;
    Button b1,b4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        view = inflater.inflate(R.layout.userupdateinfo_layout,container,false); //加载personal  layout

        t1 = view.findViewById(R.id.usernamelabel);
        t2 = view.findViewById(R.id.shouhuolabel);
        t3 = view.findViewById(R.id.mimalabel);

        //这里获得user信息
        Intent intent = getActivity().getIntent();
        final Bundle bundle = intent.getExtras();
        String username = bundle.getString("username");
        String shouhuob = bundle.getString("address");
        String mimab = bundle.getString("password");
        //这里获得user信息

        e1 = view.findViewById(R.id.updateEdit);
        e2 = view.findViewById(R.id.updateshouhuoEdit);
        e3 = view.findViewById(R.id.updatemimaEdit);

        e1.setText(username);
        e2.setText(shouhuob);
        e3.setText(mimab);


        b1 = view.findViewById(R.id.querenxiugai);
        b4 = view.findViewById(R.id.tuichudenglu);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里写上修改的代码
                final String shouhuo = e2.getText().toString();
                final String mima = e3.getText().toString();
                String username = bundle.getString("username");
                String userid = bundle.getString("userid");
                String photo = bundle.getString("photoLink");

                BasicUser user = new BasicUser();
                user.setAccount(username);
                user.setId(Integer.parseInt(userid));
                user.setPassword(mima);
                user.setAddess(shouhuo);
                user.setPhotoLink(photo);

                Gson g = new Gson();
                String update = g.toJson(user);

                //判断用户名和密码是否为空
                if(TextUtils.isEmpty(shouhuo.trim())||TextUtils.isEmpty(mima.trim())){
                    Toast.makeText(getActivity(),"收货地址或密码不能为空！请重新输入",Toast.LENGTH_SHORT).show();
                }else {
                    new UpdateUserInfoTask().execute(update);
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里退出登录


            }
        });



        return view;
    }


    private class UpdateUserInfoTask extends AsyncTask<String,Void,Integer> {


        @Override
        protected Integer doInBackground(String... strings) {

            netWorkCon net = new netWorkCon(getActivity());

            int returnCode = 0;

            try{
                returnCode = net.UpdateUser(strings[0]);

            }catch (IOException e){
                e.printStackTrace();
            }finally {

            }

            return new Integer(returnCode);
        }

        @Override
        protected void onPostExecute(Integer returnCode) {
//            super.onPostExecute(aVoid);

            Intent intent = getActivity().getIntent();

            if(returnCode==1){
                Toast.makeText(getActivity(),"修改成功！",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else{
                Toast.makeText(getActivity(),"修改失败！",Toast.LENGTH_SHORT).show();
            }
//            if(user.getType().equals("teacher")){
//                //这里写startActivity
//            }else{
//
//            }
        }
    }

}
