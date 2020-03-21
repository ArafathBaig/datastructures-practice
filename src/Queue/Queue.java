package Queue;

public class Queue {
  private int size;
  private long[] queueArray;
  private int front;
  private int rear;
  private int nItems;

  public Queue(int size){
    this.size = size;
    queueArray = new long[size];
    this.front = 0;
    this.rear = -1;
    nItems = 0;
  }

  public void enqueue(long data){
    if(rear==size-1 && front == size-1){
      front = 0;
      queueArray[front] = queueArray[rear];
      rear=0;

    }
    if(front == 0 && rear == size-1){
      System.out.println("Stack Overflow");
    }
    rear++;
    queueArray[rear]=data;
    nItems++;
  }

  public long dequeue(){
    if(front==size-1){
      return 0;
    }
    long temp = queueArray[front];
    front++;
    return temp;
  }

  public void display(){
    System.out.print("[");
    for(int i=front;i<=rear;i++){
      System.out.print(queueArray[i]+",");
    }
    System.out.println("]");
  }

}
