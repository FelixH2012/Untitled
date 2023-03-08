package java.untitled.module;


import kotlin.module.ModuleType;

public @interface ModuleData {

    ModuleType type() default ModuleType.COMBAT;

    String displayName();

    String name();

}
