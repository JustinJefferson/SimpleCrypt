
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    int encyptBase;
    int decyptBase;
    char cs;
    char cf;

    ROT13(Character cs, Character cf) {
        encyptBase = (int) cf - cs;
        decyptBase = 26 - encyptBase;
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }

    public static void main(String[] args) {
        Character character = 'A';
        Integer codepoint = Character.getNumericValue(character);
        System.out.println(Character.getNumericValue(character));

        char ch = 't';
        ch += 6;
        System.out.println(ch);
        System.out.println(ch + 6);
        System.out.println((int)'a');
        System.out.println((int)'A');
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return rotateByNum(text, encyptBase);
    }

    public String encrypt(String text) {

        return rotateByNum(text, encyptBase);
    }

    public String decrypt(String text) {
        return rotateByNum(text, decyptBase);
    }

    public String rotate(String s, Character c) {

        StringBuilder builder = new StringBuilder();
        int counter = 0;
        Boolean copying = false;
        Boolean repeat = true;

        for(int i = 0; i < s.length(); i++) {

            if(c.equals(s.charAt(i))) copying = true;
            if(copying) {
                builder.append(s.charAt(i));
                counter++;
            }
            if(counter == s.length()) break;
            if(i == s.length() - 1 && repeat) {
                i = -1;
                repeat = false;
            }

        }

        return builder.toString() ;

    }

    public String rotateByNum(String s, int num) {

        int rotate = num;

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)) {
                ch = (char)((ch + rotate - 97) % 26 + 97);

            }
            else if(Character.isUpperCase(ch)) {
                ch = (char)((ch + rotate - 65) % 26 + 65);
            }

            builder.append(ch);
        }

        return builder.toString();
    }

}
