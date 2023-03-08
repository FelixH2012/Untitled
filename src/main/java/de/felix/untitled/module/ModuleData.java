package de.felix.untitled.module;

public @interface ModuleData {

    ModuleType type() default ModuleType.COMBAT;

    String displayName();

    String name();

}
