package untitled.initializeable;

import untitled.initializeable.initializeables.InitializeModule;
import java.util.ArrayList;

public class InitializeInitialize {

    public ArrayList<Initializer> initializers = new ArrayList<>();
    public InitializeInitialize() {

        initializers.add(new InitializeModule());

        initializers.forEach(Initializer::initialize);

    }

}
