package exerciseDbCoreData;

import java.util.*;

public final class ExerciseDbCoreData {

	public static final String filePath = "../exercisedb/" ;
	public static final String file = "../exercisedb/exercises.db";

	public static final String tempfile = "../exercisedb/tempexercises.db" ;
	public static final String tempfilealt = "../exercisedb/tempexercisesalt.db";


	public static final String dataIn = "{" ;
	public static final String dataOut = "}" ;
	public static final String lineSep = "\n" ;

	public static final String sepIn = "(" ;
	public static final String sepOut = ")" ;
	public static final String exIn = "[" ;
	public static final String exOut = "]" ;
	public static final String exSep = ":" ;
	public static final String tagSep = "," ;

	public static final String tagBase = "Exercises" ;
	public static final String tagTags = "Tags" ;
	public static final String sectionTags = "Section" ;
	public static final String workoutTags = "Workouts" ;
	public static final String workoutName = "WorkoutName" ;
	public static final String topName = "WorkoutStore" ;
	
	
	// prevent instantiation of class
	private ExerciseDbCoreData() {        
    }

	public static class BaseEx
    {
        public String exName;
        public Vector exTags;
    };
	
	
}
