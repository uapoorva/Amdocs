# Amdocs
take home assessment

1. Read data from Customers.csv using CustomerReader class and processed using CustomerProcessor.
2. Filtered the customer data depending on the below requirements:
      1) Two classes: One to read customer data(CustomerReader) , one to process customer data(CustomerProcessor)

      2) CustomerReader should read the customer data from file in sequence

      3) CustomerReader to read two different formats, CSV or TXT file – add capability, how to extend this to another format.

      4) CustomerProcessor For every 20 millisec, print the number of CustomerReader read at the same time & customerCreatedDate
      5) CustomerReader:  throw a new exception type – ‘IncorrectCustomerFormatException’  for customer’s name who has special characters (‘%’ ‘&’);

      6) CustomerProcessor: for such exception, replace the character with ‘EXP’.

      7) CustomerReader: Convert the ‘customerCreatedDate’ field always to ‘DD/MM/YYYY’.

      8) CustomerProcessor: Write the customers read to finalcustomer.txt & Print the customers read.
      
3. Code is located in the below URL:
     [Code Repository](https://github.com/uapoorva/Amdocs/tree/master/src/com/src)

