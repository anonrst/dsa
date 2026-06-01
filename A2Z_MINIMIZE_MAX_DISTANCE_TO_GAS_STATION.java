class Solution {
  public static double findMinDist(int[] gasStations, int k){
    double minDist = 0;
    double maxDist = 0;
    for(int i = 0;i < gasStations.length - 1;i++){
      maxDist = Math.max(maxDist, gasStations[i + 1] - gasStations[i]);
    }
    double maxDiff = 1e-6;
    while((maxDist-minDist)> maxDiff){
      double mid = minDist + ( maxDist - minDist)/2.0;
      if(canThisDistWotk(gasStations,k,mid)){
        maxDist = mid;
      }else{
        minDist = mid;
      }
    }
    return maxDist;
  }
  public static boolean canThisDistWotk(int[] stations,int k, double distance){
    int addedS = 0;
    for(int i =0;i < stations.length - 1;i++){
      int distanced = stations[i +1] - stations[i];
      int hh = (int)Math.ceil(distanced/distance) - 1;
      addedS += hh;
    }
    return addedS <= k;
  }
  }


public class A2Z_MINIMIZE_MAX_DISTANCE_TO_GAS_STATION {
  public static void main(String[] args){
    int[] tetscase  = {1, 2, 3, 4, 5, 6 ,7, 8, 9,10};
    double expected = 0.5;
    double result =Solution.findMinDist(tetscase,10);
    System.out.println(result == expected);
    System.out.println(result);
  }
}