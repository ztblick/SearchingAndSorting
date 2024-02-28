import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorter
 *
 * By: Zach Blickensderfer
 * Date: Feb. 26, 2023
 * Written for CS2 @ Menlo School in Atherton, CA
 *
 * Sorter implements various sorting algorithms. It is designed to
 * engage topics like inheritance and polymorphism, as well as
 * recursion, to help students wrap their heads around the Java
 * implementation of Merge Sort and Quick Sort.
 */


public class Sorter {

    public static final int N = 100;
    public static final int MIN_NUM = 1000;
    public static final int MAX_NUM = 9999;
    public static final String[] NAMES =
            {"Abby", "Beckett", "Charlie", "Diego", "Eloise", "Francois", "Giulale",
            "Hannah", "Isha", "Julia", "Kirin", "Louis", "Mikey", "Niko", "Octave",
            "Patrick", "Quinton", "Rayan", "Sam", "Tyler", "Ursula", "Victoria", "Winston",
            "Xavier", "Yuanye", "Zach"};

    public static void bubbleSort(Comparable[] arr) {
        for (int pass = 1; pass < arr.length; pass++) {
            for (int comp = 0; comp < arr.length - pass; comp++) {
                if (arr[comp].compareTo(arr[comp+1]) > 0) {
                    Comparable temp = arr[comp];
                    arr[comp] = arr[comp + 1];
                    arr[comp + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(Comparable[] arr) {
        for (int pass = 0; pass < arr.length; pass++) {
            int minIndex = pass;
            for (int comp = pass; comp < arr.length; comp++) {
                if (arr[comp].compareTo(arr[minIndex]) < 0) {
                    minIndex = comp;
                }
            }
            Comparable temp = arr[pass];
            arr[pass] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    private static int[] mergeSort(int[] arr, int low, int high) {
        if (high - low == 0) {
            int[] newArr = new int[1];
            newArr[0] = arr[low];
            return newArr;
        }
        int med = (high + low) / 2;
        int[] arr1 = mergeSort(arr, low, med);
        int[] arr2 = mergeSort(arr, med + 1, high);
        return merge(arr1, arr2);
    }


    private static int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[i+j] = arr1[i];
                i++;
            }
            else {
                merged[i+j] = arr2[j];
                j++;
            }
        }
        while(i < arr1.length) {
            merged[i+j] = arr1[i];
            i++;
        }
        while(j < arr2.length) {
            merged[i+j] = arr2[j];
            j++;
        }
        return merged;
    }

    private static Comparable[] mergeSort(Comparable[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static Comparable[] mergeSort(Comparable[] arr, int low, int high) {
        if (high - low == 0) {
            Comparable[] newArr = new Comparable[1];
            newArr[0] = arr[low];
            return newArr;
        }
        int med = (high + low) / 2;
        Comparable[] arr1 = mergeSort(arr, low, med);
        Comparable[] arr2 = mergeSort(arr, med + 1, high);
        return merge(arr1, arr2);
    }

    private static Comparable[] merge(Comparable[] arr1, Comparable[] arr2) {
        Comparable[] merged = new Comparable[arr1.length + arr2.length];
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) < 0) {
                merged[i+j] = arr1[i];
                i++;
            }
            else {
                merged[i+j] = arr2[j];
                j++;
            }
        }
        while(i < arr1.length) {
            merged[i+j] = arr1[i];
            i++;
        }
        while(j < arr2.length) {
            merged[i+j] = arr2[j];
            j++;
        }
        return merged;
    }

    private static void quickSort(int[] data, int left, int right, int depth) {
        if (left >= right) return;

        int i = left, j = left;

        while (j < right) {
            if (data[j] <= data[right]) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
            }
            j++;
        }
        int temp = data[right];
        data[right] = data[i];
        data[i] = temp;

        quickSort(data, left, i - 1, depth + 1);
        quickSort(data, i + 1, right, depth + 1);
    }

    private static void quickSort(Comparable[] data) {
        quickSort(data, 0, data.length - 1, 1);
    }

    private static void quickSort(Comparable[] data, int left, int right, int depth) {
        if (left >= right) return;

        int i = left, j = left;

        while (j < right) {
            if (data[j].compareTo(data[right]) < 0) {
                Comparable temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
            }
            j++;
        }
        Comparable temp = data[right];
        data[right] = data[i];
        data[i] = temp;

        quickSort(data, left, i - 1, depth + 1);
        quickSort(data, i + 1, right, depth + 1);
    }

    public static void printArray(Comparable[] arr) {
        for (Object i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void randomFill(Comparable[] arr) {
        if (arr instanceof Integer[]) {
            randomFill((Integer[]) arr);
        }
        else {
            randomFill((String[]) arr);
        }
    }

    public static void randomFill(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM;
        }
    }

    public static void randomFill(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = NAMES[(int) (Math.random() * (NAMES.length))];
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Sorter!\nEnter 1 to sort integers or 2 to sort Strings.");
        Scanner console = new Scanner(System.in);
        int type = console.nextInt();
        console.nextLine();
        System.out.println("Now, enter:\n\t1 for Bubble Sort,\n\t2 for Selection Sort,\n\t3 for Merge Sort," +
                "\n\t4 for Quick Sort, or\n\t5 for Runtime Analysis");
        int choice = console.nextInt();
        console.nextLine();

        if (choice == 5) {
            System.out.println("Beginning runtime analysis...");
            Sorter.getData(type);
            System.out.println("Runtime analysis complete!");
            return;
        }

        Comparable[] data;
        switch (type) {
            case 1 -> data = new Integer[N];
            case 2 -> data = new String[N];
            default -> {
                System.out.println("Invalid entry.");
                return;
            }
        }
        Sorter.randomFill(data);
        Sorter.printArray(data);
        switch (choice) {
            case 1 -> Sorter.bubbleSort(data);
            case 2 -> Sorter.selectionSort(data);
            case 3 -> data = Sorter.mergeSort(data);
            case 4 -> Sorter.quickSort(data, 0, N - 1, 1);
            default -> {
                System.out.println("Invalid entry.");
                return;
            }
        }
        Sorter.printArray(data);
    }

    public static void getData(int type) {
        String fileName = "data.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Dataset Size,Bubble Sort,Selection Sort,MergeSort,QuickSort");

            int[] datasetSizes = {10, 100, 1000, 10000, 20000, 30000, 40000, 50000};
            for (int size : datasetSizes) {
                long startTime, endTime;

                // Run Algorithm 1
                Comparable[] unsortedData;
                switch (type) {
                    case 1 -> unsortedData = new Integer[size];
                    case 2 -> unsortedData = new String[size];
                    default -> {
                        System.out.println("Invalid type.");
                        return;
                    }
                }
                // Set up the data
                Sorter.randomFill(unsortedData);
                Comparable[] toSort = unsortedData.clone();

                // Run Bubble Sort
                System.out.println("Sorting " + size + " elements with Bubble Sort...");
                startTime = System.nanoTime();
                Sorter.bubbleSort(toSort);
                endTime = System.nanoTime();
                long algorithm1Runtime = endTime - startTime;

                toSort = unsortedData.clone();
                // Run Selection Sort
                System.out.println("Sorting " + size + " elements with Selection Sort...");
                startTime = System.nanoTime();
                Sorter.selectionSort(toSort);
                endTime = System.nanoTime();
                long algorithm2Runtime = endTime - startTime;

                toSort = unsortedData.clone();
                // Run MergeSort
                System.out.println("Sorting " + size + " elements with MergeSort...");
                startTime = System.nanoTime();
                Sorter.mergeSort(toSort);
                endTime = System.nanoTime();
                long algorithm3Runtime = endTime - startTime;

                toSort = unsortedData.clone();
                // Run QuickSort
                System.out.println("Sorting " + size + " elements with QuickSort...");
                startTime = System.nanoTime();
                Sorter.quickSort(toSort);
                endTime = System.nanoTime();
                long algorithm4Runtime = endTime - startTime;

                writer.println(size + "," + algorithm1Runtime + "," + algorithm2Runtime
                        + "," + algorithm3Runtime + "," + algorithm4Runtime);
            }

            System.out.println("Data written to file " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }
}
