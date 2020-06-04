package dev.hmyh.easymobile.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.easymobile.data.vos.PostVO
import io.reactivex.Completable

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllPosts(posts: List<PostVO>): Completable

    @Query("SELECT * FROM post")
    fun getAllPosts(): LiveData<List<PostVO>>

    @Query("select count(*) from post")
    fun getPostCount(): Int
}