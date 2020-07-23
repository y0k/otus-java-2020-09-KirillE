package ru.otus.aop.proxy;


import ru.otus.aop.proxy.annotation.Log;


public class TestLoggingImpl implements TestLogging {


    @Override
    @Log
    public void calculation(int a, int b) {
        System.out.println(a + b);
    }

    @Override

    public void calculationThreeSome(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}
