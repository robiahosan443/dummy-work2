package vistula.sf.roomdb.retrofit;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "userId")
    public String userId;

    @ColumnInfo(name = "id")
    public String id;
    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "body")
    public String body;

    public UserModel() {
    }

    public UserModel(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
