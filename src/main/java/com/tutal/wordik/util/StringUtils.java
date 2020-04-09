package com.tutal.wordik.util;

public class StringUtils {

    public static String prepareFileName(String fileName) {

        return (StringUtils.cleanChar(fileName.substring(0, fileName.lastIndexOf(".")))).replaceAll("\\.", "") +
                fileName.substring(fileName.lastIndexOf("."));
    }

    private static String cleanChar(String linkName) {

        linkName = linkName.trim();

        linkName = linkName.replaceAll(" ", "-");
        linkName = linkName.replaceAll("ş", "s");
        linkName = linkName.replaceAll("ı", "i");
        linkName = linkName.replaceAll("ç", "c");
        linkName = linkName.replaceAll("ö", "o");
        linkName = linkName.replaceAll("ğ", "g");
        linkName = linkName.replaceAll("ü", "u");
        linkName = linkName.replaceAll("Ş", "S");
        linkName = linkName.replaceAll("İ", "I");
        linkName = linkName.replaceAll("Ç", "C");
        linkName = linkName.replaceAll("Ö", "O");
        linkName = linkName.replaceAll("Ğ", "G");
        linkName = linkName.replaceAll("Ü", "U");
        linkName = linkName.replaceAll("[^a-zA-Z0-9._/]", "-");

        try {
            linkName = java.net.URLEncoder.encode(linkName, "UTF-8");
        } catch (Exception ignored) {
        }

        return linkName;
    }

}
