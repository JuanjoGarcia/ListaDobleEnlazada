public class ListaDobleEnlazada {
	 
	class Node {
	    int data;
	    Node next;
	    Node prev;
	    Node(int numeroDato){
	        this.data = numeroDato;
	        this.next = null;
	        this.prev = null;
	    }
	}
	
	Node first;
    Node last;
    
    ListaDobleEnlazada(){
        first = null;
        last = null;
    }
    
	public boolean isEmpty(){
		if(first == null) return true;
	        else 		return false;
	}
	
	public void insertEnd(int dato){
		if(isEmpty()){
			Node newNode = new Node(dato);
			first = newNode;
			last = newNode;
		} else {
			Node newNode = new Node(dato);
	     	last.next = newNode;
	     	newNode.prev = last;
	     	last = newNode;
		}
	       
	 }
	
	public boolean deleteData(int num)
	    {
	        Node previous = null;
	        Node current = first;
	        while(current != last){
	            if(current.data == num){
	                if(previous == null){
	                    first = current.next;
	                    first.prev = null;
	                }else{
	                    previous.next = current.next;
	                    Node temp;
	                    temp = current.next;
	                    temp.prev = previous;
	                }
	                return true;
	            }
	            previous = current;
	            current = current.next;
	        }
	        
	        if(num == last.data){
	            last=current.prev;
	            return true;
	        }
	        
	        return false;
	    }
	 public void insertPreviously(int number,Node prevNode){
		 Node newNode = new Node(number);
		 newNode.prev = prevNode.prev;
		 newNode.next = prevNode;
		 if(prevNode.prev == null){
			 first = newNode;
		 } else {
			 prevNode.prev.next = newNode;
			 prevNode.prev = newNode;
		 }

	 }
	 public void insertSubsequently(int number,Node prevNode){
		 Node newNode = new Node(number);
		 newNode.prev = prevNode;
		 newNode.next = prevNode.next;
		 if(prevNode.next == null){
			 last = newNode;
		 } else {
			 prevNode.next.prev = newNode;
			 prevNode.next = newNode;
		 }
	 }
	 
	 public void insertBeginning(int number){
		 Node newNode=new Node(number);
		 if(isEmpty()){
			 first = newNode;
			 last = newNode;
		 } else {
			 insertPreviously(number,first);
		 }
	 }
	 
	 
}