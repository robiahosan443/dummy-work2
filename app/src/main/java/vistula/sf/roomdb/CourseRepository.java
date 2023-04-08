package vistula.sf.roomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import vistula.sf.roomdb.comments.CommentListModel;
import vistula.sf.roomdb.comments.CommentModel;
import vistula.sf.roomdb.retrofit.UserModel;

public class CourseRepository {
    private UserDao dao;
    private LiveData<List<UserModel>> allCourses;

    public CourseRepository(Application application) {
        CotesDatabase database = CotesDatabase.getInstance(application);
        dao = database.dao();
    }

    public LiveData<List<UserModel>> getAllCourses() {
        allCourses = dao.getAll();
        return allCourses;
    }
    public void insert(UserModel model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    public void insertList(CommentListModel commentList) {
        new InsertListAsyncTask(dao).execute(commentList);
    }

    private static class InsertCourseAsyncTask extends AsyncTask<UserModel, Void, Void> {
        private UserDao dao;

        private InsertCourseAsyncTask(UserDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(UserModel... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }
    private static class InsertListAsyncTask extends AsyncTask<CommentListModel, Void, Void> {

        private UserDao dao;

        private InsertListAsyncTask(UserDao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(CommentListModel... lists) {
            dao.insertList(lists[0]);
            return null;
        }
    }
}
