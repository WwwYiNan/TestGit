package KTV;

import java.util.*;


public class KTVByLinkedList {
    public static void main(String[] args) {
        System.out.println("————————欢迎来到点歌系统———————");
        System.out.println("0.添加歌曲至列表");
        System.out.println("1.将歌曲置顶");
        System.out.println("2.将歌曲前移一位");
        System.out.println("3.将歌曲后移一位");
        System.out.println("4.退出程序");
        //创建存储歌曲列表
        LinkedList lineUpList = new LinkedList();
        //添加一部分歌曲至歌曲列表中
        addMusicList(lineUpList);
        while (true) {
            System.out.print("请输入要执行的操作序号：");
            Scanner scan = new Scanner(System.in);
            int command = scan.nextInt();//接受键盘输入序号
            //执行序号对应功能
            switch (command) {
                case 0://添加歌曲至列表
                    addMusic(lineUpList);
                    break;
                case 1://将歌曲置顶
                    setTop(lineUpList);
                    break;
                case 2://将歌曲前移一位
                    setBefore(lineUpList);
                    break;
                case 3://将歌曲后移一位
                    setAfter(lineUpList);
                    break;
                case 4://退出
                    exit();
                    break;

                default:
                    System.out.println("————————————");
                    System.out.println("请输入正确序号！！");
                    break;
            }
            System.out.println("当前的歌曲列表：" + lineUpList);
        }


    }

    //初始时添加歌曲名称
    private static void addMusicList(LinkedList lineUpList) {
        lineUpList.add("稻香");
        lineUpList.add("夜曲");
        lineUpList.add("夜的第七章");
        lineUpList.add("以父之名");
        lineUpList.add("听妈妈的话");
        lineUpList.add("龙卷风");
        lineUpList.add("天亮以前说再见");
        System.out.println("初始歌曲列表：" + lineUpList);

    }

    //执行添加歌曲
    private static void addMusic(LinkedList lineUpList) {
        System.out.print("请输入要添加的歌曲名称：");
        String musciName = new Scanner(System.in).nextLine();//获取键盘输入字符串
        lineUpList.add(musciName);//添加指定歌曲到最后
        System.out.println("已添加歌曲：" + musciName);

    }

    //将歌曲置顶
    private static void setTop(LinkedList lineUpList) {
        System.out.print("请输入要置顶的歌曲名称：");
        String musicName = new Scanner(System.in).nextLine();
        int position = lineUpList.indexOf(musicName);//查找歌曲所在位置
        if (position < 0) {//判断歌曲是否存在
            System.out.println("该歌曲不在播放列表中！");
        } else {

            lineUpList.remove(musicName);//移除指定歌曲

            lineUpList.addFirst(musicName);//将指定歌曲放到第一位
            System.out.println("已将歌曲" + musicName + "置顶");
        }
    }

    //将歌曲往前移一位
    private static void setBefore(LinkedList lineUpList) {
        System.out.print("请输入要前移的歌曲名称：");
        String musicName = new Scanner(System.in).nextLine();
        int position = lineUpList.indexOf(musicName);
        if (position < 0) {
            System.out.println("列表中不存在这首歌");
        } else if (position == 0) {
            System.out.println("当前歌曲已经是第一了~");
        } else {
            lineUpList.remove(musicName);
            lineUpList.add(position - 1, musicName);
        }
        System.out.println("已将歌曲" + musicName + "移到前一位");
    }

    //将歌曲往后移一位
    private static void setAfter(LinkedList lineUpList) {
        System.out.print("请输入要后移的歌曲名称：");
        String musicName = new Scanner(System.in).nextLine();
        int position = lineUpList.indexOf(musicName);
        int num = lineUpList.size();
        if (position < 0) {
            System.out.println("列表中不存在这首歌");
        } else if (position + 1 == num) {
            System.out.println("当前歌曲已经是最后一个了~");
        } else {
            lineUpList.remove(musicName);
            lineUpList.add(position + 1, musicName);
        }
        System.out.println("已将歌曲" + musicName + "移到前一位");
    }

    //退出
    private static void exit() {
        System.out.println("--------------退出------------");
        System.out.println("您已经退出系统");
        System.exit(0);//结束正在运行的JAVA程序
    }
}
