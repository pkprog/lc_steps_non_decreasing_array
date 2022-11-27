package ru.pk.lc;

import java.util.Arrays;

public class Solution {

    private int nextStep(int[] nums, int[] nums2, int idxLength) {
        nums2[0] = nums[0];
        int i2 = 1;

        int start = -1;
        for (int i = 1; i < idxLength; i++) {
            if (nums[i-1] <= nums[i]) {
                if (start == -1) {
                    start = i;
                }
//                nums2[i2] = nums[i];
//                i2++;
            } else {
                if (start != -1) {
                    int lengthFromStart = i - start;
                    System.arraycopy(nums, start, nums2, i2, lengthFromStart);
                    i2 += lengthFromStart;
                    start = -1;
                }
            }
        }

        if (start != -1) {
            int lengthFromStart = idxLength - start;
            System.arraycopy(nums, start, nums2, i2, lengthFromStart);
            i2 += lengthFromStart;
        }

        return i2;
    }

    public int totalSteps(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int[] nums2 = new int[nums.length];

        int steps = 0;
        int maxLength = nums.length;

        do {
            int newMaxLength = nextStep(nums, nums2, maxLength);
            if (newMaxLength == maxLength) {
                break;
            } else {
                steps++;
                maxLength = newMaxLength;
                //
                int[] nums3 = nums;
                nums = nums2;
                nums2 = nums3;
            }
        } while(true);

        return steps;
    }

}
