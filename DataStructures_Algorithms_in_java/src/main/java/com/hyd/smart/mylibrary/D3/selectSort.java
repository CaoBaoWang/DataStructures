package com.hyd.smart.mylibrary.D3;

import java.text.SimpleDateFormat;
import java.util.Date;

// selectSort.java
// demonstrates selection sort
// to run this program: C>java SelectSortApp
////////////////////////////////////////////////////////////////
class ArraySel
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArraySel(int max)          // constructor
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
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("count="+count);
      }
      int count;
//--------------------------------------------------------------
   public void selectionSort()
      {
         count=0;
      int out, in, min;

      for(out=0; out<nElems-1; out++)   // outer loop
         {
            count++;
         min = out;                     // minimum
         for(in=out+1; in<nElems; in++){
            count++;
            if(a[in] < a[min] )         // if min greater,
               min = in;
         }
         swap(out, min);
         }  // end for(out)
      }  // end selectionSort()

      public void selectSortMe(){
         int min ;
         count=0;
         for(int i=0;i<nElems-1;i++){
            count++;
            min=i;
            for(int j =i+1;j<nElems;j++){
               count++;

               if(a[min]>a[j]){
                  min=j;
               }
            }
            long temp = a[i];
            a[i]=a[min];
            a[min]=temp;

         }
      }
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class ArraySel
////////////////////////////////////////////////////////////////
class SelectSortApp
   {
   public static void main(String[] args)
      {
         int maxSize = 10000;            // array size
         ArraySel arr;                 // reference to array

         arr = new ArraySel(maxSize);  // create the array
//         for(int j =0;j<maxSize;j++){
//            long n=(long)(Math.random()*(maxSize-1));
//            arr.insert(n);
//         }
         for (int i=maxSize-1;i>=0;i--){
            arr.insert(i);
         }
//      arr.insert(77);               // insert 10 items
//      arr.insert(99);
//      arr.insert(44);
//      arr.insert(55);
//      arr.insert(22);
//      arr.insert(88);
//      arr.insert(11);
//      arr.insert(00);
//      arr.insert(66);
//      arr.insert(33);

         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
         arr.display();
         System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
         arr.selectionSort();          // selection-sort them
         System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
         arr.display();                // display them again
//      arr.selectSortMe();
      }  // end main()
   }  // end class SelectSortApp
////////////////////////////////////////////////////////////////
