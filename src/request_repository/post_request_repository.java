package request_repository;

public class post_request_repository {
	
	public static String baseURI()
	{
		String baseURI ="https://reqres.in/";
		return baseURI;
	}
	
	public static String resource()
	{
		String resource ="api/users";
		return resource;
	}
	
	public static String requestbody()
	{
		String requestbody ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return requestbody;
	}

}
