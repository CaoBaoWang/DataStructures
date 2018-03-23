package com.hyd.smart.mylibrary.D5Link.homework;

/**
 * 5.1
 * Created by Administrator on 2018/3/22.
 */

public class PriorityQueue {
    SortedListMe   sortedList;
    public PriorityQueue(){
        sortedList=new SortedListMe();
    }
    public void insert(long data){
        sortedList.insert(new Link(data));
    }

    public  Link deleteMini(){
        return  sortedList.deleteMini();
    }
    public void display(){
        sortedList.disolayLink();
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

class SortedListMe{
    private Link first;            // ref to first item on list

    // -------------------------------------------------------------
    public SortedListMe()            // constructor (no args)
    {
        first = null;
    }                    // initialize list

    // -------------------------------------------------------------
    public SortedListMe(Link[] linkArr)  // constructor (array
    {                               // as argument)
        first = null;                        // initialize list
        for (int j = 0; j < linkArr.length; j++)  // copy array
            insert(linkArr[j]);             // to list
    }

    // -------------------------------------------------------------
    public void insert(Link k)     // insert (in order)
    {
        Link previous = null;            // start at first
        Link current = first;
        // until end of list,
        while (current != null && k.dData > current.dData) {                             // or key > current,
            previous = current;
            current = current.next;       // go to next item
        }
        if (previous == null)               // at beginning of list
            first = k;                    // first --> k
        else                             // not at beginning
            previous.next = k;            // old prev --> k
        k.next = current;                // k --> old currnt
    }  // end insert()

    public Link deleteMini(){
        Link mini = first;
        first=first.next;
        return  mini;
    }

    void disolayLink (){
        Link c = first;
        while (c!=null){
            c.displayLink();
            c=c.next;
        }
    }
}
