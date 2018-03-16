package java86;

import java.io.*;

public class Javatest {

    public static long xermote(String fileName) throws IOException {
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(fileName));
        String str = null;

        int num_sum = 0;
        int word_sum = 0;
        int sym_sum = 0;
        int sum = 0;


        int count = 0;

        while ((str = reader.readLine()) != null) {
            count++;
            word_sum += str.split(" |,").length;
            num_sum += str.length();
        }

        System.out.println("字符数量" + num_sum);
        System.out.println("单次数量" + word_sum);
        System.out.println("行数" + count);
        sum = sym_sum + num_sum + word_sum;
        System.out.println("总数" + sum);
        return sum;
    }


    public static void main(String[] args) {
        String fileName = "测试.txt";
        System.out.println("文件" + fileName + "数目");
        try {
            Javatest.xermote(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
