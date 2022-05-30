
public class ExceptionalExample extends Exception{

	
	private String errorCode="Unknown_Exception";
    //good practice to define your own exception
	//UNLIKE this class, exception classes should end with Exception for naming convention
    public ExceptionalExample(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
     
    public String getErrorCode(){
        return this.errorCode;
    }
}
