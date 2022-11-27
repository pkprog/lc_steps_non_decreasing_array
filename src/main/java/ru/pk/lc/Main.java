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
//        int[] n1 = new int[] {1,2,4,3}; //1
//        start(n1);
//        int[] n2 = new int[] {4,5,7,7,13}; //0
//        start(n2);
//        int[] n3 = new int[] {5,3,4,4,7,3,6,11,8,5,11};  //3
//        start(n3);
//        int[] n4 = new int[] {5,3,4,4,7,3,6,11}; //3
//        start(n4);
//        int[] n5 = loadFromFile("test_case1.txt"); //1
//        start(n5);
//        int[] n6 = loadFromFile("test_case5.txt"); //17599
//        start(n6);
        int[] n7 = loadFromFile("test_case6.txt"); //99999
        start(n7);
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