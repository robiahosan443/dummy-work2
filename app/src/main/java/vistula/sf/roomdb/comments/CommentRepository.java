package vistula.sf.roomdb.comments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vistula.sf.roomdb.retrofit.ExploreService;
import vistula.sf.roomdb.retrofit.Retrofit2Client;

public class CommentRepository {
    ExploreService exploreService;



    public MutableLiveData<List<CommentModel>> getListOfComments(String id) {
        final MutableLiveData<List<CommentModel>> listMutableLiveData = new MutableLiveData<>();
        Call<List<CommentModel>> call2 = Retrofit2Client.getInstance().getExploreService().getCommentById(id);
        call2.enqueue(new Callback<List<CommentModel>>() {


            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                Log.d("CommentRepository", "getAllComments: "+response.body().get(1).getEmail());
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Log.d("TAG", "onResponse: " + t.getMessage());
            }
        });
        return listMutableLiveData;
    }
}
