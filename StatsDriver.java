public class StatsDriver {
    public static void main(String[] args) {
	int intA = 8;
	int intB = 2;
	int intC = 8;
	double doubA = 8;
	double doubB = 2;
	double doubC = 8;
	
	System.out.println(Stats.mean(intA,intB)); // returns 5
	System.out.println(Stats.mean(doubA,doubB)); // returns 5.0
	System.out.println(Stats.max(intA,intB,intC)); // returns 8
	System.out.println(Stats.max(doubA,doubB,doubC)); // returns 8.0
	System.out.println(Stats.geoMean(intA,intB,intC)); // returns 5
	System.out.println(Stats.geoMean(doubA,doubB,doubC)); // returns 5.039684199579493
    }
}
