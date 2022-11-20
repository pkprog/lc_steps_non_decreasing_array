package ru.pk.lc;

public class Solution {

    private int nextStep(int[] nums, int[] nums2, int idxLength) {
        int prev = nums[0];
        nums2[0] = nums[0];
        int i2 = 1;

        for (int i = 1; i < idxLength; i++) {
            int numsJ = nums[i];

            if (prev <= numsJ) {
                nums2[i2] = numsJ;
                i2++;
            }

            prev = numsJ;
        }

        return i2;
    }

    public int totalSteps(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int[] nums2 = new int[nums.length];

        int steps = 0;
        int i2 = nums.length;

        do {
            int newI2 = nextStep(nums, nums2, i2);
            if (newI2 == i2) {
                break;
            } else {
                steps++;
                i2 = newI2;
                //
                int[] nums3 = nums;
                nums = nums2;
                nums2 = nums3;
            }
        } while(true);

        return steps;
    }

}
