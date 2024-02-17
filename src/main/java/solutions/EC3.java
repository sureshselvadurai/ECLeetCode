package solutions;

import java.util.Arrays;

//Problem 1 :905. Sort Array By Parity
//Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//Return any array that satisfies this condition.
// Reference : https://leetcode.com/problems/sort-array-by-parity/description/

//Problem 2 :2545. Sort the Students by Their Kth Score
//There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score contains distinct integers only.
//        You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest.
//        Return the matrix after sorting it.
// Reference : https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/

//Problem 3 :75. Sort Colors
//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//        You must solve this problem without using the library's sort function.
// Reference : https://leetcode.com/problems/sort-colors/description/
public class EC3 {

    //    Problem 1 Solution
    public static int[] sortArrayByParity(int[] nums) {
        int j = nums.length-1;
        int i = 0;
        while (i!=j){
            if(nums[i]%2!=0){
                swap(nums,i,j);
                j--;
            }else {
                i++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //    Problem 2 Solution
    public static int[][] sortTheStudents(int[][] score, int k) {
        for(int i = 0;i<score.length;i++){
            int maxIndex = i;
            int max = score[i][k];
            for(int j = i;j<score.length;j++) {
                if (score[j][k] > max) {
                    maxIndex = j;
                    max = score[j][k];
                }
            }
            swap(score,i,maxIndex);
        }
        return score;
    }

    public static void swap(int[][] score, int i, int j) {
        int[] temp = score[i];
        score[i] = score[j];
        score[j] = temp;
    }

    //    Problem 3 Solution
    public static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }

    public static void main(String[] args) {

//        Solution Test
        int[] test1 = {1,2,6,4,8,6,3};
        System.out.println(Arrays.toString(sortArrayByParity(test1)));
        int[][] test2 = {
                {64766, 11978, 20502, 21365, 79611, 36797, 58431, 89540, 59373, 25955},
                {51305, 66104, 88468, 5333, 17233, 32521, 14087, 42738, 46669, 65662},
                {93306, 92793, 54009, 9715, 24354, 24895, 20069, 93332, 73836, 64359},
                {23358, 84599, 4675, 20979, 76889, 34630, 64098, 23468, 71448, 17848}
        };
        System.out.println(Arrays.toString(sortTheStudents(test2,0)));
        int[] test3 = {1,2,0,1,0,1};
        sortColors(test3);
        System.out.println(Arrays.toString(test3));

    }


}