import java.util.Scanner;

public class CF_1900A_cover_in_water_800R {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numberOfTestcases  = sc.nextInt();
    while (numberOfTestcases-- > 0) {
        int strLen = sc.nextInt();
        String str  = sc.next();
        if(str.contains("...")){
            System.out.println(2);
        }else{
            int cpunt = 0;
            for(char c : str.toCharArray()){
                if(c == '.'){
                    cpunt++;
                }
            }
            System.out.println(cpunt);
        }
    }
}
    
}