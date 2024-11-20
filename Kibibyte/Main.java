package Kibibyte;

public class Main {
    public static void main(String[] args) {
        System.out.println(KibiBytesMibiBytes(500));
        System.out.println(KibiBytesMibiBytes(1500));
        System.out.println(KibiBytesMibiBytes(1048576));
        System.out.println(KibiBytesMibiBytes(5242880));
    }

    public static String KibiBytesMibiBytes(long bytes) {
        long KIBIBYTE = 1024;
        long MEBIBYTE = KIBIBYTE * 1024;

        if (bytes < KIBIBYTE) {
            return bytes + " B";
        } else if (bytes < MEBIBYTE) {
            long kibibyte = bytes / KIBIBYTE;
            return kibibyte + " KiB";
        } else {
            long mebibyte = bytes / MEBIBYTE;
            return mebibyte + " MiB";
        }
    }
}