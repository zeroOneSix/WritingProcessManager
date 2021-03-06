package com.writing.mangement.WPM.install.traverse.writingPieces;

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
import com.writing.documents.WritingPiece;
import com.writing.documents.factory.WritingPieceFactory;
import com.writing.mangement.WPM.install.traverse.ScanDirectory;
import com.writing.registry.WritingPieceRegistry;

public abstract class ScanWritingPieceDirectory implements ScanDirectory {

	Status status;
	
	public void traverse(String dir, Status status) {
		this.status = status;
		Path p = Paths.get(dir);
		addToReg(discoverWritingPieces(p));
	}
	
	public void addToReg(Set<Path> paths) {
		for(Path path : paths) {
			WritingPiece wp = WritingPieceFactory.create(path, status);
			if(wp != null) {
				WritingPieceRegistry.insert(wp);
			}
		}
	}
	
	public Set<Path> discoverWritingPieces(Path path) {
		final Set<Path> discoveredPaths = new HashSet<Path>();
		SimpleFileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
			 @Override
		      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
		          throws IOException {	
				 discoveredPaths.add(file);				
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
