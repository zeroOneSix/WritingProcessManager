package com.writing.mangement.WPM.install.traverse.submissions;

public class ScanSubmittedDocumentsDirectory extends ScanSubmissionDirectory{
	
	public ScanSubmittedDocumentsDirectory(String fictionDirLocation, String poetryDirLocation) {
		super.subDirFiction = fictionDirLocation;
		super.subDirPoetry = poetryDirLocation;
	}

}
