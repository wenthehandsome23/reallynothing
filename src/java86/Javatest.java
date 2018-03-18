package java86;

import java.io.*;
import java.util.*;

public class Javatest {






    public static int countC(String fn){
        BufferedReader reader = null;
        int res=0;
        try {
            reader = new BufferedReader(new FileReader(fn));
            String str = null;
            while ((str = reader.readLine()) != null) {

                res += str.length();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;

    }

    public static int countW(String fn,List<String> list){
        BufferedReader reader = null;
        int res=0;
        try {
            reader = new BufferedReader(new FileReader(fn));
            String str = null;
            while ((str = reader.readLine()) != null) {
                String[]temp=str.split(" |,");
                for(String s:temp){
                    if(s!=null&&!list.contains(s)){
                        ++res;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static int countL(String fn){
        BufferedReader reader = null;
        int res=0;
        try {
            reader = new BufferedReader(new FileReader(fn));
            String str = null;
            while ((str = reader.readLine()) != null) {
                ++res;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }


    public static String buildRes(String fn,char c,int res){
        StringBuilder sb=new StringBuilder();
        switch (c) {
            case 'c':
                sb.append(fn+",字符数"+res+"\n");
                break;
            case 'w':
                sb.append(fn+",单词数"+res+"\n");
                break;
            case 'l':
                sb.append(fn+",行数"+res+"\n");
                break;
        }
        return sb.toString();
    }

    public static List<String> read(String fn){
        List<String> list=new ArrayList<String>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fn));
            StringBuilder sb=new StringBuilder();
            String s=null;
            while((s=reader.readLine())!=null){
                sb.append(s);
                sb.append(" ");
            }
            String[] arr=sb.toString().split(" ");
            Arrays.stream(arr).forEach(x->{
                list.add(x);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

        public static void main(String[] args) {

            int cNum=0,lNum=0,wNum=0;
            List<String>list=new LinkedList<String>();
            final String[] p = {"-c", "-a", "-l", "-w", "-o","-s","-e"};
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter Your Command:");
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
            StringBuilder res=new StringBuilder();

            try {
                for (int i = 1; i < len; ++i) {
                    if (parame[i].equals("-c")) {
                       cNum=countC(inName);
                       res.append(buildRes(inName,'c',cNum));
                    } else if (parame[i].equals("-l")) {
                        lNum=countL(inName);
                        res.append(buildRes(inName,'l',lNum));
                    } else if (parame[i].equals("-w")) {
                        if(list.size()==0){
                            for(int j=i+1;j<len;++j){
                                if(parame[j].equals("-e")){
                                    list=read(parame[j+1]);
                                    break;
                                }
                            }
                        }
                        wNum=countW(inName,list);
                        res.append(buildRes(inName,'w',wNum));
                    } else if (parame[i].equals("-o")) {
                        outName = parame[i + 1];
                    } else if (parame[i].equals("-e")) {
                        String stopFile = parame[i + 1];
                        list=read(stopFile);
                    } else if (parame[i].equals("-s")) {

                    } else if (parame[i].equals("-a")) {

                    }
                }

                outName = outName == null ? "result.txt" : outName;

                FileWriter writer = new FileWriter(outName);
                writer.write(res.toString());
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
