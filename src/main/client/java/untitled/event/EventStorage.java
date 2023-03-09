package java.untitled.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record EventStorage<T>(Object owner, EventListener<?> callback) {}
