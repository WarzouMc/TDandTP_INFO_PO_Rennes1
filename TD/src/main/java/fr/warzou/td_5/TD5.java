package fr.warzou.td_5;

public class TD5 {

    public static void main(String[] args) {
        BiLinkedList<Integer> linkedList = new BiLinkedList<>();
        linkedList.insertInHead(1);
        linkedList.insertInEnd(3);
        linkedList.insertInHead(2);
        linkedList.insertBefore(3, 5);
        linkedList.insertNext(3, 8);
        linkedList.insertNext(3, 9);
        linkedList.insertInEnd(6);
        linkedList.insertInHead(0);
        linkedList.remove(3);

        System.out.println(linkedList.toPrettyString());
    }

}
