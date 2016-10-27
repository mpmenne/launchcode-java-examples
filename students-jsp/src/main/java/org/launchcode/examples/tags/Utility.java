package org.launchcode.examples.tags;

public class Utility {

    private Utility() {
    }

    public static boolean validateUrl(String url) {
        return url != null && (url.startsWith("http://") || url.startsWith("https://"));
    }
}
