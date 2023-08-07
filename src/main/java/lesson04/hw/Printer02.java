package lesson04.hw;

import java.util.LinkedList;

public class Printer02 {
    public static void main(String[] args) {
        MyQueue<Integer> queue;
        queue = new MyQueue<>();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}

class MyQueue<T> {
    private LinkedList<T> elements;

    public MyQueue() {
        elements = new LinkedList<>();
    }

    public void enqueue(T element) {
        elements.add(element);
    }

    public T dequeue() {
        return elements.removeFirst();
    }

    public T first() {
        return elements.getFirst();
    }

    public LinkedList<T> getElements() {
        return elements;
    }
}