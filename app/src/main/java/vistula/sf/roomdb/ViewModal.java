package vistula.sf.roomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import vistula.sf.roomdb.comments.CommentListModel;
import vistula.sf.roomdb.comments.CommentModel;
import vistula.sf.roomdb.retrofit.UserModel;

public class ViewModal extends AndroidViewModel {
    private CourseRepository repository;
    private LiveData<List<UserModel>> allCourses;

    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new CourseRepository(application);

    }
    public void insert(UserModel model) {
        repository.insert(model);
    }

    public LiveData<List<UserModel>> getAllCourses() {
        allCourses = repository.getAllCourses();
        return allCourses;
    }
    public void insertList(CommentListModel commentList){
        repository.insertList(commentList);
    }
}
