package com.src.main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class CustomerProcessor implements Runnable {

	protected BlockingQueue<String> blockingQueue = null;

	public CustomerProcessor(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new File("outputFile.txt"));

			while (true) {
				Thread.sleep(20);
				String buffer = blockingQueue.take();
				// Check whether end of file has been reached
				if (buffer.equals("EOF")) {
					break;
				}
				if (buffer.contains("%") || buffer.contains("&")) {
					buffer=buffer.replaceAll("%", "EXP");
					buffer=buffer.replaceAll("&", "EXP");
				}
				System.out.println(buffer);
				writer.println(buffer);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

		} finally {
			writer.close();
		}

	}
}
