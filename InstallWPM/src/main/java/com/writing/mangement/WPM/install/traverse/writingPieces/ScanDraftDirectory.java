package com.writing.mangement.WPM.install.traverse.writingPieces;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

import com.writing.management.tool.WPMTools.DirectoryLocations;

public class ScanDraftDirectory extends ScanWritingPieceDirectory {

	@Override
	public Set<Path> discoverWritingPieces(Path path) {
		final Set<Path> discoveredPaths = new HashSet<Path>();
		SimpleFileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
			 @Override
		      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
		          throws IOException {
				 if(!dir.toString().equals(DirectoryLocations.getDocumentsForDraftingFiction()) && !dir.toString().equals(DirectoryLocations.getDocumentsForDraftingPoetry())) {
					discoveredPaths.add(dir);
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
