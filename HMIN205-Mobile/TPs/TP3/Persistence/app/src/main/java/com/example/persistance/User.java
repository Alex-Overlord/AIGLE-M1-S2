package com.example.persistance;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "last_name")
    private String lastName;

    public User(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return getLastName();
    }
}
