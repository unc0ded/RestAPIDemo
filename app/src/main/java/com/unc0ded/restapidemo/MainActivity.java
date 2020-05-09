package com.unc0ded.restapidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.unc0ded.restapidemo.models.RandomUser;
import com.unc0ded.restapidemo.models.Result;
import com.unc0ded.restapidemo.retrofit.RetrofitAPIInterface;
import com.unc0ded.restapidemo.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Result> userList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.user_rv);

        RetrofitAPIInterface apiInterface=RetrofitClient.getClient();

        Map<String, String> map= new HashMap<>();
        map.put("results","10");
        Call<RandomUser> call = apiInterface.getUser(map);

        call.enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, Response<RandomUser> response) {
                RandomUser object = response.body();
                userList=(ArrayList<Result>)object.getResults();
                recyclerView.setAdapter(new UserAdapter(userList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {
                Log.e("ResponseError",t.getMessage());
            }
        });
    }
}
