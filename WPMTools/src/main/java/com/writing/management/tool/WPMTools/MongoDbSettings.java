package com.writing.management.tool.WPMTools;

public class MongoDbSettings {
	
	private static String HOST = "localhost";
	private static int PORT = 27017;
	private static String USERNAME = "WPMAdmin";
	private static char[] PASSWORD = "Operating2017".toCharArray();
	private static String DB_NAME = "WPMReg";
	
	private static String WRITING_PIECE_COLLECTION  = "WritingPieces";
	private static String SUBMISSIONS_COLLECTION = "Submissions";
	
	public static String getHOST() {
		return HOST;
	}
	public static int getPORT() {
		return PORT;
	}
	public static String getUSERNAME() {
		return USERNAME;
	}
	public static char[] getPASSWORD() {
		return PASSWORD;
	}
	public static String getDB_NAME() {
		return DB_NAME;
	}
	public static String getWRITING_PIECE_COLLECTION() {
		return WRITING_PIECE_COLLECTION;
	}
	public static String getSUBMISSIONS_COLLECTION() {
		return SUBMISSIONS_COLLECTION;
	}
	
	
}
