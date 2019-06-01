package sina;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class UserRegister {
    public static HashSet<User> USER_DATA = new HashSet<User>();//用户数据

    public static void main(String[] args) {
        initData();                             //初始化人员信息
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = scan.nextLine();      //获取用户名
        System.out.print("请输入密码：");
        String password = scan.nextLine();      //获取密码
        System.out.print("请输入重复密码：");
        String repassword = scan.nextLine();    //获取重复密码
        System.out.print("出生日期：");
        String birthday = scan.nextLine();      //获取出生日期
        System.out.print("手机号：");
        String tellNumber = scan.nextLine();    //获取手机号
        System.out.print("电子邮箱：");
        String email = scan.nextLine();         //获取电子邮箱
        CheckInfo checkInfo = new CheckInfo(USER_DATA);//校验用户信息，返回登陆状态信息
        String result = checkInfo.checkAction(userName, password, repassword, birthday, tellNumber, email);
        System.out.println("注册结果为： " + result);
    }

    //初始化数据，创建两个已存在的用户信息
    private static void initData() {
        User user1 = new User("张三", "zs,123", new Date(), "18810319240", "zhangsan@itcast.cn");
        User user2 = new User("李四", "zq,123", new Date(), "18618121193", "zhouqi@itcast.cn");
        USER_DATA.add(user1);
        USER_DATA.add(user2);
    }
}
