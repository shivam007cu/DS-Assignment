import java.util.*;
class QueueUsingStacks{

   static Stack<Integer> s1 = new Stack<Integer>();
   static Stack<Integer> s2 = new Stack<Integer>();

    static void enqueue(int x){

       while(!s1.isEmpty()){
           s2.push(s1.pop());
       } 
       s1.push(x);  
    
       while(!s2.isEmpty()){
           s1.push(s2.pop());
       }
     }

     static int dequeue(){
         if(s1.isEmpty()){
             System.out.println("Queue is empty");
             return 0;
         }
         int k = s1.peek();
         s1.pop();
         return k;
     }

    public static void main(String []args){
        QueueUsingStacks s = new QueueUsingStacks();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(4);
        s.enqueue(5);
        s.enqueue(6);
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        
    }
}