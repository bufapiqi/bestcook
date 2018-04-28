package com.netaq.mealordering;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
;

/**
 * Created by RABOOK on 2017/6/26.
 */

public class netWorkCon {

    private static final String TAG = "entity.netWorkCon";

    private static final String Basic_URL = "http://115.29.184.56:8090/api";// api

    private static final String Login_URL = Basic_URL + "/user/auth";  //可以组合成不同的URL
    private static final String Group_URL = Basic_URL + "/group";

    private Context mContext;

    public netWorkCon(Context context){
        mContext = context;
    }

    public BasicUser login(String username, String password) throws IOException {  //login方法
        if (!isNetWorkAvailableAndConnected()){
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username",username);
        jsonObject.addProperty("password",password);

        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        stringEntity.setContentType(HTTP.UTF_8);
        stringEntity.setContentType("application/json");

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(Login_URL);  //这里的login的URL需要改一下

        httpPost.setEntity(stringEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        int code = httpResponse.getStatusLine().getStatusCode();

        if (code != 200){
            return null;
        }

        HttpEntity httpEntity = httpResponse.getEntity();

        int type = -1;

        String jsonString = EntityUtils.toString(httpEntity);
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

    public List<Waitcode> getGroups() throws IOException{  //拿到排号的list
        List<Waitcode> waitcodes = null;

        HttpGet httpGet = new HttpGet(Group_URL);  //这里要把group的URL换掉

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

        return waitcodes;
    }
//
//    public List<Student> getStudents(int groupId) throws IOException{
//        List<Student> studentList = null;
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(Group_URL + "/" + groupId + "/students");
//        httpGet.addHeader("Authorization", "Basic " + getToken());
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//        int code = httpResponse.getStatusLine().getStatusCode();
//        if (code != 200){
//            return null;
//        }
//        Gson gson = new Gson();
//        String jsonString = EntityUtils.toString(httpResponse.getEntity());
//        Log.e(TAG, jsonString);
//        studentList = gson.fromJson(jsonString,
//                new TypeToken<List<Student>>(){}.getType());
//        return studentList;
//    }
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
