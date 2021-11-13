package stack;

import java.util.LinkedList;
import istackable.IStackable;

public class LinkedStack implements IStackable {


public LinkedList stack = new LinkedList(); 



public int size (){

	System.out.format("Stack size:%d\n",this.stack.size());
	return this.stack.size();
}

public void push(int v){

	this.stack.add(v);
};


public int pop (){
	int a =(this.stack.size());
	this.stack.remove(stack.size() - 1);

	return a;
};

};
