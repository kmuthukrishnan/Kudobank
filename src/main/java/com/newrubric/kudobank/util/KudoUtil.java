package com.newrubric.kudobank.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class KudoUtil {
	private static Properties _PROP_QN_DIFFICULTY = new Properties();
	private static Properties _PROP_USERID_EMAIL = new Properties();
	private static Properties _PROP_USEREMAIL_ID = new Properties();
	private static Properties _PROP_EMAIL_URL = new Properties();
	private static Properties _PROP_EMAIL_NAME = new Properties();
	private static Properties _PROP_EMAIL_FOLLOWERS = new Properties();
	private static Properties _PROP_EMAIL_LEVEL = new Properties();
	private static Map<String, Set<String>> _MAP_GRADE_SUBJECT_USER = new HashMap<String, Set<String>>();
	
	public static Set<String> getUsersForGradeSubject(String gradeSubject) throws FileNotFoundException, IOException{
		if( (null == _MAP_GRADE_SUBJECT_USER)||(_MAP_GRADE_SUBJECT_USER.isEmpty())){
			prepareGradeSubjectUser();
		}
		return _MAP_GRADE_SUBJECT_USER.get(gradeSubject);
	}
	
	public static String getUserIdForEmail(String email) throws FileNotFoundException, IOException{
		if( (null == _PROP_USEREMAIL_ID)||(_PROP_USEREMAIL_ID.isEmpty())){
			loadUserProperties();
		}
		return _PROP_USEREMAIL_ID.getProperty(email);
	}
	
	public static String getUserNameForEmail(String email) throws FileNotFoundException, IOException{
		if( (null == _PROP_EMAIL_NAME)||(_PROP_EMAIL_NAME.isEmpty())){
			prepareEmailBasedDetailsUser();
		}
		String name = _PROP_EMAIL_NAME.getProperty(email);
		name = (name == null)?"":name.trim();
		name = name.replaceAll("\"", "");
		return name;
	}	
	
	public static String getUserImageUrlForEmail(String email) throws FileNotFoundException, IOException{
		if( (null == _PROP_EMAIL_URL)||(_PROP_EMAIL_URL.isEmpty())){
			prepareEmailBasedDetailsUser();
		}
		String url = _PROP_EMAIL_URL.getProperty(email);
		url = (url == null)?"":url.trim();
		url = url.replaceAll("\"", "");
		return url;
	}		
	public static String getUserLevelForEmail(String email) throws FileNotFoundException, IOException{
		if( (null == _PROP_EMAIL_LEVEL)||(_PROP_EMAIL_LEVEL.isEmpty())){
			prepareEmailBasedDetailsUser();
		}
		String level = _PROP_EMAIL_LEVEL.getProperty(email);
		level = (level == null)?"":level.trim();
		return level;
	}	
	
	public static int getUserFollowerForEmail(String email) throws FileNotFoundException, IOException{
		if( (null == _PROP_EMAIL_FOLLOWERS)||(_PROP_EMAIL_FOLLOWERS.isEmpty())){
			prepareEmailBasedDetailsUser();
		}
		String level = _PROP_EMAIL_FOLLOWERS.getProperty(email);
		level = (level == null)?"":level.trim();
		int follower = 0;
		try{
			follower = Integer.valueOf(level);
		}catch(Exception ex){
			
		}
		return follower;
	}		
	public static String getDifficulty(String questionId) throws FileNotFoundException, IOException{
		int score = getDifficultyScore(questionId);
		String difficultyText = "";
		if((80 >= score)&&(score <= 100)){
			difficultyText = "EASY";
		}else if((50 >= score)&&(score < 80)){
			difficultyText = "MEDIUM";
		}if((20 >= score)&&(score < 50)){
			difficultyText = "DIFFICULT";
		}
		
		return difficultyText;
	}
	public static int getDifficultyScore(String questionId) throws FileNotFoundException, IOException{
		int score = 0;
		if( (null == _PROP_QN_DIFFICULTY)||(_PROP_QN_DIFFICULTY.isEmpty())){
			loadProperties();
		}
		String value = _PROP_QN_DIFFICULTY.getProperty(questionId);
		if((null != value)&&(!value.trim().isEmpty())){
			score = Integer.valueOf(value);
		}
		return score;
	}

	private static void loadProperties() throws FileNotFoundException, IOException {
		if(null == _PROP_QN_DIFFICULTY){
			_PROP_QN_DIFFICULTY = new Properties();
		}
		_PROP_QN_DIFFICULTY.load(new FileInputStream(new File("questiondifficulty.properties")));
	}
	
	private static void loadUserProperties() throws FileNotFoundException, IOException {
		if(null == _PROP_USERID_EMAIL){
			_PROP_USERID_EMAIL = new Properties();
		}
		_PROP_USERID_EMAIL.load(new FileInputStream(new File("user.properties")));
		Set keys = _PROP_USERID_EMAIL.keySet();
		for (Object object : keys) {
			String key = (String) object;
			String value = _PROP_USERID_EMAIL.getProperty(key);
			_PROP_USEREMAIL_ID.put(value, key);
		}
	}
	
	private static void prepareGradeSubjectUser(){
		
		    try {

		      File file = new File("gradesubjectuser.txt");
		      FileReader fileReader = new FileReader(file);
		      BufferedReader bufferedReader = new BufferedReader(fileReader);
		      StringBuffer stringBuffer = new StringBuffer();
		      String line;
		      while ((line = bufferedReader.readLine()) != null)
		      {
		        String[] gradesubjectuser = line.split(":");
		        String gradeSubject = gradesubjectuser[0];
		        String user = gradesubjectuser[1];
		        Set<String> existingUsers = _MAP_GRADE_SUBJECT_USER.get(gradeSubject);
		        if(null == existingUsers){
		        	existingUsers = new TreeSet<String>();
		        }
		        existingUsers.add(user);
		        _MAP_GRADE_SUBJECT_USER.put(gradeSubject, existingUsers);
		      }
		      fileReader.close();
		      System.out.println("Contents of file:");
		      System.out.println(stringBuffer.toString());
		    } catch (IOException e) {
		      e.printStackTrace();
		    }		
		    		
	}
	
	private static void prepareEmailBasedDetailsUser() throws FileNotFoundException, IOException{
		_PROP_EMAIL_URL = new Properties();
		_PROP_EMAIL_NAME = new Properties();
		_PROP_EMAIL_FOLLOWERS = new Properties();
		_PROP_EMAIL_LEVEL = new Properties();
		_PROP_EMAIL_URL.load(new FileInputStream(new File("emailImageUrl.properties")));
		_PROP_EMAIL_NAME.load(new FileInputStream(new File("emailName.properties")));
		_PROP_EMAIL_FOLLOWERS.load(new FileInputStream(new File("emailFollowers.properties")));
		_PROP_EMAIL_LEVEL.load(new FileInputStream(new File("emailUserLevel.properties")));
	}	
}
