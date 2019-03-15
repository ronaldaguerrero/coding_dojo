import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
	public static void main (String[] args){
		HashMap<String, String> trackList = new HashMap<String, String>();
		trackList.put("For Once in My Life", "Stevie Wonder's lyrics");
		trackList.put("Casanova", "Levert's lyrics");
		trackList.put("Your Smiling Face", "James Taylor's lyrics ");
		trackList.put("How Deep Is Your Love", "BeeGees' lyrics");
		trackList.put("September", "Earth, Wind & Fire's lyrics");
		System.out.println("The title for these lyrics is: " + trackList.get("September"));
		System.out.println("*********************");
		for (String title: trackList.keySet()){
			System.out.println(title + " is the title with " + trackList.get(title));
		}
	}
}