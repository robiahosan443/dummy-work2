package vistula.sf.roomdb.comments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import vistula.sf.roomdb.R;
import vistula.sf.roomdb.ViewModal;

public class CommentsActivity extends AppCompatActivity {
    List<CommentModel> commentsLis = new ArrayList<>();
    private static final String TAG = "CommentsActivity";


    TextView tvEmail;
    EditText editText;
    Button btn, btnSaveRoom;
    CommentViewModel commentViewModel;
    ViewModal viewModal;
    List<CommentListModel> commentModelList;
    List<CommentModel> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        tvEmail = findViewById(R.id.tv_email);
        editText = findViewById(R.id.gender);
        btn = findViewById(R.id.save);
        btnSaveRoom = findViewById(R.id.buttonRoom);
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel.class);
        viewModal = ViewModelProviders.of(this).get(ViewModal.class);
        commentList=new ArrayList<>();
        commentModelList=new ArrayList<>();
        getComments();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commentViewModel.getAllComments(editText.getText().toString());
                getComments();
            }
        });
        btnSaveRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentListModel commentListModel= new CommentListModel( commentList);
                viewModal.insertList(commentListModel);
            }
        });
    }


    private void getComments() {
        commentViewModel.commentList().observe(CommentsActivity.this, new Observer<List<CommentModel>>() {
            @Override
            public void onChanged(List<CommentModel> commentModels) {
                commentList=commentModels;

                StringBuilder PostItems = new StringBuilder();
                for (int i = 0; i < commentModels.size(); i++) {
                    PostItems.append("UserId :" + commentModels.get(i).getPostId());
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append("Id :" + commentModels.get(i).getId());
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append("Title :" + commentModels.get(i).getEmail());
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append("Body :" + commentModels.get(i).getBody());
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append(System.getProperty("line.separator"));
                    PostItems.append(System.getProperty("line.separator"));
                }
                String StrigItem = String.valueOf(PostItems);
                Log.d("TAG", "onChanged: " + StrigItem);
                tvEmail.setText(StrigItem);
            }
        });
    }
}