package android.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.example.annotation.MyClass;
import android.os.Bundle;

@MyClass()
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}