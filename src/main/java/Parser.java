public class Parser {
    public static String getExtensionFromName(String name){
        String extension="";
        if (name.lastIndexOf('.')>0){
            extension = name.substring(name.lastIndexOf('.')+1);
        }
        else{
            throw new IllegalArgumentException("Wrong file name");
        }
        return extension;
    }
}
