package dev.hmyh.easymobile.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post")
class PostVO {

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int = 0

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String = ""

    @SerializedName("content")
    @ColumnInfo(name = "content")
    var content: String=""

}