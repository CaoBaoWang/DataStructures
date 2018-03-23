package com.hyd.smart.mylibrary.D5Link.homework;

/**
 * Created by Administrator on 2018/3/23.
 */

public class CircleLinkList5_3 {
    Link current;

    public CircleLinkList5_3() {

    }

    public void  insert(long l){
        Link link=new Link(l);

        if(isEmpty()){
            current = link;
            current.next = link;
        }else{
            link.next = current.next;
            current.next = link;
            current = link;
        }
    }
    public void display (){
        Link temp = current;
        while (true){

            System.out.print(current.dData);
            System.out.print(" ");
            current=current.next;
            if(current==temp){
                break;
            }
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return current == null ;
    }

}


