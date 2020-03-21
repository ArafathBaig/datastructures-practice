package Stack;

public class Stack {
  private int []stack;
  private int size;
  private int top;

  public Stack(int size){
    this.size = size;
    this.stack = new int[size];
    this.top= -1;
  }

  public void push(int data){
    if(isFull()){
      System.out.println ("Stack overflow.. " );
      return;
    }

    top++;
    stack[top] = data;
  }

  public int pop(){
    if(isEmpty()){
      System.out.println ("Stack is Empty" );
      return -1;
    }
    int temp = stack[top];
    top--;
    if(top<-1){
      top = -1;
    }
    return temp;
  }

  public void display(){
    for(int i = 0; i<=top;i++){
      System.out.println (stack[i]+" ");
    }
  }

  private boolean isFull(){
    return top == stack.length-1;
  }

  private boolean isEmpty(){
    return top == -1 || top == 0;
  }
}
