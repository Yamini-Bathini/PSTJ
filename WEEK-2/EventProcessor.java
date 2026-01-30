import java.time.LocalDate;
import java.util.*;
class Event {
    String name;
    LocalDate date;
    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}
public class EventProcessor {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        List<Event> events = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int lastSpace = line.lastIndexOf(' ');
            String name = line.substring(0, lastSpace);
            String dateText = line.substring(lastSpace + 1);
            LocalDate date = LocalDate.parse(dateText);
            events.add(new Event(name, date));
        }
        int month = Integer.parseInt(sc.nextLine());
        events.sort(Comparator.comparing(e -> e.date));
        for (Event e : events) {
            System.out.print(e.name + " ");
        }
        System.out.println();
        System.out.println(events.get(0).name);
        System.out.println(events.get(events.size() - 1).name);
        for (Event e : events) {
            if (e.date.getMonthValue() == month) {
                System.out.print(e.name + " ");
            }
        }
    }
}
