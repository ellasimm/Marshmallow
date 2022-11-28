package Hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HelloWorld {
//Omama's testing her code.
	
		public static void main(String[] args) throws FileNotFoundException{
		     
	        try {
	             
	              File obj = new File("User.txt");
	               
	              if (obj.createNewFile()) 
	              {
	                System.out.println("File is created");
	              } 
	               
	            } 
	            catch (IOException e) 
	            {
	              System.out.println("An error occurred.");
	              e.printStackTrace();
	               
	            }
	         
	        int choice;
	        Scanner sc=new Scanner(System.in);
	        System.out.println("1. Registration. ");
	        System.out.println("2. Login. ");
	         
	        System.out.println("Enter your Choice");
	        choice=sc.nextInt();
	        sc.nextLine();
	         
	        if(choice==1)
	        {
	            User user = new User();
	            user.register();
	        }
	        else if(choice==2)
	        {
	            User user = new User();
	            user.logIn();
	        }
	        else
	        {
	            System.out.println("Choose Proper Option");
	        }
	        sc.close();
	    }
	     


	}

