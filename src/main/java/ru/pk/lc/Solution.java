package ru.pk.lc;

public class Solution {

    public int totalSteps(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int[] idx2 = new int[nums.length];
        for (int i = 0; i < idx2.length; i++) {
            idx2[i] = i;
        }

        int[] idx = new int[idx2.length];
        int[] idx3;

        int steps = 0;
        boolean reduced;
        int i2 = idx2.length;
        do {
            reduced = false;

            idx3 = idx;
            idx = idx2;
            idx2 = idx3;

            int idxLength = i2;

            int prev = nums[idx[0]];
            idx2[0] = idx[0];
            i2 = 1;

            for (int i = 1; i < idxLength; i++) {
                int j = idx[i];
                int numsJ = nums[j];

                if (prev > numsJ) {
                    //ok. continue
                    reduced = true;
                } else {
                    idx2[i2] = j;
                    i2++;
                }

                prev = numsJ;
            }

            if (reduced) {
                steps++;
            }
        } while(reduced);

        return steps;
    }

}
