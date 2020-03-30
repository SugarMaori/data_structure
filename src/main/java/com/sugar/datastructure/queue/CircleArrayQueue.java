package com.sugar.datastructure.queue;

/**
 *  数组模拟环形队列
 * @author KyleTan
 */
public class CircleArrayQueue {

    /**
     *  队列输出下标
     * */
    private int front;

    /**
     *  队列输入下标
     *  预留一个位置作为约定！不放入元素！
     * */
    private int rear;

    /**
     *  队列容量大小
     * */
    private int[] arr;

    /**
     *  设置队列的容量
     * */
    public CircleArrayQueue(int initialCapacity){
        this.arr = new int[initialCapacity];
    }


    /**
     *  判断队列是否已满
     *  front = 0
     *  rear = 2
     *  arr = 3
     *  队列输入下标 + 预留的位置 % 磨掉队列最大容量  在判断是否等于  队列输出下标 ? 队列已满 ：队列未满
     *  公式：(2 + 1) % 3 == 0
     * */
    public boolean isFull(){
        return ( rear + 1 ) % arr.length == front;
    }

    /**
     *  判断队列是否为空
     * */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     *  往队列中输入值
     * */
    public void addQueue(int value){
        if(isFull()){
            throw new RuntimeException("队列的容量已满");
        }
        arr[rear] = value;
        // 此处必须取模 否则会抛数组越界异常；取模是为了循环利用数组
        rear = ( rear + 1 ) % arr.length;
    }

    /**
     *  往队列中输出值
     * */
    public int getQueue(){
        if(isEmpty()){
            throw  new  RuntimeException("队列中没有数据");
        }
        // 出队列，按照队列的先进先出原则，对头先出，front 的值也会递增
        // 所以需定义一个临时变量存放 front 没有递增前的值
        int val = front;
        // 原理同 入队列一样
        front = ( front + 1 ) % arr.length;
        return arr[val];
    }


    /***
     *  显示队列头数据
     * */
    public int headQueue(){
        return arr[front];
    }

    /**
     *  显示队列中的数据
     * */
    public void showQueue(){
        for(int i = front; i < front + size(); i++){
            System.out.printf("arr[%d]=%d\n" , i % arr.length , arr[i % arr.length]);
        }
    }

    /**
     *  队列中有效值
     * */
    public int size(){
        return ( rear + arr.length - front ) % arr.length;
    }


}
