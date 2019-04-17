package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int[] unsorted = new int[50];
        for(int i=0; i<50; i++){
            unsorted[i] = rand.nextInt(50);
        }

        mergeSort(unsorted, 0, unsorted.length);

        for(int num : unsorted){
            System.out.println(num);
        }
    }


    public static void mergeSort(int[] input, int start, int end){

        if(end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid); // for the left part
        mergeSort(input, mid, end);   // for the right part
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end){
        if(input[mid - 1] < input[mid]){   // both parts are sorted and if the last el of the first is smaller
            return;                        // than the fist el of the second part then the array is sorted
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];

        while(i<mid && j<end){
            //tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];

            if(input[i] <= input[j]){
                tempArray[tempIndex] = input[i];
                tempIndex++;
                i++;
            }else {
                tempArray[tempIndex] = input[j];
                tempIndex++;
                j++;
            }
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, input, start, tempIndex);
    }
}
