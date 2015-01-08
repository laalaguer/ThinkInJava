class Vege{
	Vege(int i){
		System.out.println("Vege: "+ String.valueOf(i));
	}
}

class VegeSoup extends Vege{
	VegeSoup(){
		System.out.println("Soup");
	}
}

public class Dinner{
	public static void main(String [] args){
		VegeSoup vs = new VegeSoup(); // this will create an error.
	}
	// Compile error:
	/* VegeSoup() takes no arguments, how ever Vege(int) takes one argument.
		and there is no Vege() constructor available, so compiler gives error,
		when it tries to call Vege() constructor implicitly.
	*/
	// But if you change the VegeSoup class into following code:
	/*
	class VegeSoup extends Vege{
		VegeSoup(){
			super(3); //----> call Vege(int) constructor explicitly.
			System.out.println("Soup");
		}
	}
	*/	
	// Then it will give no error.
}