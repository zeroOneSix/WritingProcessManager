package com.writing.mangement.WPM.install.traverse.submissions;

public class ScanPublicationDirectory extends ScanSubmissionDirectory{
	
	public ScanPublicationDirectory(String subFictionDir, String subPoetryDir) {
		super.subDirFiction = subFictionDir;
		super.subDirPoetry = subPoetryDir;
	}
}
