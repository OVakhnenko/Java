package done;// Write a console application that takes a string and returns the number
// of unique characters in the string. It is expected that a string with
// the same character sequence may be passed several times to the method.
// Since the counting operation can be time consuming, the method should
// cache the results, so that when the method is given a string previously
// encountered, it will simply retrieve the stored result.
// Use collections and maps where appropriate.

import java.util.*;

public class MRString {
    private static final int COLLECTION_LEN = 500;
    private static final int STRING_LEN = 1000;

    private List<String> strings = new ArrayList<>();
    private Map<Integer, Integer> cache = new HashMap<>();
    private Random rnd = new Random();

    private String createString() {
        int len;
        String str = "";

        len = rnd.nextInt(STRING_LEN);
        for (int i = 0; i < len; i++) {
            str += (char) rnd.nextInt(256);
        }
        return str;
    }

    private void createStringCollection() {
        int len = rnd.nextInt(COLLECTION_LEN);

        for (int i = 0; i < len; i++) {
            strings.add(createString());
        }
    }

    private int getUniqueChars(String str) {
        int[] chars = new int[256];
        int idx;
        int unique = 0;

        for (int i = 0; i < str.length(); i++) {
            idx = str.charAt(i);
            chars[idx]++;
        }
        for (int c : chars) {
            if (c == 1) unique++;
        }

        return unique;
    }

    private int getCollectionLength() {
        return strings.size();
    }

    private String getRandomStringFromCollection() {
        int i = rnd.nextInt(getCollectionLength());
        return strings.get(i);
    }

    private int getStringFromCache(String str) {
        Integer idx;

        idx = cache.get(str.hashCode());
        return (idx == null) ? -1 : idx;
    }

    private void addStringToCache(String str, int uniqueChars) {
        cache.put(str.hashCode(), uniqueChars);
    }

    void checkIt() {
        String str;
        int cached;

        for (int i = 0; i < getCollectionLength(); i++) {
            int uc;

            str = getRandomStringFromCollection();
            cached = getStringFromCache(str);

            if (cached > -1) {
                System.out.println("c! " + cached);
            } else {
                uc = getUniqueChars(str);
                addStringToCache(str, uc);
                System.out.println(uc);
            }

        }
    }

    public static void main(String[] args) {
        MRString mrs = new MRString();
        mrs.createStringCollection();
        mrs.checkIt();
    }
}
