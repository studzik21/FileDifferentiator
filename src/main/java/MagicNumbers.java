public enum MagicNumbers {
    GIF(new int[] {0x47,0x49}),
    JPG(new int[] {0xFF, 0xD8}),
    ;
//    JPG(0xFF, 0xD8),
//    PDF(0x25, 0x50);


    MagicNumbers(int[] ints) {
    }
}
