import edu.gtu.FileSystem.FileSystemTree;

public class Main {


    public static void main( String[] argv ) {

        System.out.println();
        System.out.println("FileSystem Test");
        System.out.println("===============\n");

        System.out.println("Creating file system with constructor");
        System.out.println("Root name of file : \"root\" ");
        FileSystemTree fileSystem = new FileSystemTree("root");
        System.out.println();


        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();


        System.out.println("- addDir(\"root/Desktop\")");
        fileSystem.addDir("root/Desktop");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();


        System.out.println("- addDir(\"root/Desktop/HWs\")");
        fileSystem.addDir("root/Desktop/HWs");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addDir(\"root/GTU\")");
        fileSystem.addDir("root/GTU");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addDir(\"root/Pictures\")");
        fileSystem.addDir("root/Pictures");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addDir(\"root/Pictures/Gebze\")");
        fileSystem.addDir("root/Pictures/Gebze");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addFile(\"root/Pictures/Gebze/pic1.png\")");
        System.out.println("- addFile(\"root/Pictures/Gebze/pic2.png\")");
        System.out.println("- addFile(\"root/Pictures/Gebze/pic3.png\")");
        fileSystem.addFile("root/Pictures/Gebze/pic1.png");
        fileSystem.addFile("root/Pictures/Gebze/pic2.png");
        fileSystem.addFile("root/Pictures/Gebze/pic3.png");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addFile(\"root/Desktop/HWs/HW1.pdf\")");
        fileSystem.addFile("root/Desktop/HWs/HW1.pdf");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addFile(\"root/Desktop/HWs/HW2.pdf\")");
        fileSystem.addFile("root/Desktop/HWs/HW2.pdf");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addFile(\"root/GTU/Project.pdf\")");
        fileSystem.addFile("root/GTU/Project.pdf");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- remove(\"root/Pictures/Gebze/pic3.png\")");
        fileSystem.remove("root/Pictures/Gebze/pic3.png");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();


        System.out.println("- remove(\"root/Pictures/Gebze\")");
        fileSystem.remove("root/Pictures/Gebze");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- search(\"HW\")");
        fileSystem.search("HW");

        System.out.println("- search(\".pdf\")");
        fileSystem.search(".pdf");

        System.out.println("- search(\"CSE241\")");
        fileSystem.search("CSE241");

        System.out.println("- printFileSystem()");
        fileSystem.printFileSystem();


        System.out.println("Invalid Command Testing");
        System.out.println("=======================\n");

        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addDir(\"root/Home/Games\")");
        fileSystem.addDir("root/Home/Games");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- addFile(\"root/Home/regulation.pdf\")");
        fileSystem.addFile("root/Home/regulation.pdf");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- remove(\"root/Home\")");
        fileSystem.remove("root/Home");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("- remove(\"root/regulation.pdf\")");
        fileSystem.remove("root/regulation.pdf");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

        System.out.println("Attempting to delete root directory");
        System.out.println("- remove(\"root\")");
        fileSystem.remove("root");
        System.out.println("Current System : ");
        System.out.println(fileSystem.toString());
        System.out.println();

    }
}
