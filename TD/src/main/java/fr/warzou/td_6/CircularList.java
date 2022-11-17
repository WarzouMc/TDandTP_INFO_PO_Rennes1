package fr.warzou.td_6;

import org.jetbrains.annotations.NotNull;

public class CircularList<T> {

    private Element<T> head;

    public CircularList() {
        this.head = null;
    }

    private static class Element<E> {
        private final E value;
        private final @NotNull Element<E> next;

        private Element(E value, @NotNull Element<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
