package src;
import mjson.Json;
import mjson.Json.*;

import static mjson.Json.*;

public class mJsonExample {

    public static void main(String[] args) {
        Json x = object().set("name", "mJson")
                .set("version", "1.0")
                .set("cost", 0.0)
                .set("alias", array("json", "minimal json", "cost", 0.0, "version", array(1.0, 2.0)));

        Json y = object().set("date", "20/04/2021");
        x.at("alias").add(y); //adds Json object to Json array

        System.out.println(x.at("name").asString()); // return mJson as a Java String
        System.out.println(x.at("alias").at(1)); // returns "minimal json" as a Json instance
        System.out.println(x.at("cost").asDouble()); // returns 0.0

//        String s = x.toString(); // get string representation
//        System.out.println("Json String representation: "+s);
//        System.out.println("String representation equal to Json object? "+x.equals(Json.read(s))); // parse back and compare => true
//        System.out.println(Json.read(s)); //return serialized JSON object

        Json myArray = array("first", "second", "third", object("numbers", 3));
        Json myObject = object()
                    .set("first", 1)
                    .set("second", 2);
        myObject.set("numbers", object("list", array()));
        myObject.at("numbers").at("list").add(object("Relatives", "Z"));
        myObject.at("numbers").at("list").add(object("Integers", "N"));

        System.out.println(myArray.is(1, "second")); //2
        System.out.println(myArray.at(1)); //"second"
        System.out.println(myObject.at("second")); //2
        System.out.println(array(myObject));
        System.out.println(myArray.at(1).isPrimitive());
        System.out.println(myArray.at(3).isPrimitive());

        Json myObject2 = object().set("foo", "bar");
        myObject.with(myObject2);
        System.out.println(myObject);
    }

}
