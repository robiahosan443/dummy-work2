package vistula.sf.roomdb.comments;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;


@Entity
public class CommentListModel {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @Ignore
    private List<CommentModel> commentModelList;

    public CommentListModel() {
    }

    public CommentListModel(List<CommentModel> commentModelList) {
        this.commentModelList = commentModelList;
    }



    public List<CommentModel> getCommentModelList() {
        return commentModelList;
    }

    public void setCommentModelList(List<CommentModel> commentModelList) {
        this.commentModelList = commentModelList;
    }
}
