
public class SmartPhoneControlFramework extends ControlFramework{
	// Indicates that if user touches screen
	// If touches, then light on screen after 0.1 second.
	public class TouchEvent extends Event{
		public TouchEvent(long delayTime) {super(delayTime);}
		public void doAction(){
			System.out.println("Touch: User Touched Screen.");
			Event turnOnScreen = new ScreenOnEvent(1000);
			addEvent(turnOnScreen); // Inner class can access outer class.
		}
	}
	// Indicates that screen will turn on,
	// After turn on, turn off the screen after 1 second.
	public class ScreenOnEvent extends Event{
		public ScreenOnEvent(long delayTime){ super(delayTime);}
		public void doAction(){
			System.out.println("Scree: Screen lights on.");
			Event turnOffScreen = new ScreenOffEvent(10000000);
			addEvent(turnOffScreen);
		}
	}

	// Indicates that screen will turn off.
	public class ScreenOffEvent extends Event{
		public ScreenOffEvent(long delayTime){ super(delayTime);}
		public void doAction(){
			System.out.println("Screen: Screen turns off.");
		}
	}
}