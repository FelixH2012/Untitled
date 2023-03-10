package untitled.initializeable.initializeables;


import untitled.initializeable.Initializer;
import untitled.module.Module;
import untitled.module.modules.HudModule;

import java.util.ArrayList;

public class InitializeModule implements Initializer {

    public ArrayList<Module> modules = new ArrayList<>();

    @Override
    public void initialize() {
        this.modules.add(new HudModule());
        modules.forEach(module -> module.callModule(true));
    }
}
