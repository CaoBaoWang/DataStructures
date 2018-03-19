package com.hyd.smart.mylibrary.D3EasySort;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
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
    public void insertionSort() {
        count = 0;

        int in, out;

        for (out = 1; out < nElems; out++)     // out is dividing line
        {
            count++;

            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            while (in > 0 && a[in - 1] >= temp) // until one is smaller,
            {
                count++;

                a[in] = a[in - 1];            // shift item to right
                --in;                       // go left one position
            }
            a[in] = temp;                  // insert marked item
        }  // end for
    }  // end insertionSort()

    int count = 0;

    public void insertSortMe() {
        long temp;
        int i, j;
        for (i = 1; i < nElems; i++) {
            temp = a[i];
            for (j = i; j > 0 && temp <= a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    /**
     * 3.2
     */
    public long median() {

        return a[nElems / 2];
    }

    /**
     * 3.3
     */
    public void noDups() {
        int i = 0;
        int j = 0;
        int k=0;
        int dupsCount =0;
        while (true) {
            if (j == nElems) {
                nElems-=dupsCount;
                break;
            }
            j++;

            if (a[k] < a[j]) {
                a[i + 1] = a[j];
                i ++;
                k=j;
                continue;
            }else if(a[k]==a[j]){
                dupsCount++;
            }
        }
        System.out.println("dupsCount="+dupsCount);
    }

//--------------------------------------------------------------
}  // end class ArrayIns

////////////////////////////////////////////////////////////////
class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

//      arr.insertionSort();          // insertion-sort them
        arr.insertSortMe();
        arr.display();                // display them again
        arr.noDups();
        arr.display();
    }  // end main()
}  // end class InsertSortApp
