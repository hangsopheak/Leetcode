/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONGSONG
 */
public class Test {

public static int solution(int[] nums){
   int tmp=0;
   for(int i:nums){
      tmp^=i;
   }
   
   return tmp;
}

    public static void main(String[] args) {
        String a="adasa";
        System.out.print(a.substring(1, 3));
    }
}
