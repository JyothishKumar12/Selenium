package questions;

import java.io.File;

public class FileVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\JyothishKumar\\Downloads");
	File[] listFile =	file.listFiles();
	
	for (File file2 : listFile) {
		
		if(file2.getName().equals("samplefile.pdf")) {
			System.out.println("Downloaded and there");
			break;
		}
	}
	}

}
