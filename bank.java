package Mini_Banking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bank {
    public static void main(String args[]) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String name;
        int pass_code;
        int ch;
        double amount;
        double interestRate;

        while (true) {
            System.out.println("\n ->|| Welcome to InBank ||<- \n");
            System.out.println("1) Create Account");
            System.out.println("2) Login Account");
            System.out.println("3) Add Money to Account");
            System.out.println("4) Withdraw Money with Interest");
            System.out.println("5) Check Balance");
            System.out.println("6) Exit");

            try {
                System.out.print("\nEnter Input: ");
                ch = Integer.parseInt(sc.readLine());

                switch (ch) {
                    case 1:
                        System.out.print("Enter Unique UserName: ");
                        name = sc.readLine();
                        System.out.print("Enter New Password (numeric): ");
                        pass_code = Integer.parseInt(sc.readLine());
                        if (bankmanagement.createAccount(name, pass_code)) {
                            System.out.println("MSG : Account Created Successfully!");
                        } else {
                            System.out.println("ERR : Account Creation Failed!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter UserName: ");
                        name = sc.readLine();
                        System.out.print("Enter Password: ");
                        pass_code = Integer.parseInt(sc.readLine());
                        if (bankmanagement.loginAccount(name, pass_code)) {
                            System.out.println("MSG : Login Successful!");
                        } else {
                            System.out.println("ERR : Login Failed!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter UserName: ");
                        name = sc.readLine();
                        System.out.print("Enter Amount to Deposit: ₹");
                        amount = Double.parseDouble(sc.readLine());
                        if (bankmanagement.depositMoney(name, amount)) {
                            System.out.println("MSG : ₹" + amount + " Deposited Successfully!");
                        } else {
                            System.out.println("ERR : Deposit Failed!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter UserName: ");
                        name = sc.readLine();
                        System.out.print("Enter Amount to Withdraw: ₹");
                        amount = Double.parseDouble(sc.readLine());
                        System.out.print("Enter Interest Rate (%): ");
                        interestRate = Double.parseDouble(sc.readLine());
                        double totalAmount = amount + (amount * (interestRate / 100)); // Calculate total with interest
                        if (bankmanagement.withdrawMoney(name, totalAmount)) {
                            System.out.println("MSG : ₹" + amount + " Withdrawn Successfully with ₹" +
                                    (totalAmount - amount) + " as Interest!");
                        } else {
                            System.out.println("ERR : Withdrawal Failed!");
                        }
                        break;

                    case 5:
                        System.out.print("Enter UserName: ");
                        name = sc.readLine();
                        bankmanagement.checkBalance(name);
                        break;

                    case 6:
                        System.out.println("Exited Successfully! Thank You for using InBank :)");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid Entry! Please Select a Valid Option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERR : Enter a Valid Numeric Option!");
            }
        }
    }
}
