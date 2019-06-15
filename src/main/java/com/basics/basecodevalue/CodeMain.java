package com.basics.basecodevalue;
/**
 * @ClassName CodeMain
 * @Description TODO
 * @Author chenzhuo
 * @Date 2018/8/16 12:05
 * @Version 1.0
 * 随机邀请码
 **/
public class CodeMain {

    public static void main(String[] args) {
       /* Random random = new Random();
       for (int i=0;i<10000000;i++){
           String s  = HloveyRC4(random.nextInt()+"",random.nextInt()+"");
           System.out.println(strTo16(s).substring(0,6));
       }*/
    /*   String[] strings = new String[]{};
       System.out.println("size： " + strings.length);*/
    }

    public static String HloveyRC4(String aInput,String aKey){
        int[] iS = new int[256];
        byte[] iK = new byte[256];
        for (int i=0;i<256;i++) {
            iS[i]=i;
        }
        int j = 1;
        for (short i= 0;i<256;i++){
            iK[i]=(byte)aKey.charAt((i % aKey.length()));
        }
        j=0;

        for (int i=0;i<255;i++){
            j=(j+iS[i]+iK[i]) % 256;
            int temp = iS[i];
            iS[i]=iS[j];
            iS[j]=temp;
        }
        int i=0;
        j=0;
        char[] iInputChar = aInput.toCharArray();
        char[] iOutputChar = new char[iInputChar.length];
        for(short x = 0;x<iInputChar.length;x++)
        {
            i = (i+1) % 256;
            j = (j+iS[i]) % 256;
            int temp = iS[i];
            iS[i]=iS[j];
            iS[j]=temp;
            int t = (iS[i]+(iS[j] % 256)) % 256;
            int iY = iS[t];
            char iCY = (char)iY;
            iOutputChar[x] =(char)( iInputChar[x] ^ iCY) ;
        }

        return new String(iOutputChar);

    }

    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

}
