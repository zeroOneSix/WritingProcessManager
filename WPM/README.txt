The Writing Process Manager (WPM) is used to control the process of a writing idea from first conception to publication, which includes the following steps:

1)Review -- this contains a folder watcher* that adds any new documents added to this dir to the database and displays them in the GUI.
2)Drafts -- the next stage is drafts. When finished a user can select which draft version should be prepared for submission.
3)Submission Ready -- the text is ready for submission. A new submission can also be prepared here.
4)Submissions -- all pieces that have been send away and still awaiting response.
5)Accepted Submission -- All pieces that have been accepted, i.e. published.
6)Rejected Submission -- submitted pieces that have been rejected.

*The folder watcher is used with credit to Bill Bejeck. Please see other Licence.txt. The project can be found at: 
https://github.com/bbejeck/Java-7

The WPM contains 4 projects

1)InstallWPM
2)WPM
3)WPMGUI
4)WPMTools

1)Install WPM

As the name suggests this sets up the WPM for first time use. Two MongoDB collections are created and the defined folders are scanned for any exisiting documents.

Limitations and some future developments

1)Branched installation to create the folder structure used in WPM
2)At the moment all path locations (directories, etc) are provided as strings via the DirectoryLocations class in WPMTools and are hardcoded. There should be an option to define these during installation and change them during runtime via a setting option in the GUI

2)WPM
Contains the main functionality of the program. The program uses Guva's eventbus to listen and execute the requests springing from the GUI -- meaning that each step has its own set of subscribers and events defined in the Management package. 

There are is also the "Registry" classes, which are used to communicate with the MongoDB collections

Limitation and some further developments

1)The Registry classes are still a bit messy and need to be cleaned up
2)Additionally there is redundent information in the MongoDb collections that should be removed.
3) There is a mix of File interactions (I started using Apache Commons IO half way through the development and need to go pack and harmonise the design)
4)The addition of new features, such as being able to generate reports or CVs from the data

3)WMPGUI

Again as the name suggests this is the front end, build using JavaFX. This contains the controler classes and models for the frontend design and is used to trigger the corresponding requests in the WPM project.

Limitations and some further developments

1)A nicer design, as the one currently is rather ugly
2)Extended functionality -- menubar, a settings option, plus new features.

4) WPMTools

A set of helper classes, such as the location of the directories, MongoDb connection settings, and some file and date helpers. Basically a project where I can add any tools or functionality I need when required. 

