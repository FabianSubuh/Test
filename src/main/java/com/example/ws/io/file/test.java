package com.example.ws.io.file;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int room = 2, guest =4;
        System.out.println(Arrays.toString(kamar(room,guest)));

    }

    public static int[] kamar(int room, int guest){
        int[] jawaban = new int[room];
        int pembagian = guest/room;
        int sisaBagi = guest%room;
        for (int i=0; i<room; i++ ){
            if(sisaBagi >0){
                jawaban[i] = pembagian+1;
                sisaBagi-=1;
            }else{
                jawaban[i] = pembagian;
            }
        }
        return jawaban;
    }
}
