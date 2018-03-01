package com.hyd.smart.mylibrary.D2;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) {                              // find specified value
        int j;
        for (j = 0; j < nElems; j++)            // for each element,
            if (a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if (j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)        // look for it
            if (value == a[j])
                break;
        if (j == nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()

    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    /**
     * 2.1
     *假设item 都是正数
     * @return long [] a  中 max item
     */
    public long getMax(){
        long max =0;
        if(a==null || a.length==0) return -1;
//        for (long b : a){
//            if(max<b){
//                max=b;
//            }
//        }
        for (int i=0;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
        }
        return  max;
    }

    /**
     * 2.2
     * @return  remove item's index in long [] a
     */
    public boolean removeMax(){

       long max = getMax();
       if(max!=-1){
           int maxIndex = findIndex(max);
           for(int i=maxIndex;i<nElems;i++){
               a[i]=a[(i+1)];
           }
           nElems--;
           return  true;
       }
        return  false;
    }

    public int size(){
        return nElems;
    }

    /**
     *
     * @param key
     * @return  key's index in a    if don't found  retrun  -1
     */
    public int findIndex(long key){
        int index =-1;
      for (int i=0;i<nElems;i++){
          if(a[i]==key){
              index=  i;
              break;
          }
      }
        return  index;
    }

    /**
     * 2.6 数据去重
     * -1 可以是null 或 数据中不能会出现的 的数字
     */
    public void noDup(){
        for (int i=0;i< nElems;i++){
            for (int j=i+1;j<nElems;j++){
                if(a[i]==a[j]){
                    a[j]=-1;
                }
            }
        }
        display();
        for(int i=0;i<nElems;i++){
            if(a[i]==-1){
                for(int j=i;j<nElems;j++){
                    a[j]=a[j+1];
                    if(j==nElems-2 && a[j]==-1){
                        i--;
                    }
                }
                nElems--;
            }

        }

    }



    //-----------------------------------------------------------
}  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(22);
        arr.insert(5);               // insert 10 items
        arr.insert(99);
        arr.insert(22);
        arr.insert(22);
        arr.insert(10);
        arr.insert(99);
        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(22);
        arr.insert(99);
        arr.insert(99);
        arr.insert(99);
        arr.insert(77);               // insert 10 items
        arr.insert(77);               // insert 10 items


        arr.display();                // display items
        arr.noDup();
        System.out.print("noDup display");
        arr.display();

        int searchKey = 35;           // search for item
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);               // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                // display items again


        /**
         * 2.2
         */
        arr.removeMax();
        arr.display();                // display items again
        HighArray arrBackups=arr;

        /**
         * 2.3
         */
        long[]  arr1=new long [100];
        int arrElems= arr.size();
        for(int i=0;i<arrElems;i++){
            arr1[i]=arr.getMax();
            arr.removeMax();
        }
        for (long a : arr1){
            System.out.print(a+",");//由于arr1长度是100 没赋值的默认值是0
        }
        arrBackups.display();                // display items again

    }  // end main()
}  // end class HighArrayApp
