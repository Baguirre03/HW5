
/******************************************************************
 *
 *   Ben Aguirre / COMP 400C - 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < list1.length; i++) {
            set.add(list1[i]); // add to first set
        }

        for (int i = 0; i < list2.length; i++) {
            if (!set.contains(list2[i])) { // check if it is in list1
                return false; // return false if not
            }
        }

        return true; // made it through return true
    }

    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     * Input: [1,7,3,10,34,5,8], 4
     * Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // turn regular PQ into
        // maxPQ (another wa yto do this is by making it negative so when adding it do
        // -array[i] then return maxPQ.poll() * -1)
        // https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue

        for (int i = 0; i < array.length; i++) {
            maxPQ.add(array[i]); // add nums to pq
        }

        while (k > 1) {
            k--;
            maxPQ.poll(); // decrease k and pop from maxPQ
        }

        return maxPQ.poll(); // return Kth
    }

    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     * Input: [4,1,5], [3,2]
     * Output: 1 2 3 4 5
     *
     * @param array1 - Input array 1
     * @param array2 - Input array 2
     * @return - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // decalre PQ
        int res[] = new int[array1.length + array2.length]; // declare res of length1 + length2

        for (int i = 0; i < array1.length; i++) {
            pq.add(array1[i]); // add arr1 to pq
        }

        for (int i = 0; i < array2.length; i++) {
            pq.add(array2[i]); // add arr2 to pq
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll(); // set pq.poll() to index
        }

        return res;
    }

}