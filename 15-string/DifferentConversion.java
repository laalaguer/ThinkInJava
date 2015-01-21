/* here we try the different conversion of the formatter.
	d = decimal
	h = hash
	x = hex code
	s = string
	c = char
	f = float
	e = float, but in a scientific way.
	t = time or date format, can follow with suffix to see the time or date more clearer.
*/
import java.util.Formatter;
import java.util.Date;

public class DifferentConversion{
	public static void main (String [] args){
		Formatter f = new Formatter(System.out);
		char a = 'a';
		f.format("as String: %5s\n", a);
		f.format("as char: %5c\n", a);
		//f.format("as int: %5d\n", a); //IllegalFormatConversionException
		f.format("as boolean: %5b\n", a);
		f.format("as hash: %5h\n", a); // it is actually the ASCII code 61.


		int i = 106;
		f.format("as decimal %5d\n", i);
		f.format("as boolean %5b\n", i);
		f.format("as char    %5c\n", i);
		f.format("as string  %5s\n", i); // Integer.toString() makes this change.
		f.format("as hex     %5x\n", i); // 6a --> 6x 16 + a = 6 x 16 + 10 = 106
		f.format("as hash    %5h\n", i);


		Date d = new Date();
		f.format("Month is %tB%n", d); // month January
		f.format("Month is %tb%n", d); // month Jan
		f.format("Month is %tm%n", d); // month 01
		f.format("Today is %ta%n", d); // week day Wed
		f.format("Today is %tA%n", d); // weed day Wednesday
		f.format("Year is  %tY%n", d); // year 2015
		f.format("Year is  %ty%n", d); // year 15
		f.format("Centry is  %tC%n", d); // Centry 20
		f.format("Day of Month is %td%n", d); // day 21

		f.format("%tH:%tM%n",d,d); // 12:33
	}
}