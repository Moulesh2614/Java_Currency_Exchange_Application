import java.util.*;

public class resultCurrency {
    static int resultIndex = 0;

    static int getResultIndex(String result){

        switch (result) {
            case "USD":
                System.out.println("You Selected USD");
                resultIndex = 0;
                break;
            case "GBP":
                System.out.println("You Selected GBP");
                resultIndex = 1;
                break;
            case "CHF":
                System.out.println("You Selected CHF");
                resultIndex = 2;
                break;
            case "INR":
                System.out.println("You Selected INR");
                resultIndex = 3;
                break;
            case "Q":
                System.out.println("Program Terminated. Thank you for using this application.");
                System.exit(0);
                break;
            default:
                System.out.println("Error, incorrect input, please check your input and try again");
                System.exit(0);
        }
        return resultIndex;
    }

}
