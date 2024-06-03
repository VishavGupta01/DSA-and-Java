public class stringBuilder {
    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder("Hello World");
        // System.out.println(sb.toString());
        // String str = "hello world";
        // toUpperCase(str);

        String word = "aaabbccddd";
        stringCompression(word);
    }

    public static void toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }

    public static void stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 1;
            while (i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(ch);
            if (count > 1) {
                sb.append(count);
            }
        }
        System.out.println(sb);
    }
}
