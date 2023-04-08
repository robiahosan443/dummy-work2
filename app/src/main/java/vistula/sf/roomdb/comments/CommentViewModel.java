package vistula.sf.roomdb.comments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CommentViewModel extends ViewModel {
    CommentRepository commentRepository;


    MutableLiveData<List<CommentModel>> commentListMutableLiveData= new MutableLiveData<>() ;
    public LiveData<List<CommentModel>> commentList(){
        return commentListMutableLiveData;
    }


    public CommentViewModel() {
        this.commentRepository = new CommentRepository();
    }

    public MutableLiveData<List<CommentModel>> getAllComments(String id) {
        Log.d("TAG", "getAllComments: " + commentRepository.getListOfComments(id));
        commentListMutableLiveData  = commentRepository.getListOfComments(id);
      return  commentListMutableLiveData ;
    }

}
