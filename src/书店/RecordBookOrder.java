package 书店;

import java.awt.print.Book;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordBookOrder {
    static ArrayList<Books> booksList = new ArrayList<Books>();

    public static void main(String[] args) {
        init();
        for (int i = 0; i < booksList.size(); i++) {
            System.out.println(booksList.get(i));
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入图书编号：");
            int bookId = scan.nextInt();
            Books stockBooks = getBooksById(bookId);
            if (stockBooks != null) {
                System.out.println("当前图书信息" + stockBooks);
                System.out.print("请输入购买数量");
                int bookNumber = scan.nextInt();
                if (bookNumber <= stockBooks.number) {
                    Books books = new Books(stockBooks.id, stockBooks.name, stockBooks.price, bookNumber, stockBooks.price * bookNumber, stockBooks.Publish);
                    FileUtil.saveBooks(books);
                    stockBooks.setNumber(stockBooks.number - bookNumber);
                } else {
                    System.out.println("库存不足！");
                }
            } else {
                System.out.println("输入的图书编号错误！");
            }
        }
    }

    public static void init() {
        Books goods1 = new Books(101, "Java基础入门", 44.50, 100, 4450.00, "清华大学出版社");
        Books goods2 = new Books(102, "Java编程思想", 108.00, 50, 5400.00, "机械工业出版社");
        Books goods3 = new Books(103, "疯狂Java讲义", 99.00, 100, 9900.00, "电子工业出版社");
        booksList.add(goods1);
        booksList.add(goods2);
        booksList.add(goods3);
    }

    public static Books getBooksById(int bookId) {
        for (int i = 0; i < booksList.size(); i++) {
            Books thisBooks = booksList.get(i);
            if (bookId == thisBooks.id) {
                return thisBooks;
            }
        }
        return null;
    }

}
