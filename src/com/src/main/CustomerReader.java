package com.src.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

import com.src.Exception.IncorrectCustomerFormatException;

public class CustomerReader implements Runnable {

	protected BlockingQueue<String> blockingQueue = null;
	

	public CustomerReader(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run(){
		BufferedReader br = null;
		try {
			//Change the File Name. Place the file in Amdocs folder.
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\Customers.csv"));
			String line = "";
			String splitBy = ",";
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] customerData = line.split(splitBy);
				String customerName = customerData[1];
				String customerDate = customerData[2];
				if(customerName.isBlank() || customerDate.isBlank())
					continue;
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    Date date = formatter.parse(customerDate);
			    String newCustomerDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
			    try {
					if (customerName.contains("%") || customerName.contains("&")) {
						throw new IncorrectCustomerFormatException("Customer name incorrect.");
					}
			    }
			    catch (IncorrectCustomerFormatException e) {
			    	System.err.println(e.getMessage());
				}
				 blockingQueue.put(customerName+" - "+newCustomerDate);

			}
			blockingQueue.put("EOF"); 
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
