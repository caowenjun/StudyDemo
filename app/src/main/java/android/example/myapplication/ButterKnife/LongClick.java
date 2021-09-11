package android.example.myapplication.ButterKnife;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@EventType(ProxyClass = View.OnLongClickListener.class,invokeMethodName = "setOnLongClickListener")
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LongClick {
    int [] value();
}
