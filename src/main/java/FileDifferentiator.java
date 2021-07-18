import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class FileDifferentiator{
    private final String fileName;
    private String nameExtension;
    private String magicNumberExtension;

    FileDifferentiator(String fileName){
        this.fileName = fileName;
        System.out.println("Checking: " + fileName);
    }


    void getExtensions() throws IOException {
            this.nameExtension = getExtensionFromName(fileName);
            this.magicNumberExtension = getRealExtension(fileName);
    }


    void verifyExtensions(){
        if (nameExtension.equals(magicNumberExtension))
            System.out.println("Extension "+ nameExtension + " is correct.");
        else System.out.println("Extension is "+ nameExtension + ", while actually it's a "+magicNumberExtension);

        System.out.println();
    }

    private String getExtensionFromName(String name){
        String extension="";
        if (name.lastIndexOf('.')>0){
            extension = name.substring(name.lastIndexOf('.')+1);
        }
        else{
            throw new IllegalArgumentException("Name does not contain extension");
        }
        return extension;
    }

    private String getRealExtension(String fileName) throws IOException {
        File f = new File(fileName);
        InputStream is = new FileInputStream(f);
        byte[] bytes = new byte[2];
        is.read(bytes,0,2);
        String res=null;
        res = matchExtension(bytes);
        return res;
    }

    private String matchExtension(byte[] bytes){
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
                throw new IllegalArgumentException("Unhandle extension");

        }
    }



}