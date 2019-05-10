package com.example.alumno.parcial1;

/**
 * Created by alumno on 09/05/2019.
 */

import android.os.Handler;
import android.os.Message;

public class MyThread extends Thread {
    Handler handler;
    String url;
    int imagenText;
    int position;
    public MyThread(Handler handler,String url,int position){
        this.handler = handler;
        this.url = url;
        this.imagenText = imagenText;
        this.position =position;
    }
    @Override
    public void run(){
        HttpManager http = new HttpManager();
        Message m = new Message();
        m.arg1 = imagenText;
        m.arg2 = position;

        String s = http.Conectar(url);
        m.obj = ParseXml.parseXml(s);
        //Log.d("parse", m.obj.toString());
        this.handler.sendMessage(m);
    }

}