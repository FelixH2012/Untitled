package untitled.event.system;

public interface EventListener<T> {
    void call(T event);
}