package com.example.prajakta.orphanage_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by PRAJAKTA on 21-02-2018.
 */

public class Backendconnectivity extends AsyncTask<String,Void,String> {
    public AsyncResponse getdata = null;
    Context context;
    AlertDialog alertDialog;
    Backendconnectivity(Context ctx){
        context = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

       String login_url = "http://192.168.1.5/login.php";
        String signup_url = "http://192.168.1.5/signup.php";
        String update_url = "http://192.168.1.5/update.php";
         String single_orphanage_page_url = "http://192.168.1.5/single_orphanage_page.php";


        if (type.equals("login")){
            try {
                String email = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);
                OutputStream outputStream = httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpurlconnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpurlconnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (type.equals("signup")){
            try {
                String name = params[1];
                String email = params[2];
                String password = params[3];
                String category = params[4];
                String o_name = params[5];
                String o_address = params[6];
                String o_mobile_no = "";
                String o_requirements = "";
                String o_description = "";

                URL url = new URL(signup_url);
                HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);
                OutputStream outputStream = httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")
                        +"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")
                        +"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")
                        +"&"
                        +URLEncoder.encode("category","UTF-8")+"="+URLEncoder.encode(category,"UTF-8")
                        +"&"
                        +URLEncoder.encode("o_name","UTF-8")+"="+URLEncoder.encode(o_name,"UTF-8")
                        +"&"
                        +URLEncoder.encode("o_address","UTF-8")+"="+URLEncoder.encode(o_address,"UTF-8")
                        +"&"
                        +URLEncoder.encode("mobile_no","UTF-8")+"="+URLEncoder.encode(o_mobile_no,"UTF-8")
                        +"&"
                        +URLEncoder.encode("requirements","UTF-8")+"="+URLEncoder.encode(o_requirements,"UTF-8")
                        +"&"
                        +URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(o_description,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpurlconnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpurlconnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("update")){
            try {
                String name = params[1];
                String address = params[3];
                String mobile_number = params[4];
                String email = params[2];
                String requirements = params[5];
                String description = params[6];
                URL url = new URL(update_url);
                HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);
                OutputStream outputStream = httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")
                        +"&"
                        +URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")
                        +"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")
                        +"&"
                        +URLEncoder.encode("mobile_no","UTF-8")+"="+URLEncoder.encode(mobile_number,"UTF-8")
                        +"&"
                        +URLEncoder.encode("requirements","UTF-8")+"="+URLEncoder.encode(requirements,"UTF-8")
                        +"&"
                        +URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpurlconnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpurlconnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("single_orphanage_page")){
            try {
                String name = params[1];


                URL url = new URL(single_orphanage_page_url);
                HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);
                OutputStream outputStream = httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpurlconnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpurlconnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if(getdata!=null){
        getdata.processFinish(result);}
        alertDialog.setMessage(result);
        alertDialog.show();

        if (result.contains("login success and its Not a Orphanage")){
            Intent intent_login_N_O = new Intent("com.example.prajakta.orphanage_app.non_orphanage_page");
            context.startActivity(intent_login_N_O);
        }
        else if (result.contains("login success and its Orphanage")){
            Intent intent_login_O = new Intent("com.example.prajakta.orphanage_app.orphanage_page");
            context.startActivity(intent_login_O);
        }
        else if (result.contains(" non Orphanage Insert success")){
            Intent intent_login = new Intent("com.example.prajakta.orphanage_app.non_orphanage_page");
            context.startActivity(intent_login);
        }
        else if (result.contains("Orphanage Insert success")){
            Intent intent_login = new Intent("com.example.prajakta.orphanage_app.orphanage_page");
            context.startActivity(intent_login);
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
