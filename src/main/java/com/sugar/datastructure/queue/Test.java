package com.sugar.datastructure.queue;

import java.util.Scanner;

/**
 * @author KyleTan
 */
public class Test {

    public static void main(String[] args){

        System.out.println("测试环形队列的案列");
        CircleArrayQueue queue = new CircleArrayQueue(3);
        char key;
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s:(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):得到数据");
            System.out.println("h(head):查看头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int next = scanner.nextInt();
                    try {
                        queue.addQueue(next);
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    int queues = queue.getQueue();
                    System.out.printf("取出的数据是%d\n",queues);
                    break;
                case 'h':
                    int i = queue.headQueue();
                    System.out.printf("取出的数据是%d\n",i);
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
