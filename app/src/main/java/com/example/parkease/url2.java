package com.example.parkease;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by user on 18-02-2018.
 */
class url2 extends AsyncTask<String,Void,String>
{
    Context mContext;
    TextView mTextView;
    Button btn;
    String code;
    //ListView listView;
    int id ;
    ImageView imageView;

    url2(Context context)
    {
        mContext=context;
       // this.btn=button;

    }
    Request request;
    @Override
    protected String doInBackground(String... strings) {
        String result = null;
        String url = strings[0];

        // code=strings[0];
        OkHttpClient okHttpClient = new OkHttpClient();
        request = new Request.Builder().url(url).build();
        Response response = null;
        try
        {
            response=okHttpClient.newCall(request).execute();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            result=response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        String output1[]=null;
        try {
            output1 = s.split("#111#");
            Toast.makeText(mContext, "you had a successful exit", Toast.LENGTH_SHORT).show();
            // mTextView.setText(output1[id]);

            //Picasso.with(mContext).load(output1[0].into(imageView);
        }catch (NullPointerException e)
        {
//            Toast.makeText(mContext, "Slow Internet", Toast.LENGTH_SHORT).show();
        }
    }
}