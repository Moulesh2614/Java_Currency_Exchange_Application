import java.util.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class main {
    static String source;
    static int sourceIndex;
    static String result;
    static int resultIndex;
    static Scanner input1;
    static Scanner input2;
    //static boolean isNumber;

    static int sourceCurrency(){
        //Takes in source currency and calls getSourceIndex in sourceCurrency class.
        sourceCurrency sc = new sourceCurrency();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Enter Source Currency from:-");
        System.out.println("USD, GBP, CHF, INR");
        System.out.println("------------------------------------------------------------------------------------------");
        input1 = new Scanner(System.in);
        source = (input1.nextLine()).toUpperCase();
        sourceIndex = sc.getSourceIndex(source);
        //System.out.println(sourceIndex);
        //System.out.println(source);
        return sourceIndex;
    }

    static int resultCurrency(){
        //Takes in result currency and calls getResultIndex in resultCurrency class.
        resultCurrency rc = new resultCurrency();
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Enter Result Currency from:-");
        System.out.println("USD, GBP, CHF, INR");
        System.out.println("------------------------------------------------------------------------------------------");
        input2 = new Scanner(System.in);
        result = (input2.nextLine()).toUpperCase();
        resultIndex = rc.getResultIndex(result);
        //System.out.println(resultIndex);
        //System.out.println(result);
        return resultIndex;
    }



    static void Convert(){

        //Using 2D array to store currency information
        double[][] currency = {
                {1.000000, 1.29498, 1.09820, 0.0136097},
                {0.772268, 1.000000, 0.848271, 0.0105101},
                {0.910585, 1.17887, 1.000000, 0.0123905},
                {73.4772, 95.1467, 80.7070, 1.000000}
        };
        Scanner exit = new Scanner(System.in);
        boolean isNumber;

        do {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Press Q to quit or any other key to continue... ");
            System.out.println("------------------------------------------------------------------------------------------");
            String exitProgram = exit.next();

            if ((!"q".equals(exitProgram))&&(!"Q".equals(exitProgram))){

                sourceIndex = sourceCurrency();
                resultIndex = resultCurrency();

                if(sourceIndex == resultIndex){ //Checks for valid currency choice
                    do {
                        System.out.println("");
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("Error - Source and Result cannot be same! Please try Again.");
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("");

                        sourceIndex = sourceCurrency();
                        resultIndex = resultCurrency();

                    }while (sourceIndex == resultIndex);

                }

                System.out.println("");
                System.out.println("Enter Amount To Be Converted");
                Scanner amount = new Scanner(System.in);

                do {
                    if (amount.hasNextDouble()) { //Checks for valid Number input

                        double requestedAmount = amount.nextDouble();

                        do {
                            if(requestedAmount<1000000.00){
                                break;
                            }else {
                                System.out.println("Entered value exceeded maximum limit, please enter value less than 1,000,000");
                                requestedAmount = Double.parseDouble(amount.next());
                            }
                        }while (requestedAmount>1000000);

                        double finalAmount = requestedAmount*currency[resultIndex][sourceIndex];
                        double rounded = Math.round(finalAmount * 100.0) / 100.0;
                        String converted = String.format("%.2f", rounded);
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("The amount of the "+result+" that is equivalent to the "+requestedAmount+" in the "+source+" is - " +result+" "+ converted);
                        System.out.println("------------------------------------------------------------------------------------------");

                        System.out.println("");
                        System.out.println("If you wish to continue, type YES, or any other key to exit program");
                        Scanner prompt = new Scanner(System.in);
                        String promptAns = (prompt.nextLine()).toUpperCase();

                        if (promptAns.equals("YES")){
                            System.out.println(promptAns);
                            Convert(); //Recursive call to Convert() function.
                        }else {
                            System.out.println("------------------------------------------------------------------------------------------");
                            System.out.println("Program ran successfully. Thank you for using this application.");
                            System.out.println("------------------------------------------------------------------------------------------");

                            System.exit(0);
                        }


                        isNumber = true;

                    } else {
                        System.out.println("Invalid input, please enter a Number!");
                        isNumber = false;
                        amount.next();
                    }
                } while (!(isNumber));

            }
            else {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("Program Ended. Thank you for using this application.");
                System.out.println("------------------------------------------------------------------------------------------");
                System.exit(0);
            }
            //
        }while (!"q".equals(exit.next()));

    }

    public static void main(String[] args) {


        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Currency Converter is running");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Following currencies available, United States Dollars (USD), British Pounds (GBP), Swiss Francs (CHF), and Indian Rupees (INR)");
        System.out.println("");

        Convert(); // calls the Convert() function

    }
}
