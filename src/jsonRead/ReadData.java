package jsonRead;

//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadData {
	
	public static void main(String[] args) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try (FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Comeback\\src\\jsonRead\\testData.json")) {
			
			TestPOJO tp = objectMapper.readValue(fis, TestPOJO.class);
			System.out.println(tp.getname());
			
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
