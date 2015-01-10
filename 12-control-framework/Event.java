/* 	So what are events?
	Events are objects that framework wants to trigger.
	Each event is triggered by some signal, and when it is ready,
	Each event will execute some action. Then it can be removed, or still stay in Framework.
*/


public abstract class Event{
	private boolean active = true; // indicates if event can be triggered.
	private final long delayTime; // this event will be delayed to be ready.
	private long triggerTime; // private structure stores absolute time for triggering.
	public Event(long delayTime){
		this.delayTime = delayTime;
		this.initialize();
	}
	// initialize the event.
	public void initialize(){
		triggerTime = System.nanoTime() + delayTime;
	}
	// after initialization, check from time to time,
	// if event is ready to execute.
	public boolean isReady(){
		return triggerTime < System.nanoTime();
	}
	// subclass can inherit and do the real action.
	public abstract void doAction();
	// Mark the event as not active.
	public void disable(){
		this.active = false;
	}
	// return if current event is active.
	public boolean isActive(){
		return this.active;
	}
}