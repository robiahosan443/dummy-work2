package vistula.sf.roomdb.comments;

import android.util.Log;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class CommentsListTypeConverter {
    @TypeConverters
   public String fromString(List<CommentModel> commentsList){


        return new Gson().fromJson((JsonElement) commentsList, new TypeToken<List<CommentModel>>() {}.getType());
    }
    @TypeConverter
    public static String frommArrayList( List<CommentModel> value) {

        return new Gson().toJson(value);

    }
}
