package untitled.module;

public enum ModuleType {

    COMBAT("Combat"), MOVEMENT("Movement"), PLAYER("Player"), VISUAL("Visual");

    final String displayString;

    ModuleType(String displayString) {
        this.displayString = displayString;
    }

}
