public class stringBuilder {
    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder("Hello World");
        // System.out.println(sb.toString());
        String str = "hello world";
        toUpperCase(str);
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

}
