package untitled.event;

import lombok.val;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class EventRegister<T> {

    private final Map<Type, List<EventStorage<T>>> storageMap = new HashMap<>();
    private final Map<Type, List<untitled.event.EventListener<T>>> callbackMap = new HashMap<>();

    public void register(final Object eventToListen) throws IllegalAccessException {
        for (final Field field : eventToListen.getClass().getDeclaredFields()) {
            if (field.getType() == untitled.event.EventListener.class) {
                if (!field.canAccess(eventToListen)) //Forces field to be accessible
                    field.setAccessible(true);

                val type = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];

                val callback = (untitled.event.EventListener<T>) field.get(eventToListen);

                if (storageMap.containsKey(type)) {
                    val storages = storageMap.get(type);
                    storages.add(new EventStorage<>(eventToListen, callback));
                } else
                    storageMap.put(type, new ArrayList<>(Collections.singletonList(new EventStorage<>(eventToListen, callback))));
            }
        }
        this.update();
    }

    public void unregister(final Object objectToUnregister) {
        for (final List<EventStorage<T>> storages : storageMap.values())
            storages.removeIf(eventStorage -> eventStorage.owner() == objectToUnregister);

        this.update();

    }

    public void addToListen(T t) {
        val callbacks = callbackMap.get(t.getClass());

        if (callbacks != null) {
            for (EventListener<T> callback : callbacks)
                callback.call(t);
        }
    }

    private void update() {
        for (final Type type : storageMap.keySet()) {
            val storages = storageMap.get(type);

            //Cant use lombok they got autism
            final List<EventListener<T>> callbacks = new ArrayList<>(storages.size());

            storages.forEach(eventStorage -> callbacks.add(eventStorage.callback()));

            callbackMap.put(type, callbacks);

        }
    }

}
