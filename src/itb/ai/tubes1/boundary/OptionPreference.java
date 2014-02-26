import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class OptionPreference {
	private Integer maxLoop;
	private boolean manualLoop;
	private String pathKandidat;
	private String pathTempat;
	private String pathUmum;
	
	public OptionPreference() {		
		this.maxLoop = 0;
		this.manualLoop = false;
		this.pathKandidat = "";
		this.pathTempat = "";
		this.pathUmum = "";
	}	
			
	public OptionPreference(Integer maxLoop, boolean manualLoop, String pathKandidat, String pathTempat, String pathUmum) {		
		this.maxLoop = maxLoop;
		this.manualLoop = manualLoop;
		this.pathKandidat = pathKandidat;
		this.pathTempat = pathTempat;
		this.pathUmum = pathUmum;
	}

	public Integer getMaxLoop() { return maxLoop; }
	public void setMaxLoop(Integer maxLoop) { this.maxLoop = maxLoop; }
	
	public boolean isManualLoop() { return manualLoop; }
	public void setManualLoop(boolean manualLoop) { this.manualLoop = manualLoop; }
	
	public String getPathKandidat() { return pathKandidat; }
	public void setPathKandidat(String pathKandidat) { this.pathKandidat = pathKandidat; }
	
	public String getPathTempat() { return pathTempat; }
	public void setPathTempat(String pathTempat) { this.pathTempat = pathTempat; }
	
	public String getPathUmum() { return pathUmum; }
	public void setPathUmum(String pathUmum) { this.pathUmum = pathUmum; }
	
	public String buildString()
	{
		String data = maxLoop.toString() + "\r\n";
		data += manualLoop? "1\r\n" : "0\r\n";
		data += pathKandidat + "\r\n";
		data += pathTempat + "\r\n";
		data += pathUmum + "\r\n";
		
		return data;
	}
	
	public void readFromFile() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\temp.txt")));		
		String line = bufferedReader.readLine();									
		this.setMaxLoop(Integer.parseInt(line));
		line = bufferedReader.readLine();
		if (Integer.parseInt(line) == 1)
			this.setManualLoop(true);
		else
			this.setManualLoop(false);
		line = bufferedReader.readLine();
		this.setPathKandidat(line);
		line = bufferedReader.readLine();
		this.setPathTempat(line);
		line = bufferedReader.readLine();
		this.setPathUmum(line);
		bufferedReader.close();			
	}	
}
