package kotlin.module.event

annotation class EventCallback(val priority: EventPriority = EventPriority.NORMAL)

enum class EventPriority {
    LOW, NORMAL, HIGH
}