package untitled.module;


import lombok.Getter;
import lombok.Setter;
import untitled.Untitled;
import untitled.hook.MinecraftHook;

@Getter
@Setter
public class Module implements MinecraftHook {

    private String name, displayName;

    private ModuleType moduleType;

    public boolean toggled;

    public Module() {
        final ModuleData moduleData = getClass().getAnnotation(ModuleData.class);
        this.name = moduleData.name();
        this.displayName = moduleData.displayName();
        this.moduleType = moduleData.type();
    }

    public void callModule(boolean status) {
        setToggled(status);
        if (status) {
            handleEvent();
        } else {
            unHandleEvent();
        }

    }


    public void handleEvent() {
        try {
            Untitled.singleton.eventRegister.register(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        onHandle();
    }

    public void unHandleEvent() {
        Untitled.singleton.eventRegister.unregister(this);
        onDisable();
    }

    public void onHandle() {
    }

    public void onDisable() {
    }

}
