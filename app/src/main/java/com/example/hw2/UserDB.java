package com.example.hw2;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1)
public abstract class UserDB extends RoomDatabase {
    private static UserDB instance;
    public static synchronized UserDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserDB.class,
                            "user_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDao usersDao();
}
