package com.adwardwei.sample;

import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity {

    private File downloadFile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void test(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()){
                        //请求成功
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void test1(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void testPost(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    FormBody.Builder formBodyBuilder = new FormBody.Builder();
                    formBodyBuilder.add("name","kingkong");
                    formBodyBuilder.add("age","18");
                    formBodyBuilder.add("home","anhui");
                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .post(formBodyBuilder.build())
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void testPostJson(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                    String jsonStr = "{\"username\":\"lisi\",\"nickname\":\"李四\"}";
                    RequestBody requestBody = RequestBody.create(JSON,jsonStr);

                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void testPostFile(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    MediaType FILE = MediaType.parse("File/*");
                    File file =new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"test.txt");
                    RequestBody requestBody = RequestBody.create(FILE,file);

                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void testPostFileMultiPart(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    MediaType FILE = MediaType.parse("File/*");
                    File file =new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"test.txt");
                    RequestBody requestBody = RequestBody.create(FILE,file);

                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void testSetRequestHeader(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    MediaType FILE = MediaType.parse("File/*");
                    File file =new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"test.txt");
                    RequestBody requestBody = RequestBody.create(FILE,file);

                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .post(requestBody)
                            .header("User-Agent", "OkHttp Headers.java")
                            .addHeader("token", "myToken")
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void testDownloadFile(){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    MediaType FILE = MediaType.parse("File/*");
                    File file =new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"test.txt");
                    RequestBody requestBody = RequestBody.create(FILE,file);

                    Request request = new Request.Builder()
                            .url("www.baidu.com")
                            .post(requestBody)
                            .header("User-Agent", "OkHttp Headers.java")
                            .addHeader("token", "myToken")
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){

                                    InputStream is = response.body().byteStream();//从服务器得到输入流对象
                                    long sum = 0;
                                    File dir = new File(Environment.getExternalStorageDirectory()+File.separator+"download");
                                    if (!dir.exists()){
                                        dir.mkdirs();
                                    }
                                    downloadFile = new File(dir, "test.txt");//根据目录和文件名得到file对象
                                    FileOutputStream fos = new FileOutputStream(downloadFile);
                                    byte[] buf = new byte[1024*8];
                                    int len = 0;
                                    while ((len = is.read(buf)) != -1){
                                        fos.write(buf, 0, len);
                                    }
                                    fos.flush();
//                                    return file;
                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


}
