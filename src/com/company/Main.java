/*  老师提供的微博数据的编码需要改成utf-8，否则是乱码
* 每一行str_splited对应一个arr数组
* unhandled exception 是因为对于特定的语句（读写文件）必须有异常处理
* */
package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String[] str = new String[3000];
    private static String[] str_splited = new String[3000];

    public static void read_txt() {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
                /* 读入TXT文件 */
//            String pathname = "C:\\Users\\Cooper\\Desktop\\test.java";
            String pathname = "C:\\Users\\Cooper\\Desktop\\微博数据.txt";
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

                /* 写入Txt文件 */
                // File writename = new File(".\\result\\en\\output.txt");
                // 相对路径，如果没有则要建立一个新的output。txt文件
                /// 这里出了问题，通过更改文件路径成功运行了此方法。
                File writename = new File("C:\\Users\\Cooper\\Desktop\\output.txt");
                writename.createNewFile(); // 创建新文件
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));
                /*
                String line = "";
                line = br.readLine();
                 while (line != null) {
                    line = br.readLine(); // 一次读入一行数据
                    //out.write(line + "\n");
                    //java.lang.NullPointerException 通过加了一个“\n”就解决了
                    //System.out.print(line);
                }
                */
//                str[0] = br.readLine();
                for (int i = 0; str != null; i++) { // 数据长度还未定，就用“EOF”或“null”
                    str[i] = br.readLine(); //把数据读取到str数组中
//                    System.out.print(str[i] + "\n"); // 输出来看看是否写入数组
                }
                /*while (str[i] != null){
                    str[i] = br.readLine();
                    i++;
                }*/

//                out.write("我会写入文件啦\r\n"); // \r\n即为换行
//                out.flush(); // 把缓存区内容压入文件
                out.close(); // 最后记得关闭文件
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] str_preprocess(String []str){
        //每次处理一行
        //参数是从文件中读取的字符串数组和行数，返回值为预处理完毕的字符串数组
        String temp_str = "\t"+"微博大咖";
        String []str_preprocessed = new String[3000];
        int i = 0;
        while(str[i] != null){ //对str的每一行都清洗一遍
            str_preprocessed[i] = str[i].replaceAll("微博大咖", temp_str);
            str_preprocessed[i] = str[i].replaceAll("null", "\tnull");
            str_preprocessed[i] = str[i].replaceAll("\b\t", "\t");
            str_preprocessed[i] = str[i].replaceAll("\t\t", "\t");
            ++i;
        }

        for (String s : str_preprocessed) {
            //打印，检查是否成功
            System.out.println(s);
        }

        return str_preprocessed; //返回预处理过的数组
    }
    public static  String[] str_split(String[] str, int i) {
        //参数是从文件中读取的字符串数组和第i行，返回值为分割好的字符串数组
        String string = str[i];
        String reg = "\t"; //按照\t进行分割
        String[] arr = string.split(reg); //arr 是临时数组，存储分割好的字符串
//        System.out.print(arr.length);   //打印数组长度
/*
        for (String s : arr) {
            System.out.println(s);
        }
*/
        return arr;
    }

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

    public static void str_regax(String[] str, int i) {
        boolean flag = isDigit(str[0]); //因为第一行存储的就是id，所以需要判断是否全为数字

        //判断是否全为数字
        if (flag) {
            System.out.println("这行数据合法！");
            // 这里填充对于合法数据行的对象创建


        } else {
            System.out.println("这行数据不合法，需要进一步处理");
            // 这类是在id号后面紧跟着字符串，需要根据后面的字符串不同，分别处理，暂且认为是不合法，之后详细分类处理。
        }
    }

    public static void convert_txt(String[] str) {
        //处理文本，每一条如下，分隔符为tab(\t)
        int i = 0;
        while (str != null) {
            str_splited = str_split(str, i);
            //将第i行的字符串分割好，存到str_splited数组中

            str_regax(str_splited, i);
            //对分割好的数组str_splited进行正则表达式过滤
            i++;
        }
    }

    public static void Output_str_splited(String[] str) {
        try { //对文件读写，必须有异常处理
            File writename = new File("C:\\Users\\Cooper\\Desktop\\output_str_splited.txt");
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            int i = 0;
            while (str_splited[i] != null) {
                out.write(str_splited[i] + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int i = 0;
        read_txt();
        str_preprocess(str);
        convert_txt(str);
        Output_str_splited(str_splited);
        //成功读取并将数据保存在数组中
        /*while (str[i] != "null"){
            System.out.print(str[i] + "\n");
            i++;
        }*/
        // System.out.println("hello,world");
    }

}

