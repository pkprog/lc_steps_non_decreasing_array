package ru.pk.lc;

public class Solution {

    private int nextStep(int[] idx, int[] idx2, int[] nums, int idxLength) {
        int prev = nums[idx[0]];
        idx2[0] = idx[0];
        int i2 = 1;

        for (int i = 1; i < idxLength; i++) {
            int j = idx[i];
            int numsJ = nums[j];

            if (prev <= numsJ) {
                idx2[i2] = j;
                i2++;
            }

            prev = numsJ;
        }

        return i2;
    }

    public int totalSteps(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int[] idx2 = new int[nums.length];
        for (int i = 0; i < idx2.length; i++) {
            idx2[i] = i;
        }

        int[] idx = new int[idx2.length];
        int[] idx3;

        int steps = 0;
        int i2 = idx2.length;

        do {
            idx3 = idx;
            idx = idx2;
            idx2 = idx3;

            int newI2 = nextStep(idx, idx2, nums, i2);
            if (newI2 == i2) {
                break;
            } else {
                steps++;
                i2 = newI2;
            }
        } while(true);

        return steps;
    }

}
