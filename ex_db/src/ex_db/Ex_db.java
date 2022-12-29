package ex_db;

import exerciseDbFileHandler.ExerciseDbFileHandler;

public class Ex_db {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		exerciseDbFileHandler.ExerciseDbFileHandler ex_db = new exerciseDbFileHandler.ExerciseDbFileHandler();

		ex_db.ReadExDb();
		
		
		ex_db.WriteExDb();
	}

}
