package io.cucumber.skeleton;

import java.io.*;
import java.util.*;
import java.nio.file.Files;

public class ResourceManager {
    private final Map<String, Object> cache = new HashMap<>();

    public Object loadResource(String name) {
        if (cache.containsKey(name)) { return cache.get(name); }
        File folder = new File("./src/test/resources");
        File[] files = folder.listFiles((dir, f) -> f.startsWith(name + "."));
        if (files == null || files.length == 0) { return null; }
        String extension = files[0].getName().substring(
            files[0].getName().lastIndexOf('.') + 1);
        Object content = null;
        switch (extension) {
            case "txt":
                content = readTextFile(files[0]);
                break;
            default:
                content = readFileAsByteArray(files[0]);
                break;
        };
        cache.put(name, content);
        return content;
    }

    private String readTextFile(File file) {
        try { return Files.readString(file.toPath());
        } catch (Exception e) { return null; }
    }

    private byte[] readFileAsByteArray(File file) {
        try { return Files.readAllBytes(file.toPath());
        } catch (Exception e) { return null; }
    }
}