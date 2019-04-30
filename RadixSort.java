package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] unsorted = new int[50];
        Random rand = new Random();

        for(int i=0; i<50; i++){
            unsorted[i] = rand.nextInt(9000) + 1000;
        }

        radixSort(unsorted, 10, 4);

        for (int num : unsorted){
            System.out.println(num);
        }
    }

    public static void radixSort(int[] input, int radix, int width){

        for(int i=0; i<width; i++){
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix)
    {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(int value : input){
            countArray[getDigit(position, value, radix)]++;
        }
        for(int j=1; j<radix; j++){
            countArray[j] += countArray[j-1]; // adjust the count array , contains the number of values that have that digit or less than it
        }
        int[] temp = new int[numItems];

        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){ // writing values into a temporary array
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){ // copy temporary array back into input array
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int position, int value, int radix){
        return value/(int) Math.pow(radix, position) % radix;
    }
}
