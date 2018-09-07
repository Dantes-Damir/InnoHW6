package proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Integer[] mas = {1, 3, 4, 5, 3};
        ObjectBox realMathBox = new MathBox(mas);
        ObjectBox mathBoxProxy = (ObjectBox) Proxy.newProxyInstance(MathBoxInvocationHandler.class.getClassLoader(),
                new Class[]{ObjectBox.class}, new MathBoxInvocationHandler(realMathBox));
        System.out.println(mathBoxProxy.summator());
    }
}