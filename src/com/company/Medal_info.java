//勋章信息
package com.company;

public class Medal_info extends user {
    String class_info = "Lv.0" ; // 等级信息
    String current_class = "Lv.0"; //当前等级
    int exprerience_value = 0; // 经验值
    int to_next_class_value = 0; //距离升级需经验值

    // 默认构造函数
//要不要在构造函数里加数据成员的初始化值？？？
    public Medal_info(String id,
                      String class_info,
                      String current_class ,
                      int exprerience_value,
                      int to_next_class_value) {
        super(id);
        this.class_info = class_info;
        this.current_class = current_class;
        this.exprerience_value = exprerience_value;
        this.to_next_class_value = to_next_class_value;
    }

    //设置class_info
    public void setClass_info(String class_info) {
        this.class_info = class_info;
    }

    public String getClass_info() {
        return class_info;
    }

    public int print(){
//   System.out.print(class_info + focus + fans + weibo);
        return 0;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Medal_info that = (Medal_info) o;
//
//        return class_info.equals(that.class_info);
//    }
//
//    @Override
//    public int hashCode() {
//        return class_info.hashCode();
//    }
}
