package ru.otus.aop.proxy;


import ru.otus.aop.proxy.annotation.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Ioc  {

    private Ioc()  {
    }

    static TestLogging createTestLog() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLoggingImpl());
        return (TestLogging) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLogging.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLogging testLog;
        private final Set<Method> toTestMet;

        DemoInvocationHandler(TestLogging testLog) {
            this.testLog = testLog;
            toTestMet = Arrays.stream(testLog.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(Log.class))
                    .collect(Collectors.toSet());
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for(Method targetMet : toTestMet) {
                if(targetMet.getName().equals(method.getName())
                        && Arrays.equals(targetMet.getParameterTypes(), method.getParameterTypes())) {
                    System.out.println("executed method: " + method.getName()
                            + ", params: " + Arrays.toString(args));
                    break;
                }
            }
            return method.invoke(testLog, args);
        }
    }
}
