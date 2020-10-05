/* Name: Blessing Babajide
 * NetID: bbabajid
 * Assignment: Project 2
 * Lab Section: MW 10:25 am
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Throwdown {
	protected static Random rand = new Random();
	protected static Scanner input = new Scanner(System.in);
	protected static int score, runs;
	protected static String str;
	protected static int[] list, occurence;
	protected static double fikindFreq = 0,fokindFreq = 0,thkindFreq = 0,smallstrFreq = 0,larstrFreq = 0,
			fullhousFreq = 0,sum1Freq = 0,sum2Freq = 0,sum3Freq = 0,sum4Freq = 0,sum5Freq = 0,sum6Freq = 0;
	protected static double fikindscrs = 0,fokindscrs = 0,thkindscrs = 0,smallstrscrs = 0,larstrscrs = 0,
			fullhousscrs = 0,sum1scrs = 0,sum2scrs = 0,sum3scrs = 0,sum4scrs = 0,sum5scrs = 0,sum6scrs = 0;


	//Change string of numbers to arrays.
	public static int[] toArray(String string) {
		String[] parts = string.split(" ");
		int[] noList = new int[parts.length]; 
		for(int i=0; i < parts.length; i++)
			noList[i] = Integer.parseInt(parts[i]);
		Arrays.sort(noList);
		return  noList;
	}

	//Make an array of random integers.
	public static int[] randArray(int n) {
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = 1 + rand.nextInt(6);
		Arrays.sort(arr);
		return arr;
	}

	//Sum all numbers in an array of integers.
	public static int sumOfnos(int[] ints) {
		int sum = 0;
		for(int i=0; i<ints.length;i++)
			sum+=ints[i];
		return sum;
	}

	//Sum numbers in an array, figure which sum is highest and set score
	public static void maxSum(int[] ints) {
		int sum = 0, cursum = 0, num = 0;
		for(int i=1; i<=6;i++) {
			for(int j=0;j<ints.length;j++) {
				if(ints[j]==i)
					cursum+= i;
			}
			if(cursum >= sum) {
				sum = cursum;
				num = i;
			}
			cursum = 0;
		}
		str = "sum" + num + "'s";
		score = sum;
	}

	//Create array with occurrence of 1-6 in a roll
	public static void countOcc(int[] array) {
		occurence = new int[6];
		for(int i =0;i<6;i++) {
			int count = 0;
			for(int j=0; j<array.length;j++) {
				if(array[j] == i+1)
					count++;
			}
			occurence[i] = count;
		}
		int max = occurence[0];
		for(int i=0; i<6;i++) {
			if(max <= occurence[i]) 
				max = occurence[i];
		}
		whatOfaKind(max); //Pass the most occurred into method to get label
	}

	//Determine if array is a straight, label and score it:
	public static void straightCheck(int[] array) {
		int c = 1;
		int c2 = 0;
		while (c2<=3) {
			if(array[c2] +1 == array[c2+1]) 
				c++;
			c2++;
		}
		if(c==4) {
			str = "smallStraight";
			score = 30;
			smallstrscrs+=score;
			smallstrFreq++;
		}
		else if(c==5) {
			str = "largeStraight";
			score = 40;
			larstrscrs+=score;
			larstrFreq++;
		}
		else
			str = "null";
	}

	//Check the different kinds, label and score accordingly
	public static void whatOfaKind(int no) {
		switch(no) {
		case(5):
			str = "5ofKind";
			score = sumOfnos(list) + 50;
			fikindscrs+=score;
			fikindFreq++;
		break;
		case(4):
			str = "4ofKind";
			score = sumOfnos(list)+ 10;
			fokindscrs+=score;
			fokindFreq++;
		break;
		case(3):   //Possibility of 3ofKind or fullhouse check
			str = "3ofKind";
			score = sumOfnos(list);
			thkindscrs+=score;
			thkindFreq++;
		for(int i =0; i<6;i++) {
			if(occurence[i] == 2) {
				str = "fullHouse";
				score = 25;
				fullhousscrs+=score;
				fullhousFreq++;
				break;
			}}
		break; 
		default:
			str = "null";
			score = 0;
			break;
		}}

	//Accumulating frequency and scores of sumofs
	public static void checkFreq(String str) {
		switch(str) {
		case("sum1's"):
			sum1Freq++;
			sum1scrs+=score;
		break;
		case("sum2's"):
			sum2Freq++;
			sum2scrs+=score;
		break;
		case("sum3's"):
			sum3Freq++;
			sum3scrs+=score;
		break;
		case("sum4's"):
			sum4Freq++;
			sum4scrs+=score;
		break;
		case("sum5's"):
			sum5Freq++;
			sum5scrs+=score;
		break;
		case("sum6's"):
			sum6Freq++;
			sum6scrs+=score;
		break;
		}}

	//Classify method:
	public static void classify() {
		System.out.println("Welcome to Classify Mode!");
		System.out.print("Input five integers seperated by spaces (press enter to quit): ");
		String numbers = input.nextLine();
		while(! (numbers.equals(""))) {
			list = toArray(numbers);
			countOcc(list);
			if(score == 0) {
				straightCheck(list);
				if(score == 0)
					maxSum(list);
			}
			System.out.println(numbers + " best is " + str 
					+ " with score "+ score);
			System.out.print("Input five integers seperated by spaces (press enter to quit): ");
			numbers = input.nextLine();
		}
		System.out.println("Thanks for playing! ");
	}
	
	//For frequencies of zero to avoid NaN i change 0 to 1
	public static double fixz(double x) {
		if(x==0)
			return 1;
		else
			return x;
	}

	//Simulate method:
	public static void simulate() {
		System.out.println("Welcome to Simulate mode! This is the result of a simulation of "
						+ runs + " games:\n");
		int c = 0;
		System.out.println("Outcome      "+" Frequency  "+"Avg Score");
		System.out.println("------------"+"  "+"---------"+" "+ "----------");
		while(c<runs) {
			list = randArray(5);
			countOcc(list);
			if(score == 0)
				straightCheck(list);
			if(score == 0)
				maxSum(list);
			checkFreq(str);
			c++;
		}

		//Printing out the values of frequency and average score
		System.out.printf("sum1's %13.2f%% " + "%9.2f%n",(sum1Freq/runs)*100,sum1scrs/fixz(sum1Freq));
		System.out.printf("sum2's %13.2f%% " + "%9.2f%n",(sum2Freq/runs)*100,sum2scrs/fixz(sum2Freq));
		System.out.printf("sum3's %13.2f%% " + "%9.2f%n",(sum3Freq/runs)*100,sum3scrs/fixz(sum3Freq));
		System.out.printf("sum4's %13.2f%% " + "%9.2f%n",(sum4Freq/runs)*100,sum4scrs/fixz(sum4Freq));
		System.out.printf("sum5's %13.2f%% " + "%9.2f%n",(sum5Freq/runs)*100,sum5scrs/fixz(sum5Freq));
		System.out.printf("sum6's %13.2f%% " + "%9.2f%n",(sum6Freq/runs)*100,sum6scrs/fixz(sum6Freq));
		System.out.printf("3ofKind %12.2f%% " + "%9.2f%n",(thkindFreq/runs)*100,thkindscrs/fixz(thkindFreq));
		System.out.printf("4ofKind %12.2f%% " + "%9.2f%n",(fokindFreq/runs)*100,fokindscrs/fixz(fokindFreq));
		System.out.printf("5ofKind %12.2f%% " + "%9.2f%n",(fikindFreq/runs)*100,fikindscrs/fixz(fikindFreq));
		System.out.printf("smallStraight %6.2f%% " + "%9.2f%n",(smallstrFreq/runs)*100,smallstrscrs/fixz(smallstrFreq));
		System.out.printf("largeStraight %6.2f%% " + "%9.2f%n",(larstrFreq/runs)*100,larstrscrs/fixz(larstrFreq));
		System.out.printf("fullHouse %10.2f%% " + "%9.2f%n",(fullhousFreq/runs)*100,fullhousscrs/fixz(fullhousFreq));
	}

	//Main method:
	public static void main(String[] args) {
		if(args[0].equals(("classify"))) 
			classify();

		else if(args[0].equals("simulate")) {
			runs = Integer.parseInt(args[1]);
			simulate(); 
		}
	}
}
