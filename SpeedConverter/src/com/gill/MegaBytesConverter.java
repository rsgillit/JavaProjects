package com.gill;

public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            System.out.println("Invalid Value, because parameter is less than 0.");
            return;
        }
        int megaBytes = kiloBytes / 1024;
        int remainingKilobytes = kiloBytes % 1024;
        System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKilobytes + " KB");
    }
}
