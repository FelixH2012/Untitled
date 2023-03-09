package java.untitled.event;

public interface EventListener<T> {
    void call(T event);
}