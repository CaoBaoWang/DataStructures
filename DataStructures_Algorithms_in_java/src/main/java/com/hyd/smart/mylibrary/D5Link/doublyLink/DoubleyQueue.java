package com.hyd.smart.mylibrary.D5Link.doublyLink;


/**
 * 5.2
 * Created by Administrator on 2018/3/23.
 */

public class DoubleyQueue {
    DoublyLinkedList firstLastList ;

    public DoubleyQueue(){
        firstLastList=new DoublyLinkedList();
    }

    public void insertLeft(long l){

        firstLastList.insertFirst(l);
    }
    public void inserRight(long l){
        firstLastList.insertLast(l);

    }
    public Link removeLeft(){
        return firstLastList.deleteFirst();
    }
    public Link removeRight(){
        return firstLastList.deleteLast();

    }
    public void display(){
        firstLastList.displayForward();
    }


}
