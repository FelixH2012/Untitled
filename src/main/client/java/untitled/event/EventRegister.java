package java.untitled.event;

import lombok.val;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class EventRegister {

    private final Map<Type, List<EventStorage<?>>> storageMap = new HashMap<>();
    private final Map<Type, List<EventListener<?>>> callbackMap = new HashMap<>();

    public void register(final Object eventToListen) throws IllegalAccessException {
        for (final Field field : eventToListen.getClass().getDeclaredFields()) {
            if (field.getType() == EventListener.class) {
                if (!field.canAccess(eventToListen)) //Forces field to be accessible
                    field.setAccessible(true);

                val type = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];

                val callback = (EventListener<?>) field.get(eventToListen);

                if (storageMap.containsKey(type)) {
                    val storages = storageMap.get(type);
                    storages.add(new EventStorage<>(eventToListen, callback));
                } else
                    storageMap.put(type, new ArrayList<>(Collections.singletonList(new EventStorage<>(eventToListen, callback))));
            }
        }
        this.update();
    }

    private void update() {
        for (final Type type : storageMap.keySet()) {
            val storages = storageMap.get(type);

            //Cant use lombok they got autism
            final List<EventListener<?>> callbacks = new ArrayList<>(storages.size());

            storages.forEach(eventStorage -> callbacks.add(eventStorage.getCallback()));

            callbackMap.put(type, callbacks);

        }
    }

}
