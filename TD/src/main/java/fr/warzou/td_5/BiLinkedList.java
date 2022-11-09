package fr.warzou.td_5;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BiLinkedList<E> implements Iterable<E> {

    private @Nullable Node<E> head;
    private @Nullable Node<E> end;

    public BiLinkedList() {
        this.head = null;
        this.end = null;
    }

    public int size() {
        if (this.head == null)
            return 0;
        int count = 0;
        Node<E> node = this.head;
        while ((node = node.next) != null) count++;
        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertInHead(E element) {
        if (this.head == null) {
            this.head = new Node<>(element);
            this.end = this.head;
        }

        this.head.previous = new Node<>(element, null, this.head, true, false);;
        this.head.head = false;
        this.head = this.head.previous;
    }

    public void insertInEnd(E element) {
        if (this.head == null) {
            this.head = new Node<>(element);
            this.end = this.head;
            return;
        }

        if (this.head.equals(this.end)) {
            this.end = new Node<>(element, this.head, null, false, true);
            return;
        }

        assert this.end != null;
        this.end.next = new Node<>(element, null, this.end, false, true);
        this.end.end = false;
        this.end = this.end.next;
    }

    public void insertNext(E who, E element) {
        int index = indexOf(who);
        if (this.head == null || index == -1)
            throw new NoSuchElementException();

        if (index + 1 >= size())
            insertInEnd(element);
        this.head.insertElementAtIndex(element, index + 1);
    }

    public void insertBefore(E who, E element) {
        int index = indexOf(who);
        if (this.head == null || index == -1)
            throw new NoSuchElementException();

        if (index == 0)
            insertInHead(element);
        this.head.insertElementAtIndex(element, index);
    }

    public void remove(E element) {
        int index = indexOf(element);
        if (this.head == null || index == -1)
            throw new NoSuchElementException();

        assert this.end != null;

        if (index == 0) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.previous = null;
                this.head.head = true;
            }
            return;
        }

        if (index == size() - 1) {
            this.end = this.end.previous;
            if (this.end != null) {
                this.end.next = null;
                this.end.end = true;
            }
            return;
        }

        this.head.remove(index);
    }

    public int indexOf(E element) {
        int count = 0;
        Node<E> node = this.head;
        if (node == null)
            return -1;

        while ((node = node.next) != null) {
            if (node.element.equals(element))
                return count;
            count++;
        }

        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;//todo
    }

    @Override
    public String toString() {
        return "BiLinkedList{" +
                "head=" + head +
                ", end=" + end +
                '}';
    }

    private static class Node<T> {
        private T element;
        private @Nullable Node<T> next;
        private @Nullable Node<T> previous;
        private boolean head;
        private boolean end;

        private Node(T element) {
            this(element, null, null, true, true);
        }

        private Node(T element, @Nullable Node<T> next, @Nullable Node<T> previous, boolean head, boolean end) {
            this.element = element;
            this.next = next;
            this.previous = previous;
            this.head = head;
            this.end = end;
        }

        private void insertElementAtIndex(T element, int index) {
            if (index == 0)
                insertElement(element);
            else if (this.end || this.next == null)
                insertElement(element);
            else this.next.insertElementAtIndex(element, index - 1);
        }

        private void insertElement(T element) {
            T oldElement = this.element;
            this.element = element;
            Node<T> oldNext = this.next;
            this.next = new Node<>(oldElement, oldNext, this, false, this.end);
            this.end = false;
        }

        private void remove(int index) {
            index = Math.abs(index);
            if (index == 0)
                removeElement(element);
            else if (this.next == null)
                throw new ArrayIndexOutOfBoundsException();
            else this.next.remove(index - 1);
        }

        private void removeElement(T element) {
            if (this.previous == null)
                return;
            this.previous.next = this.next;
        }

        public T getElement() {
            return this.element;
        }

        public @Nullable Node<T> getNext() {
            return this.next;
        }

        public @Nullable Node<T> getPrevious() {
            return this.previous;
        }

        public void setNext(@Nullable Node<T> next) {
            this.next = next;
        }

        public void setPrevious(@Nullable Node<T> previous) {
            this.previous = previous;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node<?> node)) return false;

            if (head != node.head) return false;
            if (end != node.end) return false;
            if (!Objects.equals(element, node.element)) return false;
            if (!Objects.equals(next, node.next)) return false;
            return Objects.equals(previous, node.previous);
        }

        @Override
        public int hashCode() {
            int result = element != null ? element.hashCode() : 0;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            result = 31 * result + (previous != null ? previous.hashCode() : 0);
            result = 31 * result + (head ? 1 : 0);
            result = 31 * result + (end ? 1 : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    ", previous=" + previous +
                    ", head=" + head +
                    ", end=" + end +
                    '}';
        }
    }

    private static class Itr<T> implements Iterator<T> {

        private Node<T> node;

        private Itr(Node<T> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return this.node == null || this.node.next == null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            this.node = this.node.next;
            assert this.node != null;
            return this.node.element;
        }
    }
}
