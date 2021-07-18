import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        for(String fileName: args){
            FileDifferentiator fileDifferentiator = new FileDifferentiator(fileName);
            try {
                fileDifferentiator.getExtensions();
            }catch (IllegalArgumentException ex){
                System.out.println(ex+ "\n");
                continue;
            }
            fileDifferentiator.verifyExtensions();
        }
    }
}
