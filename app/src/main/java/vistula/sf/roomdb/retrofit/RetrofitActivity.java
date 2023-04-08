package vistula.sf.roomdb.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vistula.sf.roomdb.R;

public class RetrofitActivity extends AppCompatActivity {
    List<UserModel> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        userList= new ArrayList<>();

        Call<List<UserModel>> call=Retrofit2Client.getInstance().getExploreService().getUser();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userList=response.body();


                for (int i=0; i<=userList.size(); i++){
//                    Log.d("TAG", "onResponse: "+userList.get(i).id);
//                    Log.d("TAG", "onResponse: "+userList.get(i).userId);
//                    Log.d("TAG", "onResponse: "+userList.get(i).title);
//                    Log.d("TAG", "onResponse: "+userList.get(i).body);
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });


    }
}