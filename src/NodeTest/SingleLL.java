package NodeTest;

public class SingleLL {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;

    public void addNode(int value){

        if (this.head == null) this.head = new Node(value);

        else {
            Node currNode = this.head;

            while(currNode != null){
                if (currNode.next == null) {
                    currNode.next = new Node(value);
                    break;
                }

                currNode = currNode.next;
            }

        }

    }

    public void printList(){
        Node currNode = this.head;

        while (currNode != null){
            if(currNode.next != null){
                System.out.print(currNode.data + "->");
            } else {
                System.out.print(currNode.data);
            }
            currNode = currNode.next;
        }
    }

    public void reverseList(){
        Node previous = null;
        Node next = null;
        Node currNode = this.head;

        while (currNode != null){
            next = currNode.next;
            currNode.next = previous;
            previous = currNode;
            currNode = next;
        }
        this.head = previous;
    }



}
