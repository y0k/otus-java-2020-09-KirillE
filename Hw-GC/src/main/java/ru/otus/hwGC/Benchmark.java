package ru.otus.hwGC;

import java.util.ArrayList;
import java.util.List;

class Benchmark implements BenchmarkMBean {
  private final int loopCounter;

  public Benchmark(int loopCounter) {
    this.loopCounter = loopCounter;
  }

  private static List<Object> objContainer = new ArrayList<>();

  void run() throws InterruptedException {

    long beginTime = System.currentTimeMillis();

    while (objContainer.size() < loopCounter * .99) {
      for (double i = 0; i < loopCounter; i++) {
        Object newObj = i;
        objContainer.add(newObj);
      }
      System.out.println("after adding: " + objContainer.size());
      Thread.sleep(20000);
      objContainer = objContainer.subList(objContainer.size() / 2, objContainer.size());
      System.out.println("after remove: " + objContainer.size());
      Thread.sleep(20000);
      System.out.println("time: " + (System.currentTimeMillis() - beginTime) +"ms");

    }
    System.out.println("total time: " + (System.currentTimeMillis() - beginTime)+"ms");
  }
}
