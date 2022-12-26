package exerciseDbFileHandler;

import java.io.*;
import java.nio.file.Files;

import exerciseDbHandlerBase.ExerciseDbHandlerBase;
import exerciseDbCoreData.ExerciseDbCoreData;



public class ExerciseDbFileHandler implements ExerciseDbHandlerBase{

	@Override
	public boolean ReadExDb() {
		// TODO Auto-generated method stub
		System.out.print("this is");
				
		boolean ret = false;
		
		File file = new File(exerciseDbCoreData.ExerciseDbCoreData.filePath);
		
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			} catch (IOException e) 
			{
				// not there - can't create it..
				return false;
			}
		}
		
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(exerciseDbCoreData.ExerciseDbCoreData.file));
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
				
				
				// process line here
				
				
				
				
				
				
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		return ret;
	}

	@Override
	public boolean WriteExDb() {
		// TODO Auto-generated method stub
		return false;
	}

}
