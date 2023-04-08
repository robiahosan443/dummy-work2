package vistula.sf.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import vistula.sf.roomdb.comments.CommentListModel;
import vistula.sf.roomdb.comments.CommentModel;
import vistula.sf.roomdb.retrofit.UserModel;

@Dao
public interface UserDao {
    @Query("SELECT * FROM usermodel")
    LiveData<List<UserModel>> getAll();


    @Insert
    void insert(UserModel users);

    @Delete
    void delete(UserModel user);

    @Insert
    void insertList(CommentListModel lists);
}