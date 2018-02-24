package com.hyd.smart.mylibrary.D2;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public OrdArray(int max)          // constructor
    {
        a = new long[max];             // create array
        nElems = 0;
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }

    /**
     * 2.4 使用二分查找
     *
     * @param key
     * @return key的角标 或 -1
     */
    public int findIndexByBinary(long key) {
        int start = 0;
        int end = nElems - 1;
        int findIndex;
        while (true) {
            findIndex = (start + end) / 2;
            if (a[findIndex] == key) return findIndex;
            else if (end > start) {
                System.out.println("can't find  " + key + " in a  a.length=" + a.length);
                return -1;
            } else {
                if (a[findIndex] > key) {
                    end = findIndex - 1;
                } else {
                    start = findIndex + 1;
                }

            }
        }
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;              // found it
            else if (lowerBound > upperBound)
                return nElems;             // can't find it
            else                          // divide range
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
        }  // end while
    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        int j;
        for (j = 0; j < nElems; j++)        // find where it goes
            if (a[j] > value)            // (linear search)
                break;
        for (int k = nElems; k > j; k--)    // move bigger ones up
            a[k] = a[k - 1];
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }  // end insert()

    /**
     * 2.4insert
     * @param value
     */
    public void insertBinary(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
//            if (a[curIn] == value){   // 取消注释则 重复数据不允许插入
//                System.out.println("insert value already existed ");
//                break;
//                //                return curIn;              // found it
//            } else
                if (lowerBound > upperBound){
               for(int k =nElems;k>curIn;k--)
                   a[k]=a[k-1];
                   a[lowerBound]=value;
                   nElems++;
                   break;
            } else {                         // divide range
                if (a[curIn] < value)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
        }  // end while
    }

    //-----------------------------------------------------------

    /**
     * 2.4 delete()已经是二分查找
     * @param value
     * @return
     */
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for (int k = j; k < nElems; k++) // move bigger ones down
                a[k] = a[k + 1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
//    public boolean deleteBinary(long value){
//
//    }

    /**
     * 2.5 合并两个有序数组
     * @param mergeArr1
     * @param mergeArr2
     * @return
     */
    public OrdArray  merge(OrdArray mergeArr1,OrdArray mergeArr2){
        for(int i=0;i<mergeArr2.size();i++){
            mergeArr1.insertBinary(mergeArr2.a[i]);
        }
        return  mergeArr1;
    }


    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------
}  // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;             // array size
        OrdArray arr;                  // reference to array
        arr = new OrdArray(maxSize);   // create the array

        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;            // search for item
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();                 // display items

        arr.delete(00);                // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                 // display items again

        /**
         * 2.4 inser delete use Binary
         */
        arr.insertBinary(40);

        arr.insertBinary(20);
        arr.insertBinary(99);
        arr.insertBinary(1);
        arr.insertBinary(21);
        arr.insertBinary(90);
        arr.insertBinary(100);

//        arr.insertBinary(1);
        arr.display();

        /**
         * 2.5 merge two order array  to get an order array
         */
        OrdArray arr2=new OrdArray(100);
        arr2.insertBinary(3);
        arr2.insertBinary(5);
        arr2.insertBinary(4);
        arr2.insertBinary(6);
        arr2.insertBinary(1);
        arr2.insertBinary(2);
        arr.insertBinary(99);
        arr.insertBinary(90);
        arr2.insertBinary(4);

        arr2.display();
        OrdArray merge = arr.merge(arr, arr2);
        merge.display();


    }  // end main()
}  // end class OrderedApp
