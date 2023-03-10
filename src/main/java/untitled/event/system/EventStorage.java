package untitled.event.system;

public record EventStorage<T>(Object owner, EventListener<T> callback) {}
