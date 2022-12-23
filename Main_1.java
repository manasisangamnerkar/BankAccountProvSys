import java.util.Scanner;
abstract class BankAccount{
    float balance;
    int accountNumber;
    String customerName;
    BankAccount(float balance, int accountNumber, String customerName){
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }
    abstract void withdraw(float amount);
    void deposit(float amount){
        if(amount <= 0)
            System.out.println("Invalid deposit amount .... Transaction unsuccessful...Exiting");
        else {
            balance = balance + amount;
            System.out.println("Rs. "+amount + " deposited successfully ...Exiting");
        }
    }
    void display()
    {
        System.out.println("####### ACCOUNT DETAILS #######");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance : Rs. " + balance);
    }
}
class SavingsAccount extends BankAccount{
    SavingsAccount(float balance, int accountNumber, String customerName) {
        super(balance, accountNumber, customerName);
    }
    void withdraw(float amount)
    {
        if(amount <= 0)
            System.out.println("Invalid withdraw amount....Transaction Unsuccessful....Exiting");
        else if( amount > 0 && amount < balance){
            balance = balance - amount;
            System.out.println("Rs. "+amount+ "withdrawn successfully......Exiting");
        }
        else
            System.out.println("Insufficient Funds....Transaction Unsuccessful....Exiting");
    }
}
class CurrentAccount extends BankAccount{
    CurrentAccount(float balance, int accountNumber, String customerName) {
        super(balance, accountNumber, customerName);
    }
    void withdraw(float amount)
    {
        if(amount <= 0)
            System.out.println("Invalid withdraw amount....Transaction Unsuccessful....Exiting");
        else if( amount > 0 && amount <= balance){
            balance = balance - amount;
            System.out.println("Rs. "+amount+ " withdrawn successfully......Exiting");
        }
        else
            System.out.println("Insufficient Funds....Transaction Unsuccessful....Exiting");
    }
}
public class Main_1 {
    public static void main(String args[]){
        int ch, accountType;
        float amt;
        SavingsAccount sa = null; // sa ---> NULL location
        CurrentAccount ca =  null; // ca ---> NULL location
        Scanner in = new Scanner(System.in);

        System.out.println("Enter account type : savings - 1 / current - 2");
        accountType = in.nextInt();

        System.out.println("Enter the Account Number : ");
        int accNo = in.nextInt();
        in.nextLine();

        System.out.println("Enter the Customer Name : ");
        String cusName = in.nextLine();

        System.out.println("Enter the Balance in Rs : ");
        float bal = in.nextFloat();

        if(accountType == 1)
            sa = new SavingsAccount(bal,accNo, cusName); // sa ---> [balance, accountName, customerName]
        else
            ca = new CurrentAccount(bal, accNo, cusName); // sa ---> [balance, accountName, customerName]

        do{
            System.out.println("*********************MENU*********************");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : ");
            ch = in.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.println("Enter the amount to be deposited : ");
                    amt = in.nextFloat();
                    if(accountType == 1)
                        sa.deposit(amt);
                    else
                        ca.deposit(amt);
                    break;
                case 2:
                    System.out.println("Enter the amount to be withdrawn : ");
                    amt = in.nextFloat();
                    if(accountType == 1)
                        sa.withdraw(amt);
                    else
                        ca.withdraw(amt);
                    break;
                case 3:
                    if(accountType == 1)
                        sa.display();
                    else
                        ca.display();
                    System.out.println("Account Type : "+ accountType);
                    break;

                case 4:
                    System.out.println("Exiting Application !!!!!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }while(ch<=4);
    }
}
