package example.com.day04_shujuku.app;

import android.app.Application;

import example.com.day04_shujuku.utils.GreendaoUtiles;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreendaoUtiles.getmInstance().initGreenDao(this);
    }
}
