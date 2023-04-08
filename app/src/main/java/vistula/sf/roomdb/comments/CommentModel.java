package vistula.sf.roomdb.comments;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = CommentListModel.class,
                parentColumns = "id",
                childColumns = "big_object_fk"
        )})
public class CommentModel {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "postId")
    public String postId;
    @ColumnInfo(name = "id")
    public String id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "body")
    public String body;
    @ColumnInfo(name = "big_object_fk")
    private int bigObjectIdFk;

    public CommentModel() {
    }

    public CommentModel(int uid, String postId, String id, String name, String email, String body, int bigObjectIdFk) {
        this.uid = uid;
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
        this.bigObjectIdFk = bigObjectIdFk;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getBigObjectIdFk() {
        return bigObjectIdFk;
    }

    public void setBigObjectIdFk(int bigObjectIdFk) {
        this.bigObjectIdFk = bigObjectIdFk;
    }
}
