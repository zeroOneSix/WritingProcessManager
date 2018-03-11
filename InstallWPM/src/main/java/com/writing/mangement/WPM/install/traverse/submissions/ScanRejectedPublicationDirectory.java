package com.writing.mangement.WPM.install.traverse.submissions;

public class ScanRejectedPublicationDirectory extends ScanSubmissionDirectory {
	public ScanRejectedPublicationDirectory(String subFictionDir, String subPoetryDir) {
		super.subDirFiction = subFictionDir;
		super.subDirPoetry = subPoetryDir;
	}
}
