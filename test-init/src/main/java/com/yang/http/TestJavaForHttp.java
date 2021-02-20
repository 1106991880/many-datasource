package com.yang.http;

import java.io.*;
import java.net.*;

public class TestJavaForHttp {

    public static void main(String args[]) {
        //String cityName = "北京";
        //encode需要抛异常
        //String cityNameStr = URLEncoder.encode(cityName, "UTF-8");
        String appId = "101918631";
        String redirectUrl = "http://127.0.0.1:9090/auth/user/login/callBackHandler";
        String state = "1";
        String webUrl = "https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=" + appId + "&redirect_uri=" + redirectUrl + "";
        System.out.println("webUrl==" + webUrl);
        //get请求
        httpUrlConnectionGet(webUrl);
        //post请求
        httpURLConnectionPOST();

    }

    /**
     * get请求
     */
    public static void httpUrlConnectionGet(String webUrl) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            //需要抛异常
            URL url = new URL(webUrl);
            //openConnection需要抛异常
            URLConnection urlConnection = url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 存储响应的返回结果
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            bufferedReader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("========================================================");
        //System.out.printf(stringBuffer.toString());
    }

    /**
     * post请求
     */
    public static void httpURLConnectionPOST() {
        try {
            String cityWeatherUrl = "https://way.jd.com/he/freeweather";
            URL url = new URL(cityWeatherUrl);
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            // 此时httpURLConnection只是为一个连接对象,待连接中
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            httpURLConnection.setDoOutput(true);
            // 设置连接输入流为true
            httpURLConnection.setDoInput(true);
            // 设置请求方式为post
            httpURLConnection.setRequestMethod("POST");
            // post请求缓存设为false
            httpURLConnection.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            httpURLConnection.setInstanceFollowRedirects(true);
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            // ;charset=utf-8
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // 建立连接 (请求未开始,直到httpURLConnection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            httpURLConnection.connect();
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            String city = "city=" + URLEncoder.encode("北京", "utf-8");
            String appkey = "&appkey=" + URLEncoder.encode("yourkey", "utf-8");
            // 格式 param = aaa=111&bbb=222&ccc=333&ddd=444
            String params = city + appkey;
            // 将参数输出到连接
            dataOutputStream.writeBytes(params);
            // 输出完成后刷新并关闭流
            dataOutputStream.flush();
            // 关闭流,切记!
            dataOutputStream.close();
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String line;
            // 用来存储响应数据
            StringBuilder stringBuilder = new StringBuilder();
            // 循环读取流,若不到结尾处
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                //stringBuilder.append(line).append(System.getProperty("line.separator"));
            }
            // 关闭流
            bufferedReader.close();
            // 销毁连接
            httpURLConnection.disconnect();
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

