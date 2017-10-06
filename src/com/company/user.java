/* 这个类是父类，
    父类的数据成员有：存储用户id（是区别用户的主键）
                                       “关注数”focus，
                                       “粉丝数”fans，
                                       “微博数”weibo

    方法有：print
                   未完待续……
*/
// 为了便于管理，所以将信息分类，作为父类的继承，
package com.company;

public class user {
    String id;
    int focus = 0;//关注
    int fans = 0;//粉丝
    int weibo = 0;//微博
    
    // user类的构造器
    public user(String id){
        this.id=id;
    }
    //设置focus的值
    public int setFocus(int userFocus){
//        if (userFocus == 0) {
//            return 0;
//        }
        this.focus=userFocus;
        return 0;
    }
    //设置fans的值
    public int setFans(int userFans){
//        if (userFans == 0) {
//            return 0;
//        }
        this.fans=userFans;
        return 0;
    }
    //设置weibo的值
    public int setWeibo(int userWeibo){
//        if (userWeibo == 0) {
//            return 0;
//        }
        this.weibo=userWeibo;
        return 0;
    }
    //输出user值
    public  int print(){
        System.out.print(id + focus + fans + weibo);
        return 0;
    }
    
}

// 创建和使用该类的方法，已经验证
/*
* String id = "123";
        user user_1 = new user(id);
        user_1.setFans(123);
        user_1.setFocus(123);
        user_1.setWeibo(123);
        user_1.print();
* */