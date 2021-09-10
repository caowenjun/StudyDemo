package android.example.annotation_compile;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes({"android.example.annotation.MyClass"})
public class TestProcessor extends AbstractProcessor {

    /**
     * javac 调用此方法
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //写什么代码就干什么事
        //process javac编译时的一个回调
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE,"javac 运行到这了~~~~~"+roundEnv);

        //两种判断注解生成完成的方法
        if (annotations.isEmpty()){}
        if (roundEnv.processingOver()){}


        return false;
    }

    /**
     * 允许此注解处理器处理的注解
     * 或者可以通过@SupportedAnnotationTypes来直接注册
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }
}
