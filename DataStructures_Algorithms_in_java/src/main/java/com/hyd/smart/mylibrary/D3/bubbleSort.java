package com.hyd.smart.mylibrary.D3;

import java.text.SimpleDateFormat;
import java.util.Date;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("count=" + count);
    }

    //--------------------------------------------------------------
    int count = 0;

    public void bubbleSort() {
        int out, in;
        count = 0;
        for (out = nElems - 1; out > 1; out--) {
            count++;
            // outer loop (backward)
            for (in = 0; in < out; in++) {
                count++;
                // inner loop (forward)
                if (a[in] > a[in + 1])       // out of order?
                    swap(in, in + 1);
            }
        }
    }  // end bubbleSort()

    public void bubbleSortMe() {
        count = 0;
        for (int i = 0; i < nElems - 1; i++) {
            count++;
            for (int j = 0; j < nElems - 1 - i; j++) {
                count++;
                if (a[j] > a[j + 1]) {
                    long temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }
        }
    }

    /**
     * 奇偶排序
     */
    public void oddEvenSort(){

        while (true){
            int count =0;
            for(int j =1 ;j<nElems-1;j+=2){
//                if(j+1>nElems-1) break;
                if(a[j]>a[j+1]){
                    long temp= a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    count++;
                }
            }
            for(int i=0;i<nElems;i+=2){
                if(a[i]>a[i+1]){
                    long temp =a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    count++;
                }
            }
            if(count==0)break;

        }



    }

    /**
     * 课后编程3.1
     */
    public void bubbleSortBothwayMe() {
        count = 0;
        int leftIndex = 0;
        int rightIndex = nElems - 1;
        while (leftIndex<rightIndex) {
            for (int i = leftIndex; i < rightIndex; i++) {
                if (a[i] > a[i + 1]) {
                    long temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            rightIndex--;
            for (int j = rightIndex; j > leftIndex; j--) {
                if (a[j] < a[j - 1]) {
                    long temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                }
            }
            leftIndex++;
        }

    }

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 10000;            // array size
        ArrayBub arr;                 // reference to array

        arr = new ArrayBub(maxSize);  // create the array
//        for(int j =0;j<maxSize;j++){
//            long n=(long)(Math.random()*(maxSize-1));
//            arr.insert(n);
//        }

        for (int i = maxSize - 1; i >= 0; i--) {
            arr.insert(i);
        }
//        arr.insert(77);               // insert 10 items
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
        arr.display();
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//        arr.bubbleSortMe();
//        arr.bubbleSortBothwayMe();
        arr.oddEvenSort();

//        arr.bubbleSort();             // bubble sort them
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        arr.display();                // display them again
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
