import java.util.Scanner;
public class CF_2126A_FIND_SMALLEST_DIGIT_Y_800R{
public static void main(String[] args){
Scanner s = new Scanner(System.in);
int tests = s.nextInt();
while (tests-- > 0){
int number = s.nextInt();
int smallestDigit = Integer.MAX_VALUE;

while (number > 0){
int digit = number % 10;
smallestDigit = Math.min(smallestDigit, digit);
number /= 10;
}
System.out.println(smallestDigit);
    s.close();

}
}
}