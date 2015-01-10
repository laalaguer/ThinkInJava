/* A framework is a system initialized with a fixed bunch of events.
 * Framework will go through all events (one by one, lets say) and then
 * when event is ready, fire off this event.
 */

/* You can see that this code file is fixed, it will not change in the future.*/

import java.util.List;
import java.util.ArrayList;

public class ControlFramework{
	private List<Event> events = new ArrayList<Event>();
	private List<Event> temp = new ArrayList<Event>();

	public void addEvent(Event c) {events.add(c);}

	public void run(){
		while(events.size()>0){
			System.out.println(events); // Check current events.
			temp = new ArrayList<Event>(events);
			// 01. Scan through events and fire actions.
			for (Event e: temp){
				if (e.isReady()){
					System.out.println("System: Fire an event");
					e.doAction();
					e.disable();
				}
			}
			// 02. Scan through events and remove disabled events.
			for (Event e: temp){
				if (!e.isActive()){
					events.remove(e);
				}
			}
		}
	}
}