import java.util.Scanner;
public class CF_1919B_PLUS_MINUS_PSLIT_800R {
  public static void main(String[] args){
    Scanner s = new java.util.Scanner(System.in);
    int tests = s.nextInt();
    while(tests-- > 0){
      int A = s.nextInt();
      int resilt = 0;
      String ss = s.next();
      char[] si = ss.toCharArray();
      for(int i = 0; i < A; i++){
        char c = si[i];
        if(c == '+'){
          resilt++;
        }else{
          resilt--;
        }
      }
      if(resilt < 0){
        System.out.println(-resilt);
      }else{
        System.out.println(resilt);
      }
    }
        s.close();
  }
}