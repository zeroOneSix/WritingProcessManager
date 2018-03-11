package com.writing.management.WPM.watcher;

import java.nio.file.Paths;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import bbejeck.nio.files.directory.event.DirectoryEventWatcher;

public class ReviewWatcherProvider implements Provider<DirectoryEventWatcher>{
    private EventBus eventBus;
    private String  startPath;
    
    
    @Inject
    public ReviewWatcherProvider(EventBus eventBus, @Named("START_PATH") String startPath) {
        this.eventBus = eventBus;
        this.startPath = startPath;
    }
    
	@Override
	public DirectoryEventWatcher get() {
		return new ReviewWatcherImpl(eventBus, Paths.get(startPath));
	}

}
