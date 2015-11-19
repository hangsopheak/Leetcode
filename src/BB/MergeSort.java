/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BB;

/**
 *
 * @author SONGSONG
 */
public class MergeSort {

    int[] array;
    int[] tmpArray;
    int length;

    public void sort(int[] input) {
        this.array = input;
        this.length = input.length;
        this.tmpArray = new int[length];
        doMergeSort(0, length - 1);
    }

    public void doMergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            doMergeSort(startIndex, mid);
            doMergeSort(mid + 1, endIndex);
            mergeArrays(startIndex, mid, endIndex);
        }
    }

    public void mergeArrays(int startIndex, int mid, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            tmpArray[i] = array[i];
        }
        int j = startIndex;
        int k = mid + 1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (j <= mid && k <= endIndex) {
                array[i] = tmpArray[j] < tmpArray[k] ? tmpArray[j++] : tmpArray[k++];
            } else if (j <= mid) {
                array[i] = tmpArray[j];
            } else if (k <= endIndex) {
                array[i] = tmpArray[k];
            }
        }
    }

    public static void main(String[] args) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
