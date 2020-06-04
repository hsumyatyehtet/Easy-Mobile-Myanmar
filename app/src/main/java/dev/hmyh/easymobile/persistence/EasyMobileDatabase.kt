package dev.hmyh.easymobile.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.hmyh.easymobile.data.vos.PostVO
import dev.hmyh.easymobile.persistence.daos.PostDao
import dev.hmyh.easymobile.utils.EASY_MOBILE_DB

@Database(entities = [PostVO::class], version = 1)
abstract class EasyMobileDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        private var instance: EasyMobileDatabase? = null

        fun getInstance(context: Context): EasyMobileDatabase{
            if (instance==null){
                instance = Room.databaseBuilder(context,EasyMobileDatabase::class.java, EASY_MOBILE_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val database = instance!!
            return database
        }
    }
}