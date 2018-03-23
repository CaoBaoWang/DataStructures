package com.hyd.smart.mylibrary.D4StackQueue;

// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
class StackX
   {
   private int maxSize;        // size of stack array
   private long[] stackArray;
   private int top;            // top of stack
//--------------------------------------------------------------
   public StackX(int s)         // constructor
      {
      maxSize = s;             // set array size
      stackArray = new long[maxSize];  // create array
      top = -1;                // no items yet
      }
//--------------------------------------------------------------
   public void push(long j)    // put item on top of stack
      {
      stackArray[++top] = j;     // increment top, insert item
      }
//--------------------------------------------------------------
   public long pop()           // take item from top of stack
      {
      return stackArray[top--];  // access item, decrement top
      }
//--------------------------------------------------------------
   public long peek()          // peek at top of stack
      {
      return stackArray[top];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      {
      return (top == maxSize-1);
      }
//--------------------------------------------------------------
   }  // end class StackX
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


   public void push(long i){
      if(front==0){
         front=maxSize;
      }
      dequeArray[--front]=i;

      nItems++;
   }
   private void insertRight(long i){
      if(rear==maxSize-1){
         rear=-1;
      }
      dequeArray[++rear]=i;
      nItems++;

   }
   public long pop(){
      long temp = dequeArray[front++];
      if(front==maxSize){
         front=0;
      }
      nItems--;
      return  temp;
   }
   public long peek(){
      return  dequeArray[front];
   }
   private long removeRight(){
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
class StackApp
   {
   public static void main(String[] args)
      {
      StackX theStack = new StackX(10);  // make new stack
      theStack.push(20);               // push items onto stack
      theStack.push(40);
      theStack.push(60);
      theStack.push(80);

      while( !theStack.isEmpty() )     // until it's empty,
         {                             // delete item from stack
         long value = theStack.pop();
         System.out.print(value);      // display it
         System.out.print(" ");
         }  // end while
      System.out.println("");

      Deque task=new Deque(10);
         task.push(20);               // push items onto stack
         task.push(30);               // push items onto stack
         task.push(40);               // push items onto stack
         task.push(50);               // push items onto stack
         System.out.println(task.peek());
         while (!task.isEmpty()){
            long l = task.pop();
            System.out.print(l+" ");
         }
         System.out.println();
      }  // end main()
   }  // end class StackApp
////////////////////////////////////////////////////////////////
