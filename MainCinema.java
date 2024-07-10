import java.util.*;
import javax.swing.*;
import java.io.*;

public class MainCinema {
    public static void main(String[] args) {
        try {
            //create 4 queues
            Queue qCustomer     = new Queue();
            Queue qCounter1     = new Queue();
            Queue qCounter2     = new Queue();
            Queue qCompleted    = new Queue();
            
            //create file reader
            BufferedReader in = new BufferedReader(new FileReader("customer.txt"));
            
            String inData = null;
            
            //create object
            Cinema cust;
            
            while((inData = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inData, ";");
                String cN = st.nextToken();
                String mN = st.nextToken();
                double pR = Double.parseDouble(st.nextToken());
                double nOT = Double.parseDouble(st.nextToken());
                String mT = st.nextToken();
                double tP = Double.parseDouble(st.nextToken());
                
                //insert variables into object
                cust = new Cinema(cN, mN, pR, nOT, mT, tP);
                
                //add object into customer
                qCustomer.enqueue(cust);
            }
            in.close();
            
            for(int i = 0; i < 3; i++) {
                cust = (Cinema) qCustomer.dequeue();
                qCounter1.enqueue(cust);
            }
            for(int i = 0; i < 3; i++) {
                cust = (Cinema) qCustomer.dequeue();
                qCounter2.enqueue(cust);
            }
            
            int menu = 0;
            do {
               System.out.println("Press 1 - Remove 1 customer from counter 1"); 
               System.out.println("Press 2 - Remove 1 customer from counter 2");
               System.out.println("Press 3 - Exit and display completed customer");
               
               //ask user to enter menu
               String input = JOptionPane.showInputDialog("Enter Menu");
               menu = Integer.parseInt(input);
               
               if(menu == 1) {
                   while(!qCounter1.empty()) {
                       //remove 1 customer
                       cust = (Cinema) qCounter1.dequeue();
                       
                       //add new customer from waiting list in qCustomer to counter 1
                       qCounter1.enqueue(qCustomer.dequeue());
                       
                       //calculate total payment
                       double payment = cust.getPrice() * cust.getNumOfTicket();
                       
                       //set the old price to new price
                       cust.setTotalPayment(payment);
                       
                       //insert the object to qCompleted
                       qCompleted.enqueue(cust);
                       
                       String answer;
                       input = JOptionPane.showInputDialog("Do you wish to continue (yes/no)");
                       answer = input;
                       
                       if(answer.equalsIgnoreCase("yes")) {
                           continue;
                       } else {
                           break;
                       }
                   }
               } else if(menu == 2) {
                   while(!qCounter2.empty()) {
                       //remove 1 customer
                       cust = (Cinema) qCounter2.dequeue();
                       
                       //add new customer from waiting list in qCustomer to counter 2
                       qCounter2.enqueue(qCustomer.dequeue());
                       
                       //calculate total payment
                       double payment = cust.getPrice() * cust.getNumOfTicket();
                       
                       //set the old price to new price
                       cust.setTotalPayment(payment);
                       
                       //insert the object to qCompleted
                       qCompleted.enqueue(cust);
                       
                       String answer;
                       input = JOptionPane.showInputDialog("Do you wish to continue (yes/no)");
                       answer = input;
                       
                       if(answer.equalsIgnoreCase("yes")) {
                           continue;
                       } else {
                           break;
                       }
                   }
               }
            } while(menu != 3);
            //display qCompleted
            while(!qCompleted.empty()) {
                    cust = (Cinema) qCompleted.dequeue();
                    System.out.println(cust);
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}