package bankaccount;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AccountDetailsMain {

	public static void main(String[] args) {

		var accountDetails=new HashMap<Long,AccountDetails>();

			Scanner sc=new Scanner(System.in);

			System.out.println("<<<<<<<<<<<<BANK APPLICATION>>>>>>>>>>>>>\n\n");

			

		System.out.println("Please select the option:\nY: To create a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close the Screen");

		     char c;

		     c=sc.next().charAt(0);

		     while(c != 'N'||c != 'n') {

		    	 

		    	 if(c=='Y'|| c=='y') {		

		    	 AccountDetails account=new AccountDetails();		

 	   	      	 
				//1. Getting Input for type of Account

				System.out.println("Enter the type of account:\n1.Savings\n2.Current\n");

				int temp;

				temp=sc.nextInt();

				sc.nextLine();

				while(true) {

				if(temp==1) {

					

					account.setAccountType("Savings");

					break;

				}

				else if(temp==2) {

					account.setAccountType("Current");

					break;

				}

				else {

					System.out.println("You have choosen an invalid option");

				//	System.out.println("---------------------------------------------------_");

					System.out.println("Enter the type of account:\n1.Savings\n2.Current\n");

					temp=sc.nextInt();

				}

				}
				
	
		//2. Input for the Account holder name

				while(true) {
				
				System.out.println("Enter the Account Holder Full Name : ");

				String name;
				
				 Scanner sc1 = new Scanner(System.in);
				 			  			    
				    while (!sc.hasNext("[A-Za-z]+")) {
				    	
				        System.out.println("<<<<<<<<<<<PLEASE ENTER CHARACTERS ONLY>>>>>>>>>>>\\n");
				        
				        sc.next();
				    }
				    String name1 = sc.next();
				    System.out.println("Thank you! Got " + name1 );
				    
//--------------------------------------------------------------------------------	
			
				//3. Input for the Account Number

				while(true) {

					System.out.println("Enter account number: ");

					String accnum=sc.nextLine();

					if((accnum!=null)&&(accnum.length()>=10)) {

						try {

							account.setAccountNumber(Long.parseLong(accnum));

							break;

						}

						catch(NumberFormatException e) {

							System.out.println("<<<<<<<<<<<PLEASE ENTER NUMERIC VALUES ONLY>>>>>>>>>>>\n");

						}

					}

			

					else {

						System.out.println("<<<<<<<<ENTER  ACCOUNT NUMBER GREATER THAN 10 DIGITS>>>>>>>\n");

						

					}

				

				}
				
		
				//4. Input for the Amount

				while(true) {

				System.out.println("Enter Amount :");

				//account.setAccountBalance(sc.nextDouble());

				String amt=sc.nextLine();

				if(amt!=null) {

					try {

					account.setAccountBalance(Double.parseDouble(amt));

					break;

				}

					catch(NumberFormatException e) {

						System.out.println("<<<<<<<<<<<PLEASE ENTER NUMERIC VALUES ONLY>>>>>>>>>>>\n");

					}
						}

				else {

					System.out.println("<<<<<<<PLEASE ENTER A NUMERIC VALUE>>>>>>>\n");

				}

				}

			//5. Input for the currency

				while(true) {
					System.out.println("Enter the type of account:\n1.IndianRupees\n2.USDollers\n3.EuropeanEuro\n4.DubaiDirhams\n");

					temp=sc.nextInt();

					sc.nextLine();

					while(true) {

					if(temp==1) {

						account.setCurrency("IndianRupees");

						break;

					}
					if(temp==2) {

						account.setCurrency("USDollers");

						break;
					}
					if(temp==3) {

						account.setCurrency("EuropeanEuro");

						break;
					}
					else if(temp==4) {

						account.setCurrency("DubaiDirhams");

						break;

					}

					else {

						System.out.println("You have choosen an invalid option");

					//	System.out.println("---------------------------------------------------_");

						System.out.println("Enter the type of account:\n1.Savings\n2.Current\n");

						temp=sc.nextInt();

					}

					}

	//	------------------------------------------------------------------------

				accountDetails.put(account.getAccountNumber(),account);

		    	 System.out.println("-----------------------------------------");

		    	 System.out.println("    ACCOUNT ADDED SUCCESSFULLY  ");

				DisplayDetails(account);
					
				System.out.println("Please select the option:\nY: For creating a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close this Screen");

				c=sc.next().charAt(0);

		    	 }}}

		    	 //Modifying the Account

		    	 else if(c=='E' || c=='e') {

		    		 

				    	 long an;

				    	 System.out.println("Enter the Account Number");

				    	 an=sc.nextLong();

				    	 if(accountDetails.containsKey(an)) {

				    		 AccountDetails details=new AccountDetails();

				    		 details=accountDetails.get(an);

				    				 

				    		 System.out.println("Select the field \n1: Account Type\n2: Full Name\n3: Amount \n4: Currency Type ");

				    		 int i;

				    		 i=sc.nextInt();

				    		 switch(i) {

				    		 case 1:{

				    			 if(details.getAccountType()=="Savings") {

				    				 details.setAccountType("Current");

				    				 System.out.println("*****Account type was updated from Savings to Current*****");

				    				 accountDetails.put(an,details);

				    				 DisplayDetails(details);

				    				 break;

				    			 }

				    			 else {

				    				 details.setAccountType("Savings");

				    				 System.out.println("*****Account type was updated from Current to Savings*****");

				    				 accountDetails.put(an,details);

				    				 DisplayDetails(details);

				    				 break;

				    			 }

				    		 }

				    		 case 2:{

				    			sc.nextLine();

				    			 System.out.println("Enter the full name: ");

				    			 details.setAccountName(sc.nextLine());

				    			 accountDetails.put(an,details);

				    			 System.out.println("*****NAME UPDATED SUCCESSFULLY*****");

			    				 DisplayDetails(details);

				    			 break;

				    			 

				    		 }

				    		 case 3:{

				    			 System.out.println("Enter the Amount: ");

				    			 details.setAccountBalance(sc.nextDouble());

				    			 accountDetails.put(an,details);

				    			 System.out.println("*****AMOUNT UPDATED SUCCESSFULLY*****");

			    				 DisplayDetails(details);

				    			 break;

				    		 }

				    		 case 4:{

				    			 System.out.println("Enter Currency Type: ");

				    			 details.setCurrency(sc.next());

				    			 System.out.println("*****CURRENCY UPDATED SUCCESSFULLY*****");

			    				 DisplayDetails(details);

				    			 break;

				    		 }

				    		default:{

				    			System.out.println("Enter a valid option :");

					    		 System.out.println("Select the field \n1: Account Type\n2: Full Name\n3: Amount \n4: Currency Type ");

					    		 i=sc.nextInt();



				    		}

				    		 

				    		 }

				    			System.out.println("Please select the option:\nY: For creating a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close this Screen");

								c=sc.next().charAt(0);

				    	 }

				    	 else {

				    		 System.out.println("*****ACCOUNT NOT FOUND*****\n");

					   	 System.out.println("-----------------------------------------------");

					 		System.out.println(" select the option to choose :\nY: For creating a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close this Screen");

								c=sc.next().charAt(0);

				    	 }

				    	 

				    	 

				     }

		    	 else if((c!='Y')&&(c!='N')&&(c != 'E')&&(c!='V')) {

			    	 System.out.println("Invalid option choosen");

			    	System.out.println("-------------------------------------");

			 		System.out.println("Please select the option:\nY: For creating a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close this Screen");

						c=sc.next().charAt(0);

			     }

		    	 else if(c=='V'||c=='v') {

		    		 long an;

		    		 System.out.println("Enter the Account Number");

			    	 an=sc.nextLong();

			    	 if(accountDetails.containsKey(an)) {

			    		 AccountDetails details=new AccountDetails();

			    		 details=accountDetails.get(an);

			    		 DisplayDetails(details);

			    		 System.out.println("Please select the option:\nY: For creating a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close this Screen");

							c=sc.next().charAt(0);

		    	 }

			    	 else {

			    		 System.out.println("*****ACCOUNT NOT FOUND*****\n");

				    	 System.out.println("----------------------------------------------");

				 		System.out.println("Please select the option:\nY : For creating a new Account\nE: Update the details for an Existing account\nV: View the Account details\nN: Close this Screen");

							c=sc.next().charAt(0);

			    	 }

			    		 

			     }

		     }

		   

		     	if(c=='N'||c=='n') {

			    	 System.out.println("Thanks for using our service");

			    	 System.out.println("---------------------------------------------------");

			     }

			     

				

				

				sc.close();

				int flag=0;

				if(accountDetails.size() > 0) {

					for(Entry<Long, AccountDetails> acc:accountDetails.entrySet()) {

						if(flag==0) {

						  	 System.out.println("-----------------------------------------------");

						   	 System.out.println("  OVERALL ADDED ACCOUNTS              ");

						   	 flag=1;

							}

						DisplayDetails(acc.getValue());

						

					}

				



		     }

			}

	

	public static void DisplayDetails(AccountDetails acc) {

		

		

   System.out.println("----------------------------------------------");

		System.out.println("Account Type :\t\t"+acc.getAccountType());

		System.out.println("Account Holder Name :\t"+acc.getAccountName());

		System.out.println("Account Number :\t"+acc.getAccountNumber());

		System.out.println("Amount in your Account :\t"+acc.getAccountBalance());

		System.out.println("Currency type :\t\t"+acc.getCurrency());

   	 System.out.println("----------------------------------------------\n");



	}

	

	



	}