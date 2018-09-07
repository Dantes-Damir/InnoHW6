package proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxInvocationHandler implements InvocationHandler {
    private ObjectBox mathBox;

    public MathBoxInvocationHandler(ObjectBox mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = mathBox.getClass();
        if (method.getAnnotation(ClearData.class) != null) {
            Field containerField = mathBox.getClass().getDeclaredField("sortedSet");
            containerField.setAccessible(true);

        }
        if (mathBox.getClass().getAnnotation(Logged.class) != null) {
            long startTime = System.currentTimeMillis();
            System.out.println("We call method " + method.getName());
            Object result = method.invoke(mathBox, args);
            System.out.println(" with time " + (System.currentTimeMillis() - startTime));

            return result;
        } else {
            return method.invoke(mathBox, args);
        }
    }
}
