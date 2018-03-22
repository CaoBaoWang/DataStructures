package com.hyd.smart.mylibrary.D5Link.homework;

import java.util.LinkedHashSet;

/**
 * Created by Administrator on 2018/3/22.
 */

public class PriorityQueue {
    private Link first;
    LinkedHashSet   l=new LinkedHashSet();

    public  Link getFirst(){
        return  first;
    }


}
class Link {
    public long dData;                 // data item
    public Link next;                  // next link in list

    // -------------------------------------------------------------
    public Link(long d)                // constructor
    {
        dData = d;
    }

    // -------------------------------------------------------------
    public void displayLink()          // display this link
    {
        System.out.print(dData + " ");
    }
}