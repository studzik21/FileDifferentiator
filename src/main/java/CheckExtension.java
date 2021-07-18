import java.io.*;

public class CheckExtension {
    public static String getRealExtension(String fileName) throws IOException {
        File f = new File(fileName);
        InputStream is = new FileInputStream(f);
        byte[] bytes = new byte[2];
        is.read(bytes,0,2);
        String res=null;
        try {
            res = matchExtension(bytes);

        }catch (IllegalArgumentException ex){
            System.out.println(ex);
            return null;
        }
        return res;
    }

    public static String matchExtension(byte[] bytes){
        switch (Byte.toUnsignedInt(bytes[0])){
            case 0x47:
                if(Byte.toUnsignedInt(bytes[1])==0x49)
                    return "gif";
            case 0xFF:
                if(Byte.toUnsignedInt(bytes[1])==0xD8)
                    return "jpg";
                if(Byte.toUnsignedInt(bytes[1])==0xFE)
                    return "txt";

            default:
                throw new IllegalArgumentException("Unhandle extension or magic number");

        }
    }
}
