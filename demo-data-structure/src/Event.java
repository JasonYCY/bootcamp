import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Event {
  // attribute
  private Importance importance;
  private LocalDateTime eventDateTime;

  // constructor
  public Event(Importance importance, LocalDateTime eventDateTime) {
    this.importance = importance;
    this.eventDateTime = eventDateTime;
  }

  // toString
  @Override
  public String toString() {
    return "Event{importance=" + importance + ", dateTime=" + eventDateTime + "}";
  }

  // inner static enum
  public static enum Importance {
    HIGH,
    MEDIUM,
    LOW;
  }

  // getter
  public Importance getImportance() {
    return importance;
  }

  public LocalDateTime getEventDateTime() {
    return eventDateTime;
  }



  // main method
  public static void main(String[] args) {
    // HIGH -> MEDIUM -> LOW
    PriorityQueue<Event> eventQueue = new PriorityQueue<>(
      (Event e1, Event e2) -> {
        int priorityDiff = e1.importance.ordinal() - e2.importance.ordinal();
        int dateTimeDiff = e1.getEventDateTime().compareTo(e2.getEventDateTime());
        return priorityDiff == 0 ? dateTimeDiff : priorityDiff;
      }
    );

    eventQueue.addAll(
      Arrays.asList(
        new Event(Importance.MEDIUM, LocalDateTime.of(2025, 12, 3, 10, 0)),
        new Event(Importance.LOW, LocalDateTime.of(2025, 12, 6, 10, 0)),
        new Event(Importance.HIGH, LocalDateTime.of(2025, 12, 30, 10, 0)),
        new Event(Importance.LOW, LocalDateTime.of(2025, 12, 15, 10, 0)),
        new Event(Importance.MEDIUM, LocalDateTime.of(2025, 12, 1, 10, 0)),
        new Event(Importance.HIGH, LocalDateTime.of(2025, 12, 21, 10, 0)),
        new Event(Importance.LOW, LocalDateTime.of(2025, 12, 2, 10, 0))
      )
    );

    int numberOfEvent = eventQueue.size();
    for (int i = 0; i < numberOfEvent; i++) {
      System.out.println(eventQueue.poll());
    }






  }
}
