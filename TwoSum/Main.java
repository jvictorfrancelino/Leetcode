package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        int[] result = twoSumBruteForce(new int[]{2, 5, 5, 11}, 10);
//        System.out.println("The result is: " + Arrays.toString(result));

        int[] resultSecondMethod = twoSumTwoPassHashTable(new int[]{2, 7, 11, 15}, 9);
        System.out.println("The result is: " + Arrays.toString(resultSecondMethod));

    }

    public static int[] twoSumBruteForce(int[] nums, int target){
        for (int i = 0; i < nums.length; i++ ){
            for (int i2 = i+1; i2 < nums.length; i2++){
                int sum = nums[i] + nums[i2];
                if (sum == target){
                    return new int[]{i, i2};
                }
            }
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }

    public static int[] twoSumTwoPassHashTable(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i );
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i,map.get(complement)};
            }
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }

    public static int[] twoSumOnePassHashTable(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i );
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }
}