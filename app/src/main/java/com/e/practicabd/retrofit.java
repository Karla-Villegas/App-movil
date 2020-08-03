package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit extends AppCompatActivity {

    private TextView myJsonTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        myJsonTV = (TextView)findViewById(R.id.JsonTxt);
        getretrofitpost();

    }

    private void getretrofitpost(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<retrofitpost>> call = jsonPlaceHolderApi.getretrofitpost();

        call.enqueue(new Callback<List<retrofitpost>>() {
            @Override
            public void onResponse(Call<List<retrofitpost>> call, Response<List<retrofitpost>> response) {

                if(!response.isSuccessful()){
                    myJsonTV.setText("codigo: "+response.code());
                    return;
                }

                List<retrofitpost> postRetrofit = response.body();

                for(retrofitpost retroPost: postRetrofit){

                    String content = "";
                    content += "userId:"+ retroPost.getUserId() + "\n";
                    content += "id:"+ retroPost.getId() + "\n";
                    content += "title:"+ retroPost.getTitle() + "\n";
                    content += "body:"+ retroPost.getBody() + "\n";
                    myJsonTV.append(content);




                }

            }

            @Override
            public void onFailure(Call<List<retrofitpost>> call, Throwable t) {

                myJsonTV.setText(t.getMessage());

            }
        });
    }
}
