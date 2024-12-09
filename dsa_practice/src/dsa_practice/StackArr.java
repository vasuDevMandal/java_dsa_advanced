package dsa_practice;

class Stack2{
	int n = 10;
    int top = -1;
    int[] a = new int[n];  
    void push(int val){
        if(top == (n-1)){
            System.out.println("overflow");
        }else{
            top = top + 1;
            a[top] = val;
            System.out.println("inserted: " + a[top]);
        }
    }

    void pop(){
        if(top == -1) {
        	System.out.println("underflow");
        }else {
        	top = top -1;
        	System.out.println("deleted: " + a[top]);
        }
    }
    
    void display() {
    	System.out.print("\ntop");
    	for(int i = 0; i <= top; i++) {
    		System.out.print( "->" + a[i] );
    	}
    }
}


public class StackArr {
	
	public static void main(String[] args) {
		
		Stack2 stack = new Stack2();
		stack.push(10);stack.display();
		stack.push(20);stack.display();
		stack.push(30);stack.display();
		
		stack.pop();
		
		stack.display();

			
		
		
	}
}
