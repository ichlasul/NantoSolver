package itb.ai.tubes1.boundary;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Output {

	public Output(String string) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("txt/output.txt", "UTF-8");
			writer.println(string);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported Encoding");
			e.printStackTrace();
		}
	}

}
