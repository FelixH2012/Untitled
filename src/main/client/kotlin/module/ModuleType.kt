package kotlin.module

/*
Kotlin's Enum classes are looking way better than Java´s tbh.
So we're going to use them instant of Java´s enum class
*/

enum class ModuleType(val displayName: String) {

    COMBAT("Combat"), MOVEMENT("Movement"), VISUAL("Visual"), PLAYER("Player");

}