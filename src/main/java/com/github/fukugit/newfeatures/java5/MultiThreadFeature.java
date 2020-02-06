package com.github.fukugit.newfeatures.java5;

import org.w3c.dom.css.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadFeature {
  public static void main(String[] args) throws Exception{
    execThread1();
    //execThread2();
    //execThread3();
    //execThread4();
  }

  public static void execThread1() {
    for(int i=1; i <= 10; i++) {
      NewThread newThread1 = new NewThread(i);
      //NewThread newThread2 = new NewThread(i++);
      // Asynchronous
      newThread1.start();
      //newThread2.start();
      // Synchronous
      //newThread1.run();
      //newThread2.run();
    }
  }

  static class NewThread extends Thread {

    private int count;

    public NewThread(int count) {
      this.count = count;
    }

    @Override
    public void run() {
      try {
        showLog(Thread.currentThread().getId(), this.count);
        try { sleep(1000); } catch (InterruptedException e) {}
      } catch (Exception e) {
        System.out.println("Error was occurred. [Error message : " + e.getMessage() + "]");
      }
    }

    private void showLog(long threadNum, int count) throws Exception {
      if (count % 9 == 0) {
        throw new Exception("The count number could be divided at 9, thread number: " + threadNum);
      } else {
        System.out.println("count: " + count + ", thread number: " + threadNum);
      }
    }
  }

  public static void execThread2() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    AtomicInteger count = new AtomicInteger(0);
    while (count.get() < 10) {
      int counter = count.incrementAndGet();
      executor.submit(() -> {
        try {
          showLog(Thread.currentThread().getId(), counter);
        } catch (Exception e) {
          System.out.println("Error was occurred. [Error message : " + e.getMessage() + "]");
        }
      });
    }

    // For finishing JVM successful.
    executor.shutdown();

    System.out.println("done!");

  }

  public static void execThread3() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    List<Future<?>> list = new ArrayList<Future<?>>();

    AtomicInteger count = new AtomicInteger(0);
    while (count.get() < 10) {
      int counter = count.incrementAndGet();
      Future<?> future = executor.submit(() -> {
        try {
          showLog(Thread.currentThread().getId(), counter);
        } catch (Exception e) {
          System.out.println("Error was occurred. [Error message : " + e.getMessage() + "]");
        }
      });
      list.add(future);
    }

    // For finishing JVM successful.
    executor.shutdown();

    // Waiting for thread working.
    for (Future<?> future : list) {
      future.get();
    }

    System.out.println("done!");
  }

  public static void execThread4() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    List<Future<?>> list = new ArrayList<Future<?>>();

    Counter countSync = new Counter();
    Integer count = 0;
    while (count < 10) {
      Future<?> future = executor.submit(() -> {
      int counter = countSync.incrementAndGet();
        try {
          showLog(Thread.currentThread().getId(), counter);
        } catch (Exception e) {
          System.out.println("Error was occurred. [Error message : " + e.getMessage() + "]");
        }
      });
      list.add(future);
      count ++;
    }

    // For finishing JVM successful.
    executor.shutdown();

    // Waiting for thread working.
    for (Future<?> future : list) {
      future.get();
    }

    System.out.println("done!");
  }

  private static void showLog(long threadNum, int count) throws Exception {
    if (count % 9 == 0) {
      throw new Exception("The count number could be divided at 9, thread number: " + threadNum);
    } else {
      System.out.println("count: " + count + ", thread number: " + threadNum);
    }
  }

  private static class Counter {
    private Integer count = 0;
    public synchronized Integer incrementAndGet() {
      this.count++;
      return this.count;
    }
  }
}
