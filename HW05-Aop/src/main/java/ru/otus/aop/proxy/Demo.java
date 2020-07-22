package ru.otus.aop.proxy;

public class Demo {
    public static void main(String[] args) {
        TestLogging myClass = Ioc.createTestLog();
        myClass.calculation(1, 2);
        myClass.calculationThreeSome(1, 2, 3);
    }
}



