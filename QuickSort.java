package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] unsorted = new int[50];
        Random rand = new Random();

        for(int i=0; i<50; i++){
            unsorted[i] = rand.nextInt(50);
        }

        quickSort(unsorted, 0, unsorted.length);

        for(int num : unsorted){
            System.out.println(num);
        }
    }

    public static void quickSort(int[] input, int start, int end){ // with 1st elem pivot

        if ((end - start) < 2){
            return;
        }

        int pivot = partition(input, start, end);

        quickSort(input, start, pivot);
        quickSort(input, pivot + 1, end);

    }

    public static int partition(int[] input, int start, int end){
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i<j){
            // empty loop to keep decrementing j until we find elem < pivot or j crosses i
            while(i<j && input[--j] >= pivot); // --j to avoid IndexOutOfBounds (end is input.length)
            input[i] = input[j];
            // when we find a value that is greater than the pivot we want to put it on the right
            while(i<j && input[++i] <= pivot); // ++i because we want to start from elem after the pivot(i already used)
            input[j] = input[i];
        }

        input[j] = pivot;
        return j;
    }
}
