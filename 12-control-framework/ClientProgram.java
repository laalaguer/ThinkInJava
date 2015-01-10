/* This is an example program how we use this framework.*/

public class ClientProgram{
	public static void main(String [] args){
		SmartPhoneControlFramework smartphone = new SmartPhoneControlFramework();
		smartphone.addEvent(smartphone.new TouchEvent(900));
		smartphone.run();
	}
}
/*
[SmartPhoneControlFramework$TouchEvent@e5bbd6]
System: Fire an event
Touch: User Touched Screen.
[SmartPhoneControlFramework$ScreenOnEvent@19e15c]
System: Fire an event
Scree: Screen lights on.
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
[SmartPhoneControlFramework$ScreenOffEvent@11a75a2]
System: Fire an event
Screen: Screen turns off.
*/