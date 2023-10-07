package week2.jsonParsing.fileProcessing;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTraversalExample {

    public static void streamTraverseFile(String directory) {
        Path p = Paths.get(directory);
        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(p);
            for (Path path : paths) {
                if (!Files.isDirectory(path) && (path.toString().endsWith(".java") || path.toString().endsWith(".json"))) {
                    System.out.println(path);
                } else {
                    streamTraverseFile(path.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        DirectoryStreamTraversalExample.streamTraverseFile("CS601/week2/jsonParsing");
    }
}
