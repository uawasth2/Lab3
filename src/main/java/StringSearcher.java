    import java.io.IOException;

    import java.net.URL;

    import java.util.Scanner;

public class StringSearcher {
    public static void main(String[] args) {

    }

    public static int wordFinder(String url, String searchFor) {
        int counter = 0;
        String input = urlToString(url).toLowerCase();
        searchFor = searchFor.toLowerCase();
        while(input.indexOf(searchFor) != -1) {
            counter++;
            input = input.substring(input.indexOf(searchFor), input.indexOf(searchFor) + searchFor.length());
        }
        return counter;
    }

    public static int wordCounter(String url) {
        String input = urlToString(url);
        int counter = 0;
        for (int point = 0; point < input.length(); point++) {
            if (input.charAt(point) == ' ') {
                counter++;
            }
        }
        return counter + 1;
    }

    public static int uniqueWords(String url) {
        String input = urlToString(url);
        String[] holder = input.split(" ");
        int counter  = 0;
        for(int x = 0; x < holder.length; x ++) {
            boolean hasBeenUsed = false;
            for(int y = x; y >= 0; y-- ) {
                if(holder[y].equals(holder[x])) {
                    hasBeenUsed = true;
                }
            }
            if(!hasBeenUsed) {
                counter++;
            }
        }
        return counter;
    }




    /**

     * Retrieve contents from a URL and return them as a string.

     *

     * @param url url to retrieve contents from

     * @return the contents from the url as a string, or an empty string on error

     */

    public static String urlToString(final String url) {

        Scanner urlScanner;

        try {

            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");

        } catch (IOException e) {

            return "";

        }

        String contents = urlScanner.useDelimiter("\\A").next();

        urlScanner.close();

        return contents;

    }

}
