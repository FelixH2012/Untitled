package untitled.initializeable;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class InitializeInitialize {

    public ArrayList<Initializer> initializers = new ArrayList<>();
    public InitializeInitialize() {
        var reflections = new Reflections(getClass().getPackageName());
        var classes = reflections.getSubTypesOf(Initializer.class);

        var instances = classes.stream().map(aClass -> {
            try {
                return (Initializer) aClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        initializers.addAll(instances);

        initializers.forEach(Initializer::initialize);

    }

}
