package prop;


public class MakeObj {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Aaa obj = new Aaa();
		obj.aaaprint();
		
		
		Class<?> handlerClass = Class.forName("prop.Aaa");
        Aaa handlerInstance = 
                (Aaa) handlerClass.newInstance();
        
        handlerInstance.aaaprint();
	}

}
