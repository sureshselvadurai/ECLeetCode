package solutions;

import helper.MinHeap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 1 : 1338. Reduce Array Size to The Half (Medium)
//You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
//Return the minimum size of the set so that at least half of the integers of the array are removed.
//    Reference : https://leetcode.com/problems/reduce-array-size-to-the-half/description/

//Problem 2 : //621. Task Scheduler (Medium)
//You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
//Return the minimum number of intervals required to complete all tasks.
//    Reference : https://leetcode.com/problems/task-scheduler/description/

public class EC8 {

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        MinHeap minHeap = new MinHeap(frequencyMap.size()+1);
        for (int freq : frequencyMap.values()) {
            minHeap.insert(freq);
        }

        int setSize = 0;
        int removedCount = 0;
        while (!minHeap.isEmpty() && removedCount < arr.length / 2) {
            removedCount += minHeap.removeMin();
            setSize++;
        }
        return setSize;
    }

    public static int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> taskFrequency = new HashMap<>();
        for (char task : tasks) {
            taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
        }

        MinHeap minHeap = new MinHeap(taskFrequency.size()+1);
        for (int frequency : taskFrequency.values()) {
            minHeap.insert(frequency);
        }
        int cycles = 0;

        while (!minHeap.isEmpty()) {
            int intervals = n + 1;
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < intervals; i++) {
                if (!minHeap.isEmpty()) {
                    int frequency = minHeap.removeMin();
                    if (frequency > 1) {
                        temp.add(frequency - 1);
                    }
                }
                cycles++;
                if (minHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            for (int frequency : temp) {
                minHeap.insert(frequency);
            }
        }
        return cycles;
    }
    public static void main(String[] args) {

        int[] arr1 = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println("Output for Test Case 1: " + minSetSize(arr1));

        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        System.out.println("Output for Test Case 1: " + leastInterval(tasks1, n1));

    }
}
