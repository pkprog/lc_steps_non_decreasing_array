package ru.pk.lc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {

    private static void start(int[] nums) {
        System.out.println("Test array: " + Arrays.toString(nums));

        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");

        System.out.println("***start time:" + sdf.format(new Date()));
        int result = new Solution().totalSteps(nums);
        System.out.println("***end time:" + sdf.format(new Date()));
        System.out.println("Result:" + result);
    }

    public static void main(String[] args) {
        int[] n = new int[] {1,2,4,3};

        start(n);
    }

}