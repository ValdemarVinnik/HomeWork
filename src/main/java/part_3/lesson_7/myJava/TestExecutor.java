package part_3.lesson_7.myJava;

import part_3.lesson_7.annotations.AfterSuit;
import part_3.lesson_7.annotations.BeforeSuit;
import part_3.lesson_7.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestExecutor {
    public static void start(Class testClass) {

        Method[] methods = testClass.getMethods();

        executeBeforeSuitTests(methods, testClass);
        executeTests(methods, testClass);
        executeAfterSuitTests(methods, testClass);

    }

    private static void executeAfterSuitTests(Method[] methods, Class testClass) {
        boolean isAfterSuitAble = true;
        for (Method each : methods) {

            if (each.getAnnotation(AfterSuit.class) != null) {
                if (!isAfterSuitAble) {
                    throw new RuntimeException();
                }

                try {
                    each.invoke(testClass.newInstance());
                    isAfterSuitAble = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void executeTests(Method[] methods, Class testClass) {
        List<Method> testMethods = new ArrayList();

        for (Method each : methods) {
            if (each.getAnnotation(Test.class) != null) {

                testMethods.add(each);
            }
        }

        Collections.sort(testMethods, new Comparator<Method>() {
            @Override
            public int compare(Method methodOne, Method methodTwo) {
                return methodOne.getAnnotation(Test.class).value() - methodTwo.getAnnotation(Test.class).value();
            }
        });

        for (Method each : testMethods) {
            try {
                each.invoke(testClass.newInstance());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    private static void executeBeforeSuitTests(Method[] methods, Class testClass) {
        boolean isBeforeSuitAble = true;
        for (Method each : methods) {

            if (each.getAnnotation(BeforeSuit.class) != null) {
                if (!isBeforeSuitAble) {
                    throw new RuntimeException();
                }

                try {
                    each.invoke(testClass.newInstance());
                    isBeforeSuitAble = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}



