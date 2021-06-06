package src;

import mjson.Json;

import static mjson.Json.object;

public class mJsonTest {
    public static void main(String[] args) {
        Json foo = object().set("foo", "bar");
        Json foo_dup = foo.dup();
        System.out.println(foo.equals(foo_dup)); //true

        String callback = foo.pad("getTotalCharacters");
        System.out.println(callback); //getTotalCharacters({"foo":"bar"});
    }

    public static String getTotalCharacters(String string){
        int count = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' '
                    && string.charAt(i) != '{'
                    && string.charAt(i) != '}'
                    && string.charAt(i) != ':'
                    && string.charAt(i) != '"')
                count++;
        }
        string += ": " + count;
        return (string);
    }


}
