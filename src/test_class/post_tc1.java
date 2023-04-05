package test_class;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;

import common_method.common_method_utilities;
import common_method.post_common_method;
import io.restassured.path.json.JsonPath;
import request_repository.post_request_repository;

public class post_tc1 {
	
	public static void orchistrator() throws IOException
	{
		int StatusCode =0;
		String responseBody ="";
		String baseURI =post_request_repository.baseURI();
		String resource =post_request_repository.resource();
		String requestbody =post_request_repository.requestbody();
		for (int i=0; i<5; i++)
		{
			StatusCode =post_common_method.StatusCodeExtractor(baseURI, resource, requestbody);
			if (StatusCode ==201)
			{
				responseBody =post_common_method.responseBodyExtractor(baseURI, resource, requestbody);
				responseBodyValidator(responseBody);
				break;
			}
			else
			{
				System.out.println("Status code not validated, hence retrying " +i);
			}
		}
		common_method_utilities.EvidenceSheetCreator("post_tc1", requestbody, responseBody);
		Assert.assertEquals(StatusCode,201);
	}

	public static void responseBodyValidator(String responseBody) {
		// TODO Auto-generated method stub
		
		JsonPath jsp =new JsonPath (responseBody);
		String res_name =jsp.getString("name");
		String res_job =jsp.getString("job");
		int res_id =jsp.getInt("id");
		String res_createdAt =jsp.getString("createdAt");
		String actual_date =res_createdAt.substring(0,10);
		String current_date =LocalDate.now().toString();
		
		System.out.println("name : " +res_name +"\n job : " +res_job +"\n createdAt :" +res_createdAt +"\n Actual Date :" +actual_date + "\n Current Date :" +current_date);
		
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "leader");
		Assert.assertNotEquals(res_id, "id is not null");
		Assert.assertEquals(current_date, actual_date);
		
	}

}
