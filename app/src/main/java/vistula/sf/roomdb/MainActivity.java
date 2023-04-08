package vistula.sf.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.StringJoiner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vistula.sf.roomdb.retrofit.Retrofit2Client;
import vistula.sf.roomdb.retrofit.UserModel;

public class MainActivity extends AppCompatActivity {
    EditText name, gander;
    Button save;
    UserModel userModel;
    private ViewModal viewmodal;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewmodal = ViewModelProviders.of(this).get(ViewModal.class);
        tvTitle = findViewById(R.id.tv_titles);
        name = findViewById(R.id.name);
        gander = findViewById(R.id.gender);
        save = findViewById(R.id.save);

        //get Data from server
        Call<UserModel> call2 = Retrofit2Client.getInstance().getExploreService().getUserById("3");
        call2.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {


                userModel = response.body();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        //Save to room db
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel model = new UserModel(userModel.getUserId(), userModel.getId(), userModel.getTitle(), userModel.getBody());
                viewmodal.insert(model);
            }
        });

        // below line is use to get all the courses from view modal. Room dB
        viewmodal.getAllCourses().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> models) {


                StringBuilder PostItems = new StringBuilder();
                for (int i = 0; i < models.size(); i++) {
                    PostItems.append("Title :"+models.get(i).title);
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append("Body :" + models.get(i).body);
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append("Id :" + models.get(i).id);
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append("UserId :" + models.get(i).userId);
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append(System.getProperty("line.separator"));
                }
                String StrigItem = String.valueOf(PostItems);
                Log.d("TAG", "onChanged: "+StrigItem);


                tvTitle.setText(StrigItem);
            }
        });
    }
}

