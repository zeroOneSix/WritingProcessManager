package com.writing.mangement.WPM.install.traverse.submissions;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

import com.writing.documents.Status;
import com.writing.documents.Submission;
import com.writing.documents.SubmittedResponse;
import com.writing.documents.WritingPiece;
import com.writing.documents.factory.SubmissionFactory;
import com.writing.documents.factory.WritingPieceFactory;
import com.writing.mangement.WPM.install.traverse.ScanDirectory;
import com.writing.registry.SubmissionRegistry;

public abstract class ScanSubmissionDirectory implements ScanDirectory {

	Status status;
	SubmittedResponse submittedResponse;
	public String subDirFiction;
	public String subDirPoetry;

	
	public void traverse(String dir, Status status, SubmittedResponse submittedResponse) {
		this.status = status;
		this.submittedResponse = submittedResponse;
		Path p = Paths.get(dir);
		addToReg(discoverWritingPieces(p));
	}
	
	public void addToReg(Set<Path> paths) {
		//TODO: process this properly for name
		for(Path path : paths) {
			Set<Path> writingPieces = getWritingPieces(path);
			for(Path p: writingPieces) {
				WritingPiece wp = WritingPieceFactory.create(p, status);
				Submission submission = SubmissionFactory.create(path.toString(), path.getFileName().toString(), submittedResponse);
				submission.setPieceSubmitted(wp);
				SubmissionRegistry.insert(submission);
			}
		}
	}
	
	public Set<Path> getWritingPieces(Path path) {
		final Set<Path> writingPieces = new HashSet<Path>();
		try {
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
				@Override
				 public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				          throws IOException {
					writingPieces.add(file);
					return FileVisitResult.CONTINUE;
				      }
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writingPieces;
	}
	
	public Set<Path> discoverWritingPieces(Path path) {
		final Set<Path> discoveredPaths = new HashSet<Path>();
		SimpleFileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
			 @Override
		      public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs)
		          throws IOException {	
				
				 if(!file.toString().equals(subDirFiction) && !file.toString().equals(subDirPoetry)) {
					 discoveredPaths.add(file);
					 }				
				 return FileVisitResult.CONTINUE;
		      }
		    };
		    try {
		    	Files.walkFileTree(path, fv);
		    }catch(IOException e) {
		    	e.printStackTrace();
		    }
			return discoveredPaths;
	}
	
}
