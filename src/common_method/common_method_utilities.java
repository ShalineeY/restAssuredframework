package common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class common_method_utilities {
	
	public static void EvidenceSheetCreator(String fileName, String request, String response) throws IOException
	{
		File newTextFile =new File("E:\\resframe27\\" +fileName + ".text");
		if (newTextFile.createNewFile())
		{
			FileWriter dataWriter =new FileWriter(newTextFile);
			dataWriter.write("Requestbody is : \n" +request+ "\n\n" );
			dataWriter.write("Responsebody is : \n" +response+ "\n\n");
			dataWriter.close();
			System.out.println("request and response body is saved in :" +newTextFile.getName());
			
		}
		else
		{
			System.out.println(newTextFile.getName() + " already exists tale a back up of it ! ");
		}
	}

}
