package com.src.main;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Launcher {

  public static void main(String[] args) {

    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

    CustomerReader reader = new CustomerReader(queue);
    CustomerProcessor writer = new CustomerProcessor(queue);
    new Thread(reader).start();
    new Thread(writer).start();

  }

 }