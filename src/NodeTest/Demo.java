package NodeTest;

public class Demo {
    public static void main(String[] args) {
        SingleLL ll = new SingleLL();

        ll.addNode(1);
        ll.addNode(2);
        ll.addNode(3);
        ll.addNode(4);
        ll.printList();
        ll.reverseList();
        System.out.println();
        ll.printList();

    }
}
