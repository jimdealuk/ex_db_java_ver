package exerciseDbFileHandler;

import java.io.*;
import java.nio.file.Files;

import exerciseDbHandlerBase.ExerciseDbHandlerBase;
import exerciseDbCoreData.ExerciseDbCoreData;



public class ExerciseDbFileHandler implements ExerciseDbHandlerBase{

	@Override
	public boolean ReadExDb() {
		// TODO Auto-generated method stub
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
								
				if(line.contains(exerciseDbCoreData.ExerciseDbCoreData.tagBase))
				{
					System.out.println("getting exercises");					
					while (!line.contains(exerciseDbCoreData.ExerciseDbCoreData.dataOut)) 
					{
						
						String fst = String.valueOf(line.charAt(0));
						if( fst.contains(exerciseDbCoreData.ExerciseDbCoreData.sepIn))
						{
							int sep = line.indexOf(exerciseDbCoreData.ExerciseDbCoreData.exSep);
							String exName = line.substring(1, sep);
							System.out.println(exName);
							
							String tgs = line.substring(sep+1,line.length());							
							
							sep = tgs.indexOf(exerciseDbCoreData.ExerciseDbCoreData.tagSep);
							
							while(sep>0)
							{
								String ex = tgs.substring(0,sep);
								System.out.println(ex);
								tgs = tgs.substring(sep + 1, tgs.length());									
								sep = tgs.indexOf(exerciseDbCoreData.ExerciseDbCoreData.tagSep);								
							}
							
							sep = tgs.indexOf(exerciseDbCoreData.ExerciseDbCoreData.sepOut);
							tgs = tgs.substring(0, sep);									
							System.out.println(tgs);						
						}
						// read next line
						line = reader.readLine();
					}															
					System.out.println("got exercises");
				}				
				
				if(line.contains(exerciseDbCoreData.ExerciseDbCoreData.tagTags))
				{
					System.out.println("getting tags");
					// we want next line - NOT "Tags" marker
					line = reader.readLine();					
										
					while (!line.contains(exerciseDbCoreData.ExerciseDbCoreData.dataOut)) 
					{
						if(line.contains(exerciseDbCoreData.ExerciseDbCoreData.tagSep))
						{
							line = line.substring(0, line.length()-1);																
						}
						
						System.out.println(line);
						// read next line
						line = reader.readLine();
					}					
					System.out.println("got tags");										
				}
				
				if(line.contains(exerciseDbCoreData.ExerciseDbCoreData.workoutTags))
				{
					System.out.println("getting workouts");
					// we want next line - NOT "Workouts" marker
					line = reader.readLine();					
					
//					(Jim:(Section:[Warmup:(cycle)][Main:(press)(deadlift)(curl)]))
//					(Fred:(Section:[Warmup:(row)][Main:(squat)(deadlift)(flye)]))
					

					while (!line.contains(exerciseDbCoreData.ExerciseDbCoreData.dataOut)) 
					{
						System.out.println(line);
						int endName = line.indexOf(exerciseDbCoreData.ExerciseDbCoreData.exSep);
						if(endName > 1)
						{
							String name = line.substring(1,endName);
							System.out.println(name);

							int endSectionTag = line.indexOf(exerciseDbCoreData.ExerciseDbCoreData.sectionTags);
							line = line.substring(endSectionTag+8, line.length()-1);																
							System.out.println(line);

							int endSection = line.indexOf(exerciseDbCoreData.ExerciseDbCoreData.exOut);

							while(endSection>0)
							{
								
								String section = line.substring(1,endSection);
								System.out.println(section);
								
								int endSectionName = section.indexOf(exerciseDbCoreData.ExerciseDbCoreData.exSep);
								String sectionName = section.substring(0,endSectionName);
								System.out.println(sectionName);

								section = section.substring(endSectionName+1,section.length());
								System.out.println(section);
								
								int exBegin = section.indexOf(exerciseDbCoreData.ExerciseDbCoreData.sepIn);
								int exEnd = section.indexOf(exerciseDbCoreData.ExerciseDbCoreData.sepOut);
								
								while((exBegin>0)||(exEnd>0))
								{
									
									String ex = section.substring(exBegin+1,exEnd);
									System.out.println(ex);

									section = section.substring(exEnd+1,section.length());
									

									exBegin = section.indexOf(exerciseDbCoreData.ExerciseDbCoreData.sepIn);
									exEnd = section.indexOf(exerciseDbCoreData.ExerciseDbCoreData.sepOut);
								}
								
								line = line.substring(endSection+1, line.length());																
								endSection = line.indexOf(exerciseDbCoreData.ExerciseDbCoreData.exOut);
																
							}							
						}
						
						// read next line
						line = reader.readLine();
					}					
					System.out.println("got workouts");										
				}
								
				// read next line
				line = reader.readLine();				
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		return ret;
	}

	private String String(char charAt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean WriteExDb() {
		// TODO Auto-generated method stub
		return false;
	}

}
