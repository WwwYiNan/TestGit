package 斗地主;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PokerShuffleCards {
    public static void main(String[] args) {
        //准备花色
        ArrayList<String> color = new ArrayList<String>();
        color.add("♦");
        color.add("♥");
        color.add("♠");
        color.add("♣");
        //准备数字，用ArrayList 将纸牌由小到大排序
        ArrayList<String> number = new ArrayList<String>();
        for (int i = 3; i <= 10; i++) {
            number.add(i + "");
        }
        number.add("J");
        number.add("Q");
        number.add("K");
        number.add("A");
        number.add("2");
        //定义一个map集合：用来将数字与每一张牌进行对应
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int index = 0;
        for (String thisNumber : number) {
            for (String thisColor : color) {
                //将花色于数字组合，形成52张牌，并赋予其编号
                map.put(index++, thisColor + thisNumber);
            }
        }
        //加入大小王
        map.put(index++, "大王🃏");
        map.put(index++, "小王🃏");
        //创建内容为0~53的数字集合，代表54张牌
        ArrayList<Integer> cards = new ArrayList<Integer>();
        for (int i = 0; i <= 53; i++) {
            cards.add(i);//此时的cards顺序为0~53
        }
        //洗牌，使用Collections工具类中的shuffle()方法
        Collections.shuffle(cards);//此时的cards顺序已被打乱
        //创建三个玩家和底盘
        ArrayList<Integer> iPlayer1 = new ArrayList<Integer>();
        ArrayList<Integer> iPlayer2 = new ArrayList<Integer>();
        ArrayList<Integer> iPlayer3 = new ArrayList<Integer>();
        ArrayList<Integer> iSecretCards = new ArrayList<Integer>();
        //遍历这副洗好的牌，遍历过程中，将牌发给三个玩家
        for (int i = 0; i < cards.size(); i++) {
            if (i >= 51) {
                iSecretCards.add(cards.get(i));
            } else {
                if (i % 3 == 0) {
                    iPlayer1.add(cards.get(i));
                } else if (i % 3 == 1) {
                    iPlayer2.add(cards.get(i));
                } else {
                    iPlayer3.add(cards.get(i));
                }
            }

        }
        //对每个人手中的牌顺序，使用Collections工具类中的sort()方法
        Collections.sort(iPlayer1);
        Collections.sort(iPlayer2);
        Collections.sort(iPlayer3);
        //对应数字形式的每个人手中的牌，定义字符串形式的牌
        ArrayList<String> siPlayer1 = new ArrayList<String>();
        ArrayList<String> siPlayer2 = new ArrayList<String>();
        ArrayList<String> siPlayer3 = new ArrayList<String>();
        ArrayList<String> siSecretCards = new ArrayList<String>();
        //循环主键，从map中获取底牌
        for (Integer key : iPlayer1) {
            siPlayer1.add(map.get(key));
        }
        for (Integer key : iPlayer2) {
            siPlayer2.add(map.get(key));
        }
        for (Integer key : iPlayer3) {
            siPlayer3.add(map.get(key));
        }
        for (Integer key : iSecretCards) {
            siSecretCards.add(map.get(key));
        }
        //看牌
        System.out.println("底牌" + siSecretCards);
        System.out.println("玩家1的牌： " + siPlayer1);
        System.out.println("玩家2的牌： " + siPlayer2);
        System.out.println("玩家3的牌： " + siPlayer3);

    }
}
