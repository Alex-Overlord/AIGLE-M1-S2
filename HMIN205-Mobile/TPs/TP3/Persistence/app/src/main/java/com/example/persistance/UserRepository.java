package com.example.persistance;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class UserRepository {

    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;

    UserRepository(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDAO = db.userDAO();
        allUsers = userDAO.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user) {
        new insertAsyncTask(userDAO).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDAO asyncTaskDAO;

        insertAsyncTask(UserDAO userDAO) {
            asyncTaskDAO = userDAO;
        }

        @Override
        protected  Void doInBackground(final User... params) {
            asyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
