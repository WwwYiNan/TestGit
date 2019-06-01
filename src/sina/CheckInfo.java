package sina;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class CheckInfo {
    public static HashSet<User> USER_DATA = new HashSet<User>();

    public CheckInfo(HashSet<User> USER_DATA) {
        this.USER_DATA = USER_DATA;
    }

    //校验用户信息，返回登录状态信息
    public String checkAction(String userName, String password, String repassword, String birthday, String phone, String email) {
        StringBuilder result = new StringBuilder();
        //1代表成功  2代表失败
        int state = 1;
        if (!password.equals(repassword)) {
            result.append("两次输入的密码不一样！\r\n");
            state = 2;
        }
        //生日判断
        if (birthday.length() != 10) {
            result.append("生日格式不正确！\r\n");
            state = 2;
        } else {
            for (int i = 0; i < birthday.length(); i++) {
                Character thisChar = birthday.charAt(i);
                if (i == 4 || i == 7) {
                    if (!(thisChar == '-')) {
                        result.append("生日格式不正确\r\n");
                        state = 2;
                    }
                } else {
                    if (!(Character.isDigit(thisChar))) {
                        result.append("生日格式不正确\r\n");
                        state = 2;
                    }
                }
            }
        }
        //手机号判断
        if (phone.length() != 11) {//判断手机号是否为11位数，若不是则此手机号无效
            result.append("手机号格式不正确！\r\t");
            state = 2;
            //默认有效手机号开头为 13，15，17，18
        } else if (!(phone.startsWith("13") || phone.startsWith("15") || phone.startsWith("17") || phone.startsWith("18"))) {
            result.append("手机号格式不正确！\r\t");
            state = 2;
        }
        //邮箱判断
        if (!email.contains("@")) {
            result.append("邮箱不正确！\r\t");
            state = 2;
        }
        if (state == 1) {
            //格式化日期返回Date对象
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateBirthday = null;
            try {
                dateBirthday = format.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User newUser = new User(userName, repassword, dateBirthday, phone, email);
            //将用户添加到列表中，同时根据HashSet 判断出用户名是否重复
            if (!USER_DATA.add(newUser)) {
                result.append("用户重复！");
                state = 2;
            }
            if (state == 1) {
                result.append("注册成功！！！");
            }
        }
        return result.toString();
    }
}
