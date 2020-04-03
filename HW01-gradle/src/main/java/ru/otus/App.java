/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.otus;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


/**
 * To start the application:
 * ./gradlew build
 * java -jar ./L01-gradle/build/libs/gradleHelloWorld-0.1.jar
 * <p>
 * To unzip the jar:
 * unzip -l L01-gradle.jar
 * unzip -l gradleHelloWorld-0.1.jar
 * <p>
 * To build:
 * ./gradlew build
 */
public class App {
    public static void main(String... args) {
        String str = ",,,bam,  ,  bum,, bah   ,nah";

        String s = Joiner.on(", ").join(3, 2, 1);
        System.out.println(s);

        Iterable<String> p = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(str);
        System.out.println(p);
    }
}
