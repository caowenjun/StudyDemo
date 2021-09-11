package android.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.example.annotation.MyClass;
import android.example.myapplication.ButterKnife.ButterKnifeUtils;
import android.example.myapplication.ButterKnife.Click;
import android.example.myapplication.ButterKnife.LongClick;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

@MyClass()
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnifeUtils.inject(this);
    }

    @Click({R.id.btn1,R.id.btn2})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                Toast.makeText(this,"点击了btn1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this,"点击了btn2",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @LongClick({R.id.btn1,R.id.btn2})
    public boolean longClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                Toast.makeText(this,"长点击了btn1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this,"长点击了btn2",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}