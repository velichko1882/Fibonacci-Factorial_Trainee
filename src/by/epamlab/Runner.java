package by.epamlab;

import java.util.Scanner;

public class Runner {
    private static final String ERROR_MESSAGE_WRONG_NUMBER_FORMAT = "Wrong number format! Please try again.";
    private static final String ERROR_MESSAGE_WRONG_ALGORITHM_TYPE = "Wrong algorithm type.";
    private static final String ERROR_MESSAGE_WRONG_LOOP_TYPE = "Wrong loop type.";
    private static final String ERROR_MESSAGE_WRONG_NUMBER = "Wrong number to calculate.";
    private static final String WHILE = "Loop while:";
    private static final String DO_WHILE = "Loop do-while:";
    private static final String FOR = "Loop for:";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int algorithmId;
        int loopType;
        int numberToCalculate;

        System.out.println("Enter algorithm type: 1 - fibonacci, 2 - factorial");
        algorithmId = getIntNumber(sc);
        System.out.println("Enter loop type: 1 - while, 2 - do-while, 3 - for");
        loopType = getIntNumber(sc);
        System.out.println("Enter number to calculate");
        numberToCalculate = getIntNumber(sc);

        calculate(algorithmId, loopType, numberToCalculate);

        sc.close();

    }

//    private static int getAlgorithmId(Scanner sc){
//        while (true) {
//            String stringAlgorithmId = sc.nextLine().trim();
//            try {
//                int algorithmId = Integer.parseInt(stringAlgorithmId);
//                if (algorithmId >= 1 && algorithmId <= 2) {
//                    return algorithmId;
//                } else {
//                    System.out.println("Wrong number! Please try again.");
//                }
//            }catch (NumberFormatException e){
//                System.out.println("Wrong number format! Please try again.");
//            }
//
//        }
//    }

    private static int getIntNumber(Scanner sc){
        while (true) {
            String stringNumber = sc.nextLine().trim();
            try {
                int number = Integer.parseInt(stringNumber);
                    return number;
            }catch (NumberFormatException e){
                System.out.println(ERROR_MESSAGE_WRONG_NUMBER_FORMAT);
            }

        }
    }

    private static void calculate (int algorithmId, int loopType, int numberToCalculate){
        if (algorithmId == 1){
            getFibonacci(loopType, numberToCalculate);
        } else {
            if (algorithmId == 2){
                getFactorial(loopType, numberToCalculate);
            } else {
                System.out.println(ERROR_MESSAGE_WRONG_ALGORITHM_TYPE);
            }
        }
    }

    private static void getFibonacci(int loopType, int numberToCalculate){
        if (numberToCalculate > 1) {
            switch (loopType) {
                case 1:
                    getFibonacciLoopWhile(numberToCalculate);
                    break;
                case 2:
                    getFibonacciLoopDoWhile(numberToCalculate);
                    break;
                case 3:
                    getFibonacciLoopFor(numberToCalculate);
                    break;
                default:
                    System.out.println(ERROR_MESSAGE_WRONG_LOOP_TYPE);
            }
        } else {
            if (numberToCalculate == 1){
                System.out.println("1");
            } else {
                System.out.println(ERROR_MESSAGE_WRONG_NUMBER);
            }
        }
    }

    private static void getFibonacciLoopWhile(int numberToCalculate){
        int i = 1;
        int n0 = 0;
        int n1 = 1;
        int next;
        System.out.println(WHILE);
        System.out.print(n1 + " ");
        while (i < numberToCalculate){
            next = n0 + n1;
            System.out.print(next + " ");
            n0 = n1;
            n1 = next;
            i++;
        }
    }

    private static void getFibonacciLoopDoWhile(int numberToCalculate){
        int i = 1;
        int n0 = 0;
        int n1 = 1;
        int next;
        System.out.println(DO_WHILE);
        System.out.print(n1 + " ");
        do {
            next = n0 + n1;
            System.out.print(next + " ");
            n0 = n1;
            n1 = next;
            i++;
        }while (i < numberToCalculate);
    }

    private static void getFibonacciLoopFor(int numberToCalculate){
        int n0 = 0;
        int n1 = 1;
        int next;
        System.out.println(FOR);
        System.out.print(n1 + " ");
        for (int i = 1; i < numberToCalculate; i++) {
            next = n0 + n1;
            System.out.print(next + " ");
            n0 = n1;
            n1 = next;
        }
    }

    private static void getFactorial(int loopType, int numberToCalculate){
        if (numberToCalculate >= 0) {
            switch (loopType) {
                case 1:
                    getFactorialLoopWhile(numberToCalculate);
                    break;
                case 2:
                    getFactorialLoopDoWhile(numberToCalculate);
                    break;
                case 3:
                    getFactorialLoopFor(numberToCalculate);
                    break;
                default:
                    System.out.println(ERROR_MESSAGE_WRONG_LOOP_TYPE);
            }
        } else {
            System.out.println(ERROR_MESSAGE_WRONG_NUMBER);

        }
    }

    private static void getFactorialLoopWhile(int numberToCalculate){
        int i = 1;
        long factorial = 1;
        System.out.println(WHILE);
        while (i <= numberToCalculate){
            factorial *= i;
            i++;
        }
        System.out.println(factorial);
    }

    private static void getFactorialLoopDoWhile(int numberToCalculate){
        int i = 1;
        long factorial = 1;
        System.out.println(DO_WHILE);
        do {
            factorial *= i;
            i++;
        }while (i <= numberToCalculate);
        System.out.println(factorial);
    }

    private static void getFactorialLoopFor(int numberToCalculate){
        long factorial = 1;
        System.out.println(FOR);
        for (int i = 1; i <= numberToCalculate; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }

}
