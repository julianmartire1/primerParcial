package com.example.alumno.parcial1;

import android.util.Log;
import android.view.View;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyListener  implements View.OnClickListener {
    MainActivity mainActivity;
    public  MyListener(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {

        Log.d("Click","algo");
    }
}
