package com.epam.Radix;


import java.util.Arrays;   // Used only to perform my result;
import java.util.Random;

public class ChangeRadix {
    private static int a = buildInRand();
    private static char hexSymbols[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    private static char Eight[]={'0','1','2','3','4','5','6','7','A'};
    private static char Binary[]={'0','1',};

    private static int buildInRand(){
        Random rand = new Random();
        int res = rand.nextInt((int)Math.pow(2,32));

        System.out.println("Random int : "+res);
        return res;
    }


    private static int cut(int [] res){
        int length = res.length;

        while (res[length-1]==0){
            length--;
        }
        return length;
    }

    private static char[] reverse(char []toReverse){
        char[] reesult = new char[toReverse.length];
        for (int i = 0; i <reesult.length ; i++) {
            reesult[i]=toReverse[toReverse.length-1-i];
        }
        return reesult;
    }



    private static char[] changeRadix (int num,int radix) {
        int b;
        char  empty[]={};
        int i =0;
        int mas[]=new int[32];

        while(num!=0){
            b=num%radix;
            mas[i] = b+mas[i];
            num=num/radix;
            i++;
        }

        if (radix == 16) {
            char result []=new char[cut(mas)];
            for (int j = 0; j< cut(mas) ; j++) {
                result[j]=hexSymbols[mas[j]];
            }
            return reverse(result);
        }

        if(radix==8){
            char result []=new char[cut(mas)];
            for (int j = 0; j <cut(mas) ; j++) {
                result[j]=Eight[mas[j]];
            }
            return reverse(result) ;
        }

        if(radix==2){
            char result []=new char[cut(mas)];
            for (int j = 0; j <cut(mas) ; j++) {
                result[j]=Binary[mas[j]];
            }
            return reverse(result);
        }


       return empty;
    }


    public static void main(String[] args) {

        System.out.println("Result of build in function : " + Integer.toHexString(a));
        System.out.println(" Radix = 16 : " + Arrays.toString(changeRadix(a,16)));


        System.out.println("Result of build in function : " + Integer.toOctalString(a));
        System.out.println(" Radix = 8 : " + Arrays.toString(changeRadix(a,8)));


        System.out.println("Result of build in function : " + Integer.toBinaryString(a));
        System.out.println(" Radix = 2 : " + Arrays.toString(changeRadix(a,2)));


    }
}
