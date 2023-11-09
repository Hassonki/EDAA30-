package bst;

import java.util.Random;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for(int i = 0; i<100000; i++){
            array[i] = (int) ( 100 * Math.random());
        }
        for(int i:array){
            System.out.println(i);
        }
        quicksort(array);
        System.out.println("-----------------");
        for(int i:array){
            System.out.println(i);
        }
    }
    public static void quicksort(int[] array){
        quicksort(array,0,array.length-1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,highIndex);
    
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer); 
        }
        swap(array,leftPointer,highIndex);
        quicksort(array,lowIndex,leftPointer-1);
        quicksort(array,leftPointer+1,highIndex);
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
