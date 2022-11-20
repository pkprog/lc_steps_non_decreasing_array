package ru.pk.lc;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static void start(int[] nums) {
        if (nums.length > 100) {
            System.out.println("Test array (" + nums.length + "):...");
        } else {
            System.out.println("Test array (" + nums.length + "):" + Arrays.toString(nums));
        }

        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");

        System.out.println("***start time:" + sdf.format(new Date()));
        int result = new Solution().totalSteps(nums);
        System.out.println("***end time:" + sdf.format(new Date()));
        System.out.println("Result:" + result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        //int[] n = new int[] {1,2,4,3};
        //int[] n = new int[] {4,5,7,7,13};
        //int[] n = new int[] {5,3,4,4,7,3,6,11,8,5,11};
        //int[] n = new int[] {7,14,4,14,13,2,6,13};
//        int[] n = loadFromFile("test_case1.txt");
        int[] n = loadFromFile("test_case5.txt");

        start(n);
    }

    private static int[] loadFromFile(String path) {
        File f;
        try {
            URL url = Main.class.getClassLoader().getResource(path);
            if (url == null) {
                System.out.println("URL не найден");
                return null;
            }
            f = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String s = r.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            List<Integer> nList = new ArrayList<>();
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                try {
                    nList.add(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    System.out.println("Ошикбка парсинга файла:" + token);
                    return null;
                }
            }

            int[] n = new int[nList.size()];
            for (int i = 0; i < nList.size(); i++) {
                n[i] = nList.get(i);
            }
            return n;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}