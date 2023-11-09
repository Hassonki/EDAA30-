import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysterClass {

    public static void mystery(int n) {
       if (n > 0){
          mystery(n-1);
          System.out.print(n * 4);
          mystery(n-1);
       } 
    }
 
    public static int[] mergeSort(int[] a){
      if(a.length <= 1){
         return a;
      }
      int mid = a.length/2;

      int[] left = Arrays.copyOfRange(a, 0, mid);
      int[] right = Arrays.copyOfRange(a, mid, a.length);
      int[] sorted = new int[a.length];
      left = mergeSort(left);
      right = mergeSort(right);

      int index_left = 0;
      int index_right = 0;
      int index_sorted = 0;

      while(index_left < left.length && index_right < right.length){
         if(left[index_left] <= right[index_right]){
            sorted[index_sorted] = left[index_left];
            index_left++;
         }else{
            sorted[index_sorted] = right[index_right];
            index_right++;
         }
         index_sorted++;
      }

      while(index_left < left.length){
         sorted[index_sorted] = left[index_left];
         index_left++;
         index_sorted++;
      }

      while(index_right < right.length){
         sorted[index_sorted] = right[index_right];
         index_right++;
         index_sorted++;
      }
      return sorted;

    }

    public static void main(String[] args) {
       MysterClass.mystery(3);
       int[] list = {15,23,643,-1,-75,98,-29};
       System.out.println(Arrays.toString(list));
       list = mergeSort(list);
       System.out.println(Arrays.toString(list));

       //System.out.println(mystery(5, 4));
       //System.out.print(binarySearch(list,150));
    } 

    public static int mystery(int a, int b) {
      if (b == 0) {
         return 0;
      } else {
         System.out.println(a);
         return a + mystery(a, b - 1);
      }
   }
   
   
    public static int binarySearch(List<Integer> list, int x){
      return binarySearch(list, x,0,list.size()-1);
    }
    private static int binarySearch(List<Integer> list, int x,  int first, int last){
            if(first>last){
               return -1;
            }
            int mid = first + (last-first)/2;
            if(list.get(mid) == x){
               return mid;
            }else if(list.get(mid) > x){
               return binarySearch(list, x,first, mid-1);
            }else{
               return binarySearch(list, x, mid + 1, last);
            }
    }
 }