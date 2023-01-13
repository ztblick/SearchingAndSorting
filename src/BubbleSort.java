import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

    public static final int N = 5;
    public static final int MIN_NUM = 10;
    public static final int MAX_NUM = 99;
    public static final String[] NAMES =
            {"Abby", "Barry", "Charlie", "Daniel", "Eloise", "Francois", "Giulale",
            "Hernan", "Ignacio", "Juio", "Kristy", "Louis", "Mikey", "Nathan", "Octave",
            "Patrick", "Quinton", "Roger", "Sam", "Tyler", "Ursula", "Veronica", "Winston",
            "Xavier", "Yvonne", "Zach"};

    public static void sort(String[] arr) {
        for (int pass = 1; pass < N; pass++) {
            System.out.println("\nPass " + pass);
            for (int comp = 0; comp < N - pass; comp++) {
                System.out.print("Comp " + comp + ": ");
                printArray(arr);
                if (arr[comp].compareTo(arr[comp+1]) > 0) {
                    System.out.println("Swapping " + arr[comp] + " and " + arr[comp+1] + "...");
                    String temp = arr[comp];
                    arr[comp] = arr[comp + 1];
                    arr[comp + 1] = temp;
                }
            }
        }
    }

    public static void sort(Integer[] arr) {
        for (int pass = 1; pass < N; pass++) {
            System.out.println("\nPass " + pass);
            for (int comp = 0; comp < N - pass; comp++) {
                System.out.print("Comp " + comp + ": ");
                printArray(arr);
                if (arr[comp] > arr[comp+1]) {
                    System.out.println("Swapping " + arr[comp] + " and " + arr[comp+1] + "...");
                    int temp = arr[comp];
                    arr[comp] = arr[comp + 1];
                    arr[comp + 1] = temp;
                }
            }
        }
    }

    public static void printArray(Object[] arr) {
        for (Object i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void randomFill(Integer[] arr) {
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM;
        }
    }

    public static void randomFill(String[] arr) {
        for (int i = 0; i < N; i++) {
            arr[i] = NAMES[(int) (Math.random() * (NAMES.length))];
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to BubbleSort!\nEnter 1 to sort integers or 2 to sort Strings.");
        Scanner console = new Scanner(System.in);
        int choice = console.nextInt();
        console.nextLine();

        switch(choice) {
            case 1:
                Integer[] nums = new Integer[N];
                BubbleSort.randomFill(nums);
                BubbleSort.printArray(nums);
                BubbleSort.sort(nums);
                BubbleSort.printArray(nums);
                break;

            case 2:
                String[] names = new String[N];
                BubbleSort.randomFill(names);
                BubbleSort.printArray(names);
                BubbleSort.sort(names);
                BubbleSort.printArray(names);
                break;

            default:
                System.out.println("Invalid entry.");
                return;
        }
    }
}
