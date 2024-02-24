package solutions;
import java.util.Arrays;

//Problem 1 : 1329. Sort the Matrix Diagonally (Medium)
//A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
//Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

//Problem 2 : 451. Sort Characters By Frequency (Medium)
//        Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
//        Return the sorted string. If there are multiple answers, return any of them.

public class EC4 {
    public static int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            for (int i = 0; i < m; i++) {
                diagonalSortAlgo(mat, i, 0, m, n);
            }
            for (int j = 1; j < n; j++) {
                diagonalSortAlgo(mat, 0, j, m, n);
            }
            return mat;
        }

        private static void diagonalSortAlgo(int[][] mat, int i, int j, int m, int n) {
            int[] diagonal = new int[Math.min(m - i, n - j)];
            int index = 0;
            while (i < m && j < n) {
                diagonal[index++] = mat[i][j];
                i++;
                j++;
            }

            for (int p = 0; p < diagonal.length - 1; p++) {
                for (int q = 0; q < diagonal.length - p - 1; q++) {
                    if (diagonal[q] > diagonal[q + 1]) {
                        int temp = diagonal[q];
                        diagonal[q] = diagonal[q + 1];
                        diagonal[q + 1] = temp;
                    }
                }
            }
            i--;
            j--;
            for (int k = diagonal.length-1;k>=0;k--) {
                mat[i--][j--] = diagonal[k];
            }
        }

    public static String frequencySort(String s) {
        int[] frequency = new int[128];

        for (char c : s.toCharArray()) {
            frequency[c]++;
        }

        int maxFrequency = 0;
        for (int freq : frequency) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        StringBuilder[] buckets = new StringBuilder[maxFrequency + 1];
        for (int i = 0; i <= maxFrequency; i++) {
            buckets[i] = new StringBuilder();
        }

        for (int i = 0; i < 128; i++) {
            char c = (char) i;
            int freq = frequency[i];
            if (freq > 0) {
                buckets[freq].append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = maxFrequency; i >= 1; i--) {
            StringBuilder bucket = buckets[i];
            for (int j = 0; j < bucket.length(); j++) {
                char c = bucket.charAt(j);
                for (int k = 0; k < i; k++) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

//        Solution 1 Test
        int[][] input =  {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        System.out.println(" P1 : " + Arrays.deepToString(diagonalSort(input)));

//        Solution 2 Test
        System.out.println(frequencySort("tree"));
    }
}
