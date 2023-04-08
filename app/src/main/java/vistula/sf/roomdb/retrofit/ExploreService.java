package vistula.sf.roomdb.retrofit;

import androidx.lifecycle.LiveData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vistula.sf.roomdb.comments.CommentModel;

public interface ExploreService {
    @GET("posts/")
    Call<List<UserModel>> getUser();

    @GET("posts/{id}")
    Call<UserModel> getUserById(@Path("id") String id);

    @GET("comments")
    Call<List<CommentModel>> getCommentById(
            @Query("postId") String id);
}
