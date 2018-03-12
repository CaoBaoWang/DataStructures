package com.hyd.smart.mylibrary.D4.Quene;

// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }

    public void display(){
      int i = rear;
      while (true){
         long l= peekFront();
         System.out.print(peekFront()+" ");
         remove();
         if(l==queArray[i])break;
      }
      System.out.println();

    }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // end class Queue

class Deque{
   private int maxSize;
   private long[] dequeArray;
   private int front;
   private int rear;
   private int nItems;

   public Deque(int maxSize){
      this.maxSize=maxSize;
      dequeArray=new long[maxSize];
      front=1;
      rear=0;
      nItems=0;
   }


   public void insertLeft(long i){
      if(front==0){
         front=maxSize;
      }
      dequeArray[--front]=i;

      nItems++;
   }
   public void insertRight(long i){
      if(rear==maxSize-1){
         rear=-1;
      }
      dequeArray[++rear]=i;
      nItems++;

   }
   public long  removeLeft(){
      long temp = dequeArray[front++];
      if(front==maxSize){
         front=0;
      }
      nItems--;
      return  temp;
   }
   public long removeRight(){
      long temp = dequeArray[rear--];
      if(rear==-1){
         rear=maxSize-1;
      }

      nItems--;

      return temp;
   }
   public boolean isFull(){
      return  nItems==maxSize;
   }
   public boolean isEmpty(){
      return  nItems ==0;
   }

   public void display(){

      int i = front;
      while (true){
         System.out.print(dequeArray[i]+" ");
         if(i==rear)break;
         i ++;
         if(i==maxSize) i=0;

      }
      System.out.println();
   }
   public void displayArr(){
      for(long i:dequeArray)
         System.out.print(i+" ");
         System.out.println();

   }
}


////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);

      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
         theQueue.display();
         theQueue.display();
         Deque deque=new Deque(4);
         deque.insertLeft(10);
         deque.insertRight(20);
         deque.insertRight(30);
         deque.insertLeft(40);
//         deque.displayArr();
         deque.display();
         deque.removeLeft();
         deque.removeRight();
         deque.display();
         deque.insertRight(30);
         deque.insertRight(40);
         deque.display();
         deque.removeRight();
         deque.removeRight();
         deque.removeRight();
         deque.display();
      }  // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
