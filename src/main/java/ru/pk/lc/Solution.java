package ru.pk.lc;

import java.util.Arrays;

public class Solution {

    private int[] newIdx(int[] idx2, int len) {
        return Arrays.copyOf(idx2, len);
    }

    public int totalSteps(int[] nums) {
        int[] idx2 = new int[nums.length];
        for (int i = 0; i < idx2.length; i++) {
            idx2[i] = i;
        }

        int steps = 0;
        boolean reduced = false;
        int i2 = idx2.length;
        do {
            reduced = false;
            int[] idx = newIdx(idx2, i2);

            i2 = 0;
            int prev = -1;
            boolean first = true;
            for (int i = 0; i < idx.length; i++) {
                int j = idx[i];

                if (first) {
                    first = false;
                    idx2[i2] = j;
                    i2++;
                } else {
                    if (prev > nums[j]) {
                        //ok. continue
                        reduced = true;
                    } else {
                        idx2[i2] = j;
                        i2++;
                    }
                }

                prev = nums[i];
            }

            if (reduced) {
                steps++;
            }
        } while(reduced);

        return steps;
    }

}
