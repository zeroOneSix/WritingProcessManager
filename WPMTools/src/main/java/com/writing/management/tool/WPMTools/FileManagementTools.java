package com.writing.management.tool.WPMTools;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class FileManagementTools {

	public static Set<Path> scanDirForFiles(Path path) throws IOException{
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
	/**
	 * Removes all files within a directory and then the directory itself given a path
	 * @param path - Path of the root directory that should be deleted, including all files inside.
	 * @throws IOException
	 */
	public static void removeRecursive(Path path) throws IOException {
		
		SimpleFileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {	
					Files.delete(file);
					return FileVisitResult.CONTINUE;
		      }     
		      @Override
		      public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
		      {
		      // try to delete the file anyway, even if its attributes
		      // could not be read, since delete-only access is
		      // theoretically possible
		      Files.delete(file);
		      return FileVisitResult.CONTINUE;
		      }
		      @Override
		      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
		      {
		    	  if (exc == null){
		    		  Files.delete(dir);
		    		  return FileVisitResult.CONTINUE;
		    	  }else
		    	  {
		    		  // directory iteration failed; propagate exception
		    		  throw exc;
		    	  }
		      }
		};
		try {
	    	Files.walkFileTree(path, fv);
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public static String move(String baseTargetDir, String sourceDir) throws IOException{
		final Path sourceDirPath = Paths.get(sourceDir);
		final String targetDir = baseTargetDir + "\\" + sourceDirPath.toFile().getName();
		final Path targetDirPath = Paths.get(targetDir);
		try {
			//Create Directory for Submission in target(either accepted or rejected dir)
			if(!targetDirPath.toFile().exists()) {
				Files.createDirectory(targetDirPath);
			}else {
				throw new IOException(targetDir + " already exists");
			}
			//Copy Files from Source Directory to newly created one
			SimpleFileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
				 @Override
			      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			          throws IOException {	
					 	String newFileLocation = targetDir + "\\" + file.getFileName();
					 	Path newFileLocationPath = Paths.get(newFileLocation);
					 	Files.copy(file, newFileLocationPath);	 
					 	return FileVisitResult.CONTINUE;
			      }
			    };
			    try {
			    	Files.walkFileTree(sourceDirPath, fv);
			    }catch(IOException e) {
			    	e.printStackTrace();
			    }
			//Delete Submission Dir
			removeRecursive(Paths.get(sourceDir));
			}
			catch (IOException e) {
			e.printStackTrace();
		}
		return targetDir;
	}
}
