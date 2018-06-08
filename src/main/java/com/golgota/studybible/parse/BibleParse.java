package com.golgota.studybible.parse;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michael Jeszenka
 * <a href="mailto:michael@jeszenka.com">michael@jeszenka.com</a>
 * 2018.06.08.
 */
public class BibleParse {
    private static Pattern book = Pattern.compile("(^\\d+)\\D+(\\d+)\\D+(\\d+)\\W{2}(.*$)");

    private static void parse(String input) {

        Matcher matcher = book.matcher(input);
        matcher.find();
        System.out.println("extracted: " + matcher.group(0));
        System.out.println("book: " + matcher.group(1));
        System.out.println("chapter: " + matcher.group(2));
        System.out.println("verse #: " + matcher.group(3));
        System.out.println("verse: " + matcher.group(4)
                .replaceAll("õ", "ő")
                .replaceAll("û", "ű"));
    }

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src/main/resources/bibles/karoli.txt");
        Files.lines(path).limit(20).forEach(s -> parse(s));
    }
}
