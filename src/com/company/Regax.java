package com.company;

public class Regax
{
    public static void main(String[] args) {
/*
        System.out.println("abc".matches("...")); // 一个点匹配任意一个字符
		//简单认识正则表达式的概念

		p("abc".matches("..."));
		p("a8729a".replaceAll("\\d", "-"));  //数字换成-

		Pattern p = Pattern.compile("[a-z]{3}"); //提前编译一个正则表达式以后处理就会更快了
		Matcher m = p.matcher("fgh");//matchaer匹配器，用来匹配一个某个字符串，匹配结果有多种，存储在Matcher
		p(m.matches());

		p("fgha".matches("[a-z]{3}")); //上面三句，等于此一句，三句效率更高，功能更强
*/

        //初步认识 . * + ?
		/*
		p("a".matches("."));
		p("aa".matches("aa"));
		p("aaaa".matches("a*")); //*代表0个或多个
		p("aaaa".matches("a+")); //+代表一个或多个
		p("".matches("a*"));
		p("aaaa".matches("a?")); //？代表0个或一个
		p("".matches("a?"));
		p("a".matches("a?"));
		p("214523145234532".matches("\\d{3,100}"));
		p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		p("192".matches("[0-2][0-9][0-9]"));
		*/

        //范围
		/*
		p("a".matches("[abc]"));
		p("a".matches("[^abc]")); //^位于中括号里面是“取反”，外面是起始位置
		p("A".matches("[a-zA-Z]"));
		p("A".matches("[a-z]|[A-Z]"));
		p("A".matches("[a-z[A-Z]]"));
		p("R".matches("[A-Z&&[RFG]]")); //&&交集
		*/

        //认识\s \w \d \
/*
        p(" \n\r\t".matches("\\s{4}"));
        p(" ".matches("\\S")); //非空格
        p("a_8".matches("\\w{3}"));
        p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
        p("\\".matches("\\\\")); // 一个反斜杠需要用\\\\
		*/

        //POSIX Style
        //p("a".matches("\\p{Lower}"));

        //boundary
		/*
		p("hello sir".matches("^h.*"));
		p("hello sir".matches(".*ir$"));
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*")); //  单词边界用//b标识
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));

		//whilte lines //空白行检测
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));

		p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 8888c".matches(".*\\b\\d{4}."));
		p("aaa8888c".matches(".*\\d{4}."));
		p("aaa8888c".matches(".*\\b\\d{4}."));
		*/

        //email
        //p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));

        //matches find lookingAt
		/*
		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);
		p(m.matches());
		m.reset();
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		//p(m.start() + "-" + m.end());
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		*/

        //replacement
		/*
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		p(m.repalceall("JAVA"); //替换为JAVA后打印出来

		//下面这个方法更灵活
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()) {
			i++;
			if(i%2 == 0) { //把偶数个换成小写
				m.appendReplacement(buf, "java");
			} else { //奇数换成大写的
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf); //添加尾巴到buf
		p(buf);
		*/

        //group 分组，有几对小括号就是几组，第几个左小括号就是第几组
		/*
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group()); //p(m.group(1));打印出最前面的一串数字，可以哟用于我们提取用户id
		}
		*/

        //qulifiers
		/*
		Pattern p = Pattern.compile(".{3,10}+[0-9]");
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find())
			p(m.start() + "-" + m.end());
		else
			p("not match!");
		*/

        //non-capturing groups
		/*
		Pattern p = Pattern.compile(".{3}(?=a)");
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());
		}
		*/

        //back refenrences
		/*
		Pattern p = Pattern.compile("(\\d(\\d))\\2");
		String s = "122";
		Matcher m = p.matcher(s);
		p(m.matches());
		*/

        //flags的简写
        //Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        p("Java".matches("(?i)(java)"));
    }

    //这个方法代替了一长串的System.out.println，类似于宏定义
    public static void p(Object o) {
        System.out.println(o);
    }

}

