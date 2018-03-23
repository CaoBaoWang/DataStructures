package com.hyd.smart.mylibrary.D5Link;

import com.hyd.smart.mylibrary.D5Link.doublyLink.DoubleyQueue;
import com.hyd.smart.mylibrary.D5Link.homework.CircleLinkList5_3;
import com.hyd.smart.mylibrary.D5Link.homework.PriorityQueue;

/**
 * 5.2
 * Created by Administrator on 2018/3/23.
 */

public class Test {

    public static  void  main(String [] ars){
        test5_3();

    }

    public static void test5_1(){
        PriorityQueue pq=new PriorityQueue();
        pq.insert(75);
        pq.insert(15);
        pq.insert(35);
        pq.insert(15);
        pq.insert(5);
        pq.display();

        pq.deleteMini();
        System.out.println();
        pq.display();
    }
    public static void test5_2(){
        DoubleyQueue pq=new DoubleyQueue();
        pq.insertLeft(75);
        pq.insertLeft(15);
        pq.insertLeft(35);
        pq.inserRight(5);
        pq.removeLeft();
        pq.display();
        pq.removeRight();
        pq.display();
    }

    public static void test5_3(){
        CircleLinkList5_3 c=new CircleLinkList5_3();
        c.insert(12);
        c.insert(13);
        c.insert(14);
        c.insert(15);
        c.insert(16);
        c.display();

    }
}
