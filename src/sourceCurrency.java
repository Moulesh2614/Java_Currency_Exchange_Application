import java.util.*;

public class sourceCurrency {
    static int sourceIndex = 0;

    static int getSourceIndex(String source){

        switch (source) {
            case "USD":
                System.out.println("You Selected USD");
                sourceIndex = 0;
                break;
            case "GBP":
                System.out.println("You Selected GBP");
                sourceIndex = 1;
                break;
            case "CHF":
                System.out.println("You Selected CHF");
                sourceIndex = 2;
                break;
            case "INR":
                System.out.println("You Selected INR");
                sourceIndex = 3;
                break;
            case "Q":
                System.out.println("Program Terminated. Thank you for using this application.");
                System.exit(0);
                break;
            default:
                System.out.println("Error, incorrect input, please check your input and try again");
                System.exit(0);
        }
        return sourceIndex;
    }

}
