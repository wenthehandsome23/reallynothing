package java86;

import java.io.*;
import java.util.Scanner;

public class Javatest {


    static int num_sum = 0;
    static  int word_sum = 0;
    static int sym_sum = 0;
    static int sum = 0;

    static int count = 0;

    public static long xermote(String fileName) throws IOException {
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(fileName));
        String str = null;

        PrintStream ps = new PrintStream("F:/Users/MSI/log.txt");

        while ((str = reader.readLine()) != null) {
            count++;
            word_sum += str.split(" |,").length;
            num_sum += str.length();
        }



        System.setOut(ps);

        System.out.println("字符数量" + num_sum);
        System.out.println("单次数量" + word_sum);
        System.out.println("行数" + count);
        sum = sym_sum + num_sum + word_sum;
        System.out.println("总数" + sum);

        System.out.println("这行语句将会被写到log.txt文件中");
        return sum;
    }


        public static void main(String[] args) {

            final String[] p = {"-c", "-a", "-l", "-w", "-o"};
            Scanner sc = new Scanner(System.in);
            System.out.println("ScannerTest, Please Enter Name:");
            String cmd = sc.nextLine();
            sc.close();
            String[] parame = cmd.split(" ");
            int len = parame.length;

            String inName = null;

            for (int i = 1; i < len; ++i) {
                boolean flag = false;
                for (int j = 0; j < p.length; ++j) {
                    if (parame[i].equals(p[j])) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    inName = parame[i];
                    break;
                }
            }

            String outName = null;
            try {
                xermote(inName);
                String result = "";
                for (int i = 1; i < len; ++i) {

                    if (parame[i].equals("-c")) {
                        result += "字符数量："+Javatest.num_sum+"/n";
                    } else if (parame[i].equals("-l")) {

                    } else if (parame[i].equals("-w")) {

                    } else if (parame[i].equals("-o")) {
                        outName = parame[i + 1];
                    } else if (parame[i].equals("-e")) {
                        String stopFile = parame[i + 1];
                    }
                }
                outName = outName == null ? "result.txt" : outName;
                FileWriter writer = new FileWriter(outName);
                writer.write(result);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
