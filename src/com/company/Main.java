/*  老师提供的微博数据的编码需要改成utf-8，否则是乱码
* 每一行str_splited对应一个arr数组
* unhandled exception 是因为对于特定的语句（读写文件）必须有异常处理
* */
package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static com.company.Regax.p;

public class Main {
    private static int length = 200
            ;
    private static String[] str_from_file = new String[length];


    // 将文件中的字符串读入到str数组中
    public static void read_txt() {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
                /* 读入TXT文件 */
            String pathname = "C:\\Users\\Cooper\\Desktop\\test.java";
//            String pathname = "C:\\Users\\Cooper\\Desktop\\微博数据.java";
//            String pathname = "C:\\Users\\Cooper\\Desktop\\微博数据.txt";
            // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件

//            System.out.println(filename.exists()); //判断文件是否存在
            if (!filename.exists()) {
                System.out.println("找不到文件");
                return;
            } else {
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(filename));
                // 建立一个输入流对象reader

                BufferedReader br = new BufferedReader(reader);
                // 建立一个对象，它把文件内容转成计算机能读懂的语言

                //                str_from_file[0] = br.readLine();
                for (int i = 0; str_from_file != null; i++) { // 数据长度还未定，就用“EOF”或“null”
                    str_from_file[i] = br.readLine(); //把数据读取到str数组中
//                    System.out.print(str_from_file[i] + "\n"); // 输出来看看是否写入数组
                }
                /*while (str_from_file[i] != null){
                    str_from_file[i] = br.readLine();
                    i++;
                }*/

                /* 写入Txt文件 */
                // File writename = new File(".\\result\\en\\output.txt");
                // 相对路径，如果没有则要建立一个新的output。txt文件
                /// 这里出了问题，通过更改文件路径成功运行了此方法。
//                File writename = new File("C:\\Users\\Cooper\\Desktop\\output.txt");
//                writename.createNewFile(); // 创建新文件
//                BufferedWriter out = new BufferedWriter(new FileWriter(writename));
                //out.write("我会写入文件啦\r\n"); // \r\n即为换行
                //out.flush(); // 把缓存区内容压入文件

                //out.close(); //关闭输出文件
                reader.close(); // 最后记得关闭文件
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 对数据进行预处理，“微博大咖”，“null”，“\b\t”
    // 2017-10-9 09:15:56 有问题，Exception in thread "main" java.lang.IllegalStateException: No match availableat java.util.regex.Matcher.appendReplacement(Matcher.java:798)    at com.company.Main.str_preprocess(Main.java:87)    at com.company.Main.main(Main.java:213)
//    public static String[] str_preprocess(String[] str_temp) {
//        //每次处理一行
//        //参数是从文件中读取的字符串数组和行数，返回值为预处理完毕的字符串数组
// String temp = "\t" + "微博大咖";
//        Pattern p_weibodaka = Pattern.compile("微博大咖",Pattern.CASE_INSENSITIVE);
//        Matcher m = p_weibodaka.matcher(str_temp[i]);
//        p_weibodaka(m.replaceAll(temp));
//
//         //这段代码没用到正则表达式的正确写法，有问题
////        String temp_str = "\t" + "微博大咖";
//        String[] str_preprocessed = new String[length];
//        int i = 0;
//        StringBuffer buf = new StringBuffer();
//        while (str_temp[i] != null) { //对str的每一行都清洗一遍
//            Pattern p_weibodaka = Pattern.compile("微博大咖",Pattern.CASE_INSENSITIVE);
//            Matcher m = p_weibodaka.matcher(str_temp[i]);
//            m.appendReplacement(buf, "\t微博大咖");
//
//Pattern p_null= Pattern.compile("null",Pattern.CASE_INSENSITIVE);
//            Matcher m_null= p_weibodaka.matcher(str_temp[i]);
//            m_null.appendReplacement(buf, "\tnull");
//
//            Pattern p_bt = Pattern.compile("\b\t",Pattern.CASE_INSENSITIVE);
//            Matcher m_bt= p_weibodaka.matcher(str_temp[i]);
//            m_bt.appendReplacement(buf, "\t");
//
//            Pattern p_tt = Pattern.compile("\t\t",Pattern.CASE_INSENSITIVE);
//            Matcher m_tt = p_tt.matcher(str_temp[i]);
//            m_tt.appendReplacement(buf, "\t");
//
//
//            ++i;
//        }
//
//        for (String s : str_preprocessed) {
//            //打印，检查是否成功
//            System.out.println(s);
//        }
//
//        return str_preprocessed; //返回预处理过的数组
//    }

//    public static String[] str_split(String[] str_temp, int i) {
//        //参数是从文件中读取的字符串数组和第i行，返回值为分割好的字符串数组
//        String string = str_temp[i];
//        String reg = "\t"; //按照\t进行分割
//        String[] arr = string.split(reg); //arr 是临时数组，存储分割好的字符串
////        System.out.print(arr.length);   //打印数组长度
///*
//        for (String s : arr) {
//            System.out.println(s);
//        }
//*/
//        return arr;
//    }

    // 判断一个字符串是否都为数字
    public static boolean isDigit(String strNum) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) strNum);
        return matcher.matches();
    }

    //截取数字
    public String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    // 截取非数字
    public String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public static void str_regax(String[] str_temp, int i) {
        boolean flag = isDigit(str_temp[0]); //因为第一行存储的就是id，所以需要判断是否全为数字

        //判断是否全为数字
        if (flag) {
//            System.out.println("这行数据合法！");
            // 这里填充对于合法数据行的对象创建


        } else {
            System.out.println("这行数据不合法，需要进一步处理");
            // 这类是在id号后面紧跟着字符串，需要根据后面的字符串不同，分别处理，暂且认为是不合法，之后详细分类处理。
        }
    }

    public static void convert_txt(String[] strings) {
        //处理文本，每一条如下，分隔符为tab(\t)
        int i = 0;
        String[] str_splited = new String[length];
        while (strings != null) {
            //2017-10-9 09:22:50 不再分割每一行字符串，而是直接处理一行
//            str_splited = str_split(strings, i);
            //将第i行的字符串分割好，存到str_splited数组中

            str_regax(str_splited, i);
            //对分割好的数组str_splited进行正则表达式过滤
            i++;
        }
    }

    public static void Output_str_to_screen(String[] strTemp) {
        for (String s : strTemp) {
            System.out.println(s);
        }
        /*int i = 0;
        while (str_from_file != null){
            System.out.println(str_from_file[i]);
            i++;
        }*/
    }

    public static void Output_str_to_file(String[] str_temp) {
        try { //对文件读写，必须有异常处理
            File writename = new File("C:\\Users\\Cooper\\Desktop\\output_str_splited.txt");
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            int i = 0;
            while (str_temp[i] != null || i <= length) {
                out.write(str_temp[i] + "\n");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        int i = 0;
        read_txt();
        String[] str_preprocessed = new String[length];
//        str_preprocessed = str_preprocess(str_from_file);
        Output_str_to_screen(str_preprocessed);
        convert_txt(str_from_file);
        Output_str_to_file(str_preprocessed);
        //成功读取并将数据保存在数组中
        /*while (str[i] != "null"){
            System.out.print(str[i] + "\n");
            i++;
        }*/
        // System.out.println("hello,world");
    }

}

