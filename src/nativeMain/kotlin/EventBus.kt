package Example

typealias EventId = String
typealias ObserverCallback = (EventId) -> Boolean

class EventBusContext(identifier: String) {
  val eventBus = EventBus()
  val identifier: String
  init {
    this.identifier = identifier
  }
}

class EventBus {
  private var observers = mutableMapOf<EventId, MutableList<EventBusObserver>>()

  fun addObserver(observer: EventBusObserver) {
    observer.eventIds.iterator().forEach { id: EventId ->
      if (observers[id] == null) {
        observers[id] = mutableListOf<EventBusObserver>()
      }
      observers[id]?.add(observer)
    }
  }

  fun removeObserver(observer: EventBusObserver) {
    observer.eventIds.iterator().forEach { id: EventId ->
      observers[id]?.remove(observer)
    }
  }

  fun observer(eventIds: List<EventId>, callback: ObserverCallback) : EventBusObserver {
    return EventBusObserver(this, eventIds, callback)
  }
}

class EventBusObserver(
  eventBus: EventBus,
  eventIds: List<EventId>, 
  callback: ObserverCallback
) {
  val eventBus: EventBus
  val eventIds: List<EventId>
  val callback: ObserverCallback

  init {
    this.eventBus = eventBus
    this.eventIds = eventIds   
    this.callback = callback
    this.eventBus.addObserver(this)
  }

  fun dispose() {
    eventBus.removeObserver(this)
  }
}
