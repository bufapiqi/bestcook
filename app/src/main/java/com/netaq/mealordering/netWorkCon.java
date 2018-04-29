package com.netaq.mealordering;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
;

/**
 * Created by RABOOK on 2017/6/26.
 */

public class netWorkCon {

    private static final String TAG = "entity.netWorkCon";

    private static final String Basic_URL = "http://192.168.43.171:8080";// api

    private static final String Login_URL = Basic_URL + "/login";  //可以组合成不同的URL
    private static final String Register_URL = Basic_URL + "/register";
    private static final String SetInfo_URL = Basic_URL + "/setSelfInfo";
    private static final String CheckCode_URL = Basic_URL + "/checkCode";
    private static final String getCode_URL = Basic_URL + "/getCode";
    private static final String Reserve_URL = Basic_URL + "/reserve";
    private static final String checkReserve_URL = Basic_URL + "/checkReserve";
    private static final String outFood_URL = Basic_URL + "/outfood";
    private static final String checkOutfood_URL = Basic_URL + "/checkOutfood";

    private Context mContext;

    public netWorkCon(Context context){
        mContext = context;
    }

    public BasicUser login(String username, String password) throws IOException {  //login方法
        if (!isNetWorkAvailableAndConnected()){
            return null;
        }
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("account",username);
//        jsonObject.addProperty("passwd",password);
        NameValuePair account = new BasicNameValuePair("account",username);
        NameValuePair passwd = new BasicNameValuePair("passwd",password);
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(account);
        pairs.add(passwd);

        Log.i("username",username);
        Log.i("password",password);
//        Log.i("input?>",jsonObject.toString());

//        StringEntity stringEntity = new StringEntity(jsonObject.toString());
//        stringEntity.setContentType(HTTP.UTF_8);
//        stringEntity.setContentType("application/json");

        HttpEntity requestEntity = new UrlEncodedFormEntity(pairs);

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(Login_URL);

        httpPost.setEntity(requestEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        int code = httpResponse.getStatusLine().getStatusCode();

        Log.i("ceshi","return code : "+ code);

        if (code != 200){
            return null;
        }

        HttpEntity httpEntity = httpResponse.getEntity();

        int type = -1;


        String jsonString = "";
        jsonString = EntityUtils.toString(httpEntity,HTTP.UTF_8);

        Log.d("DDDD",jsonString);

        try {
            JSONObject object = new JSONObject(jsonString);
        }catch (JSONException je){
            je.printStackTrace();
            return null;
        }

        BasicUser user = null;
        Gson gson = new Gson();
        user = gson.fromJson(jsonString,BasicUser.class);

        Log.i(TAG,user.toString());
        return user;

    }


    public BasicUser register(String username, String password) throws IOException{
        if (!isNetWorkAvailableAndConnected()){
            return null;
        }
        NameValuePair account = new BasicNameValuePair("account",username);
        NameValuePair passwd = new BasicNameValuePair("passwd",password);
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(account);
        pairs.add(passwd);
        HttpEntity requestEntity = new UrlEncodedFormEntity(pairs);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(Register_URL);
        httpPost.setEntity(requestEntity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        int code = httpResponse.getStatusLine().getStatusCode();
        Log.i("ceshi","return code : "+ code);
        if (code != 200){
            return null;
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        int type = -1;
        String jsonString = "";
        jsonString = EntityUtils.toString(httpEntity,HTTP.UTF_8);
        try {
            JSONObject object = new JSONObject(jsonString);
        }catch (JSONException je){
            je.printStackTrace();
            return null;
        }
        BasicUser user = null;
        Gson gson = new Gson();
        user = gson.fromJson(jsonString,BasicUser.class);
        Log.i(TAG,user.toString());
        return user;
    }

    public List<Waitcode> checkCode(int userid) throws IOException{  //拿到排号的list  还没测试过
        List<Waitcode> waitcodes = null;

        HttpGet httpGet = new HttpGet(CheckCode_URL+"?userid="+userid);

//        httpGet.addHeader("Authorization", "Basic " + getToken());  这个token认证不要了

        HttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return null;
        }

        Gson gson = new Gson();

        String a = EntityUtils.toString(httpResponse.getEntity());
        Log.e(TAG,a);

        waitcodes = gson.fromJson(a,
                new TypeToken<List<Waitcode>>(){}.getType());

        for(Waitcode ww:waitcodes){
            Log.i("waitcode",ww.getName()+"  "+ww.getTime());
        }

        return waitcodes;
    }

    public List<OutFoodVO> checkOutfood(int userid) throws IOException{
        List<OutFoodVO> outs = null;

        HttpGet httpGet = new HttpGet(checkOutfood_URL+"?userid="+userid);

        HttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return null;
        }

        Gson gson = new Gson();

        String a = EntityUtils.toString(httpResponse.getEntity());
        Log.e(TAG,a);

        outs = gson.fromJson(a,
                new TypeToken<List<OutFoodVO>>(){}.getType());

        return outs;
    }

    public List<Reserve> checkReserve(int userid) throws IOException{
        List<Reserve> reserves = null;

        HttpGet httpGet = new HttpGet(checkReserve_URL+"?userid="+userid);

        HttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return null;
        }

        Gson gson = new Gson();

        String a = EntityUtils.toString(httpResponse.getEntity());
        Log.e(TAG,a);

        reserves = gson.fromJson(a,
                new TypeToken<List<Reserve>>(){}.getType());

        return reserves;
    }

    public boolean reserve(String time,int mans,String name,String phone,String special,int userid)throws IOException{

        String URL = Reserve_URL+"?time="+URLEncoder.encode(time,"UTF-8")+"&mans="+mans+"&name="+name+"&phone="+phone+"&special="+special+"&userid="+userid;
        HttpGet httpGet = new HttpGet(URL);

        HttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return false;
        }

        Gson gson = new Gson();

        String a = EntityUtils.toString(httpResponse.getEntity());

        return Boolean.getBoolean(a);
    }

    public String getCode(String time,int mans,String name,String phone,int userid) throws IOException{  //排号的url

        HttpGet httpGet = new HttpGet(getCode_URL+"?time="+time+"&mans="+mans+"&name="+name+"&phone="+phone+"&userid="+userid);

        HttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return null;
        }

        Gson gson = new Gson();

        String a = EntityUtils.toString(httpResponse.getEntity());

        return a;
    }

    public int OutFood(String outFood) throws  IOException{

        StringEntity stringEntity = new StringEntity(outFood);
        stringEntity.setContentType(HTTP.UTF_8);
        stringEntity.setContentType("application/json");

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(outFood_URL);

        httpPost.setEntity(stringEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return -1;
        }

        HttpEntity httpEntity = httpResponse.getEntity();

        int type = -1;

        String jsonString = EntityUtils.toString(httpEntity);

        return Integer.parseInt(jsonString);
    }

    public int UpdateUser(String userInfo) throws IOException{

        StringEntity stringEntity = new StringEntity(userInfo);
        stringEntity.setContentType(HTTP.UTF_8);
        stringEntity.setContentType("application/json");

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(SetInfo_URL);

        httpPost.setEntity(stringEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return -1;
        }

        HttpEntity httpEntity = httpResponse.getEntity();

        int type = -1;

        String jsonString = EntityUtils.toString(httpEntity);

        return Integer.parseInt(jsonString);
    }
//
//    public List<Test> getTests(int courseId, String type) throws IOException{
//        List<Test> testList = null;
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(Basic_URL + "/course/" + courseId + "/" + type);
//        httpGet.addHeader("Authorization", "Basic " + getToken());
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//        int code = httpResponse.getStatusLine().getStatusCode();
//        if (code != 200){
//            return null;
//        }
//        Gson gson = new Gson();
//        String jsonString = EntityUtils.toString(httpResponse.getEntity());
//        Log.d(TAG, jsonString);
//        testList = gson.fromJson(jsonString, new TypeToken<List<Test>>(){}.getType());
//
//        return testList;
//    }
//
//    public List<QuestionT> getQuestionT(int courseId) throws IOException{
//        String urlString = Basic_URL + "/assignment/" + 38 + "/score";
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(urlString);
//        httpGet.addHeader("Authorization", "Basic " + getToken());
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//        int code = httpResponse.getStatusLine().getStatusCode();
//        if (code != 200){
//            return null;
//        }
//
//        Gson gson = new Gson();
//        String jsonString = EntityUtils.toString(httpResponse.getEntity());
//        if (jsonString == null){
//            return null;
//        }
//        Log.d(TAG, jsonString);
//        ScoreList scoreList = gson.fromJson(jsonString, ScoreList.class);
//        Log.d(TAG, "scoreList: " + scoreList.getQuestions().size());
//        return scoreList.getQuestions();
//    }
//
//    public QuestionContent getQuestionContent(int assignmentId, int questionId, int studentId)
//            throws IOException {
//        String urlString = Basic_URL + "/assignment/" + assignmentId + "/student/" + 227 +
//                "/question/" + questionId;
//
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(urlString);
//        httpGet.addHeader("Authorization", "Basic " + getToken());
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//        int code = httpResponse.getStatusLine().getStatusCode();
//        if (code != 200){
//            return null;
//        }
//        Gson gson = new Gson();
//        String jsonString = EntityUtils.toString(httpResponse.getEntity());
//        if (jsonString == null){
//            return null;
//        }
//        QuestionContent result = gson.fromJson(jsonString, QuestionContent.class);
//        return result;
//    }
//
//    public Analysis getAnalysis(int assignmentId, int studentId) throws IOException{
//        String urlString = Basic_URL + "/assignment/" + assignmentId + "/student/" + studentId +
//                "/analysis";
//
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(urlString);
//        httpGet.addHeader("Authorization", "Basic " + getToken());
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//        int code = httpResponse.getStatusLine().getStatusCode();
//        if (code != 200){
//            return null;
//        }
//
//        Gson gson = new Gson();
//        String jsonString = EntityUtils.toString(httpResponse.getEntity());
//        if (jsonString == null){
//            return null;
//        }
//        Analysis analysis = gson.fromJson(jsonString, Analysis.class);
//        Log.d(TAG, "compile_succeed: " + (analysis.getQuestionResults().get(0).getTestResult().getCompileSucceeded() == true));
//        return analysis;
//    }



    private boolean isNetWorkAvailableAndConnected(){
        ConnectivityManager cm = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnected()){
            return true;
        }
        return false;
    }


//    private String getToken(){
//        String username = userMemoryStore.getUserName(mContext);
//        String password = userMemoryStore.getPassword(mContext);
//
//        String tokenString = username + ":" + password;
//        String token = Base64.encodeToString(tokenString.getBytes(), Base64.NO_WRAP);
//        return token;
//    }

}
