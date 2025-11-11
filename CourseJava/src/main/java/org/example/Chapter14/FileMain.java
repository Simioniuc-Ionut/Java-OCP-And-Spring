package org.example.Chapter14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class FileMain {
    public static void fileEx1(File file)  {
        if(file.exists()) {
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.isDirectory());
            System.out.println(file.getParent());
            if(file.isFile()) {
                System.out.println("Size _ " + file.length());
                System.out.println("Last modified: " + file.lastModified());
            } else {
                for(File subfile : file.listFiles()) {
                    System.out.println( "  " + subfile.getName());
                }
            }
        }
    }

    public static void filesNIOEx1(Path path) throws IOException{
        if(Files.exists(path)){
            System.out.println(path.toAbsolutePath());
            System.out.println(Files.isDirectory(path));
            System.out.println(path.getParent());
            if(Files.isRegularFile(path)){
                System.out.println("Size : " + Files.size(path));
                System.out.println(Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println(p.getFileName()));
                }
            }
        }
    }

    void move(Path source, Path target) throws IOException {
        Files.move(source, target,
                LinkOption.NOFOLLOW_LINKS,
                StandardCopyOption.ATOMIC_MOVE);
    }
    static void main() throws IOException {

        FileWriter file = new FileWriter("newFile.txt");
        file.write("Hello");
        file.close();
        FileReader flr = new FileReader("newFile.txt");
        System.out.println(flr.readAllAsString());

        File f = new File("data.txt");
        f.createNewFile();
        fileEx1(f);
        filesNIOEx1(f.toPath());
//        DataInputStream
        Console c =System.console();
    }
}
