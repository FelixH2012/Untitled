package untitled.event;

public record EventStorage<T>(Object owner, EventListener<?> callback) {}