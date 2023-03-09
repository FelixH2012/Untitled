package untitled.module;


public class Module {

    private String name, displayName;

    private ModuleType moduleType;

    public Module() {
        final ModuleData moduleData = getClass().getAnnotation(ModuleData.class);
        this.name = moduleData.name();
        this.displayName = moduleData.displayName();
        this.moduleType = moduleData.type();
    }

}
