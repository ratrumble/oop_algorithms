import java.io.FileNotFoundException;
import java.io.IOException;
 
public class ExceptionalStuff {
 //Throwable is parent of Error and Exception
//Error is unanticipated issues like JVM or hardware
//Exceptions are issues within code
//Checked Exceptions are exceptions we as users anticipate
//to debug and be "throws"-ed
//RUntime Exceptions are exceptions caused by poor coding such as ArrayIndexOutOfBoundsException
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try{
            testException(-5);
            testException(-10);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace(); //can try to minimize catch blocks if possible
        }finally{
            System.out.println("Final block is always reached, whether exception thrown or not");          
        }
        testException(15);
    }
     //throws ignores the anticipated exception, throw notifies the user of the exception in try-catch
    public static void testException(int i) throws FileNotFoundException, IOException{
        if(i < 0){
            FileNotFoundException myException = new FileNotFoundException("Negative Integer "+i);
            throw myException;
        }else if(i > 10){
            throw new IOException("Only supported for index 0 to 10");
        }
    }
}

//BELOW are methods that Throwable exceptions use
//public String getMessage() gives message of the throwable
//public String getLocalizedMessage() only returns if the base Throwable class
//is thrown, so that subclasses can override their message

//public synchronized Throwable getCuase returns cause of exception or null if unknown
//public String toString() returns name of Throwable class and localized message
//public void printStackTrace  prints the stack trace information to standard error stream?
//is overloaded and can use PrintStraem or PrintWriter as arguments to write stack trace to file/stream