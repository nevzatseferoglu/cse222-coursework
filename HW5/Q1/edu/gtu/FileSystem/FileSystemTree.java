package edu.gtu.FileSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Representation of file-system class.
 */
public class FileSystemTree {

    /**
     * Root directory of internal file-system.
     */
    FileNode rootDir;


    /**
     * Convert the given full-path to array of String with splitting '/' character.
     * @param fullPath an incremental path of directory or file.
     * @return array of String
     */
    private String[] getListOfFullPath( String fullPath ) {
        try {

            if( !fullPath.contains("/") ) {
                throw new Exception("invalid full-path");
            }

            return fullPath.split("/");
        }
        catch ( Exception ex ) {
            System.out.println("Invalid input , " + ex.getMessage() );
            System.exit( 1 );
        }

        return null;
    }

    /**
     * Return the last token of the given full-path.
     * @param fullPathList full-path as an array
     * @return last token of full-path.
     */
    private String getLastTokenOfFullPath( String[] fullPathList ) {
        return fullPathList[ fullPathList.length - 1 ];
    }

    /**
     * Return the last token of given path.
     * @param fullPath full-path
     * @return last token of given String.
     */
    private String fullPathToLastToken( String fullPath ) {
        return getLastTokenOfFullPath( getListOfFullPath(fullPath) );
    }

    /**
     * Return the given directory node with given String representation.
     * @param fullPath full-path as String
     * @param node Starting node for tacking given directory.
     * @return if found returns node otherwise return null.
     */
    private FileNode fromDirPathToNode( String fullPath , FileNode node ) {

        FileNode returnNode = null;

        if( fullPath.equals( node.nameOfIncrementalPath) ) {
            return node;
        }

        for( int i = 0 ; i < node.directories.size() && ( returnNode == null ) ; ++i ) {
            returnNode = fromDirPathToNode( fullPath , node.directories.get(i) );
        }

        return returnNode;
    }


    /**
     * Return the given file node with given String representation.
     * @param fullPath full-path as String
     * @param node Starting node for tacking given file.
     * @return if found returns node otherwise return null.
     */
    private FileNode fromFilePathToNode( String fullPath , FileNode node ) {

        FileNode returnFileNode = null;

        for( FileNode fileNode : node.files ) {
            if( fileNode.nameOfIncrementalPath.equals( fullPath ))
                return fileNode;
        }

        for( int i = 0 ; i < node.directories.size() && ( returnFileNode == null ) ; ++i ) {
            returnFileNode = fromFilePathToNode( fullPath , node.directories.get(i) );
        }

        return returnFileNode;
    }

    /**
     * Return the previous path-name of given all full-path
     * @param fullPath full-path as String.
     * @return
     */
    private String getPreviousPath( String fullPath ) {

        String subString = fullPath.substring( 0 , fullPath.length() -  fullPathToLastToken( fullPath ).length() );

        while ( subString.length() >= 3 && subString.charAt( subString.length() - 2) == '/' ) {
            subString = subString.substring( 0, subString.length() - 1 );
        }

        return subString;
    }

    /**
     * Add a given directory to the file-system as node.
     * @param node A starting node for inserting.
     * @param newNode Node that will be added as directory.
     * @return true if it is added otherwise return false.
     */
    private boolean addDir( FileNode node , FileNode newNode ) {
        return node.addDir( newNode );
    }

    /**
     * Add a given file to the file-system as node.
     * @param node A starting node for inserting.
     * @param newNode Node that will be added as file.
     * @return true if it is added otherwise return false.
     */
    private boolean addFile( FileNode node , FileNode newNode ) {
        return node.addFile( newNode );
    }

    /**
     * Search the for the full path of given token as String.
     * @param token Searched token.
     * @param node A starting node for searching.
     * @return
     */
    private String searchPath( String token , FileNode node ) {

        String path = "";

        if( node.nameOfForm.equals( token ) ) {
            return node.nameOfIncrementalPath;
        }

        for( int i = 0 ; i < node.directories.size() && ( path.equals("") ) ; ++i) {
            path = searchPath( token , node.directories.get( i ) );
        }

        return path;
    }

    /**
     * Search given token and build a StringBuilder related to its path.
     * <p> It is a tail recursion , traversing is preordered. </p>
     * @param token Searched token.
     * @param node A starting node for searching.
     * @param str StringBuilder that will be built.
     */
    private void search( String token , FileNode node , StringBuilder str ) {

        if( node.toString().contains( token ) ) {
            str.append("dir - ").append(node.nameOfIncrementalPath, 0, node.nameOfIncrementalPath.length() - 1).append("\n");
        }

        for( int i = 0 ; i < node.files.size() ; ++i ) {
            if( node.files.get( i ).toString().contains(token) ) {
                str.append("file - ").append(node.files.get( i ).nameOfIncrementalPath).append("\n");
            }
        }

        for( int i = 0 ; i < node.directories.size() ; ++i) {
            search( token , node.directories.get( i ) , str );
        }
    }

    /**
     * Print the whole file system recursively.
     * @param node A starting node for traversing on the system.
     * @param depth initial depth of system , it enhances the output format of file.
     * @param str StringBuilder that will be built.
     */
    private void printFileSystem( FileNode node , int depth , StringBuilder str ) {

        str.append("|___ ".repeat(Math.max(0, depth)));
        str.append( node );
        str.append( "\n" );

        for( FileNode file : node.files ) {

            str.append("|___ ".repeat( Math.max(0, depth + 1) ));
            str.append( file );
            str.append( "\n" );
        }

        for( FileNode dir : node.directories ) {
            printFileSystem( dir , depth + 1 , str );
        }
    }

    /**
     * Internal FileNode class.
     */
    protected static class FileNode implements Serializable {

        /**
         * List of directories.
         */
        private ArrayList<FileNode> directories;

        /**
         * List of files.
         */
        private ArrayList<FileNode> files;

        /**
         * An actual name of directory or file.
         */
        String nameOfForm;

        /**
         * Incremental path-name of file or directory.
         */
        String nameOfIncrementalPath;

        /**
         * Keep status of structure.
         */
        Boolean isDir;

        /**
         * Constructor for FileNode class.
         * @param nameOfForm An actual name of the structure.
         * @param nameOfIncrementalPath incremental path format of given structure.
         * @param isDir Determination of structure type that will be created.
         */
        FileNode( String nameOfForm , String nameOfIncrementalPath , boolean isDir ) {

            if( isDir ) {
                directories = new ArrayList<>();
            }

            files = new ArrayList<>();
            this.nameOfForm = nameOfForm;
            this.nameOfIncrementalPath = nameOfIncrementalPath;
            this.isDir = isDir;

        }

        /**
         * Add a directory to list directory of current node.
         * @param newDir Directory that will be added.
         * @return true if added otherwise return false.
         */
        boolean addDir( FileNode newDir ) {

            if( !directories.contains( newDir ) ) {
                directories.add( newDir );
                return true;
            }

            return false;

        }

        /**
         * Add a file to list directory of current node.
         * @param newFile File that will be added.
         * @return true if added otherwise return false.
         */
        boolean addFile( FileNode newFile  ) {

            if( !files.contains( newFile ) ) {
                files.add( newFile );
                return true;
            }

            return false;
        }

        /**
         * Determine equality , considering both nameOfForm and nameOfIncrementalPath , node with another node.
         * @param obj object that will be investigated with current node.
         * @return true if equals otherwise false.
         */
        @Override
        public boolean equals(Object obj) {

            if( obj == this ) {
                return true;
            }

            if( obj == null ) {
                return false;
            }

            if( !(obj instanceof FileNode) ) {
                return false;
            }

            FileNode cmpObj = (FileNode)obj;

            return nameOfIncrementalPath.equals( cmpObj.nameOfIncrementalPath ) && nameOfForm.equals( cmpObj.nameOfForm )
                    && isDir.equals( cmpObj.isDir );

        }

        /**
         * String representation of file.
         * @return nameOfForm of node.
         */
        @Override
        public String toString() {
            return nameOfForm;
        }

    }

    /**
     * Constructor for building file-system with given root name.
     * @param rootName A directory name that will used as a root name of the file-system.
     */
    public FileSystemTree( String rootName ) {
        rootDir = new FileNode( rootName , rootName + "/" , true );
    }


    /**
     * Add a directory with according to path.
     * @param fullPath full-path
     */
    public void addDir( String fullPath ) {

        String path = getPreviousPath( fullPath );

        if( searchPath( fullPathToLastToken( path ) , rootDir ).equals( "" ) ) {
            System.out.println("addDir: cannot create directory " + "‘"+fullPath+"’" + ": No such directory ");
            return ;
        }

        FileNode newNode = new FileNode( fullPathToLastToken( fullPath ) , fullPath + "/" , true);

        if( !addDir(Objects.requireNonNull( fromDirPathToNode( path, rootDir ) ), newNode ) ) {
            System.out.println("addDir: cannot create directory " + "‘"+fullPath+"’" + ": Directory exists ");
        }
    }

    /**
     * Add a file with according to path.
     * @param fullPath full-path
     */
    public void addFile( String fullPath ) {

        String path = getPreviousPath( fullPath );

        if( searchPath( fullPathToLastToken( path ) , rootDir ).equals( "" ) ) {
            System.out.println("addFile: cannot create file " + "‘"+fullPath+"’" + ": No such directory ");
            return ;
        }

        FileNode newNode = new FileNode( fullPathToLastToken( fullPath ) , fullPath , false);

        if( !addFile(Objects.requireNonNull( fromDirPathToNode( path, rootDir ) ), newNode ) ) {
            System.out.println("addFile: cannot create file " + "‘"+fullPath+"’" + ": File exists ");
        }
    }

    /**
     * Search given token in entire system , print the name of the
     * directories and files that contains given token.
     * @param token searched token as String
     */
    public void search( String token ) {

        StringBuilder result = new StringBuilder();

        if( rootDir != null ) {

            search( token , rootDir , result );
            if( result.length() != 0 ) {
                System.out.println( result );
                return;
            }
        }

        System.out.println("search: " + "‘"+token+"’" + ": No such file or directory" + '\n');
    }


    /**
     * Remove given directories or file with given full-path.
     * @param fullPath full-path
     */
    public void remove( String fullPath ) {

        StringBuilder str = new StringBuilder( fullPath + "/");
        FileNode node = fromDirPathToNode( str.toString(), rootDir );

        if( node == null ) {
            node = fromFilePathToNode( fullPath , rootDir );
        }

        if( node == null ) {
            System.out.println("remove: cannot remove " + "‘" + fullPath + "’" + ": No such file or directory");
            return;
        }
        else if( node.equals( rootDir ) ) {
            System.out.println("remove: permission denied " + "‘" + fullPath + "’" + ": Root directory cannot be removed");
            return;
        }

        FileNode previousDir ;

        if( node.isDir ) {

            str = new StringBuilder( getPreviousPath( str.toString() ));
            previousDir = fromDirPathToNode( str.toString() , rootDir );

            str.replace(0,str.length(),"");

            printFileSystem( node , 0 , str );
            System.out.println( str );

            System.out.println("Above , all directories and files will be removed , y or n ?");
            Scanner in = new Scanner(System.in);

            System.out.print("Input : ");
            String input = in.next();

            while ( !input.equals("y") && !input.equals("Y") && !input.equals("n") && !input.equals("N") ) {
                System.out.print("Input : ");
                input = in.next();
            }

            if( input.equals("y") || input.equals("Y") ) {
                previousDir.directories.remove( node );
            }
        }
        else {
            str = new StringBuilder( getPreviousPath( str.toString().substring( 0,str.length() - 1 ) ));
            previousDir = fromDirPathToNode( str.toString() , rootDir );

            previousDir.files.remove( node );
        }

    }

    /**
     * Print the entire file-system as console output.
     */
    public void printFileSystem() {
        System.out.println( this.toString() );
    }

    /**
     * Return the entire file-system as a String.
     * @return String representation of file-system.
     */
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("==========================\n");
        printFileSystem( rootDir , 0 ,str);
        str.append("==========================\n");

        return str.toString();

    }
}
