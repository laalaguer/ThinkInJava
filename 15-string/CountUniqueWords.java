/*
We learn some points here:
1. (?i) means case insensitive
2. (?m) means match $ not only at string terminator, but also at line breakers. multiline mode.
3. (?ui) means unicode-case-insensitive.

And if give out a parentthesis surounded pattern:
A(B(C))D
Then group() or group(0) will return A(B(C))D,
Start from left, first parentthesis is (B, so group(1) will return B(C)
So group(2) will return C. --> (B(C
So groupCount() = 2
Another example:
A(B)(C)D
group() = group(0) = A(B)(C)D
group(1) = (B)
group(2) = (C)
groupCount() = 2
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;

public class CountUniqueWords{
	
	private static String paragraph = "This is a fine day.\n"+
	"We played outside on the sea shore for whole day.\n" + 
	"A new friend of mine has got a new ball.\n"+
	"For a very long time, it was sun shine.\n" +
	"Until it rains and we all got wet.";

	public static void main(String [] args){
		// Q1. How to get out each 3 last words at the end of each line?
		Pattern p1 = Pattern.compile("(?m)(\\S+)\\s+(\\S+)\\s+(\\S+)$");
		Matcher m1 = p1.matcher(paragraph);
		while(m1.find()){
			System.out.println("m.groupCount()=" + m1.groupCount());
			for (int i=0;i<=m1.groupCount();i++){
				System.out.print("["+ m1.group(i) +"]");
			}
			System.out.println();
		}


		// Q2. How to get the unique words in the poem? (take care about Capital letter.)
		Pattern p2 = Pattern.compile("(?i)\\w+"); // case insensitive (?i)
		Matcher m2 = p2.matcher(paragraph);
		Set<String> inner = new HashSet<String>();
		while(m2.find()){
			inner.add(m2.group().toLowerCase());
		}
		System.out.println(inner);

		// Q2. how to replace all 'i' which is not the leading, into 1?
		// for example, leave 'is' untouched, but 'this' changed to 'th1s'?
		Pattern p3 = Pattern.compile("(\\w+)(i)(\\w?)");
		Matcher m3 = p3.matcher(paragraph);
		StringBuffer sb = new StringBuffer();
		while(m3.find()){
			m3.appendReplacement(sb, m3.group(1)+ "1" + m3.group(3));
		}
		m3.appendTail(sb);
		System.out.print(sb.toString());
	}
	
}
/*
m.groupCount()=3
[a fine day.][a][fine][day.]
m.groupCount()=3
[for whole day.][for][whole][day.]
m.groupCount()=3
[a new ball.][a][new][ball.]
m.groupCount()=3
[was sun shine.][was][sun][shine.]
m.groupCount()=3
[all got wet.][all][got][wet.]

[shore, for, shine, long, until, sun, has, was, of, time, on, mine, 
wet, fine, all, is, ball, it, a, sea, the, and, new,
played, whole, day, rains, this, got, outside, friend, we, very]

Th1s is a f1ne day.
We played outs1de on the sea shore for whole day.
A new fr1end of m1ne has got a new ball.
For a very long t1me, it was sun sh1ne.
Unt1l it ra1ns and we all got wet.

 */