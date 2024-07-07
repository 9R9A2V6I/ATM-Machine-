import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ATM {
    Map<Integer, Float> customerData = new HashMap<>();
    int currentPin;

    public ATM() {
        // Adding some dummy data for customers
        customerData.put(1234, 5000.0f);
        customerData.put(2345, 3000.0f);
        customerData.put(3454, 4000.0f);
    }

    public void checkPin() {
        System.out.println("Enter Your PIN");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if (customerData.containsKey(enteredPin)) {
            currentPin = enteredPin;
            menu();
        } else {
            System.out.println("Enter Valid PIN");
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Enter valid Choice");
                menu();
                break;
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + customerData.get(currentPin));
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to Withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        float balance = customerData.get(currentPin);
        if (amount > balance) {
            System.out.println("You don't have sufficient balance.");
        } else {
            customerData.put(currentPin, balance - amount);
            System.out.println("Money Withdrawn Successfully.");
            checkBalance();
        }

        menu();
    }

    public void depositMoney() {
        System.out.println("Enter Deposit Amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        float balance = customerData.get(currentPin);
        customerData.put(currentPin, balance + amount);

        System.out.println("Money Deposited Successfully.");
        checkBalance();
    }
}

class ATMMachine {
    public static void main(String[] args) {
        System.out.println("Hello");

        ATM obj = new ATM();
        obj.checkPin();
    }
}
