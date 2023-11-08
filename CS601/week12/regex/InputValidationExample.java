package week12.regex;

public class InputValidationExample {

    // validate first name
    /**
     [A-Z]: This part of the expression specifies that the first character must be an uppercase letter from A to Z.
     [a-zA-Z]: This part specifies that any character following the first must be an uppercase letter (A-Z) or a lowercase letter (a-z).
     *: The asterisk is a quantifier that means "zero or more" of the preceding element. In this case, it applies to [a-zA-Z], indicating that zero or more letters can follow the initial uppercase letter.
     Putting it all together, the regular expression requires that the firstName start with an uppercase letter and be followed by any combination of uppercase and lowercase letters. The * allows for names of any length, including just one character (as long as it's an uppercase letter).

     Here's an example to illustrate:

     validateFirstName("John") would return true because "John" starts with an uppercase 'J' followed by lowercase letters.
     validateFirstName("john") would return false because the first character is not uppercase.
     validateFirstName("J") would also return true because it's a single uppercase letter, which is a valid match for the regular expression.
     validateFirstName("J0hn") would return false because it contains a digit, which is not allowed by the regular expression.
     **/
    /**
     * [A-Z] no "+" after it means only 1 character from A-Z, A-Z matches a single character in the range
     * [A-Z]+ means any number or size of this set will be ok, + matches the previous token between one and unlimited times, as many times as possible
     * "*" means can occur 0 time or more, so first name "J" matches [A-Z][a-zA-Z]*
     */
    public static boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]*");
    }

    // validate last name

    /**
     * [a-zA-Z]+([ '-][a-zA-Z]+)*
     * kpem'Helsj matches, kpem matches beacuse second group 'Helsj has *
     * kpem Helsj or kpem-Helsj or kpem matches too
     * [a-zA-Z]+ is first group, ([ '-][a-zA-Z]+)* is second group
     */
    public static boolean validateLastName(String lastName) {
        return lastName.matches("[a-zA-Z]+([ '-][a-zA-Z]+)*");
    }


    // validate address

    /**
     * [\d]+ will validate any size of number like 22 222 or 2341 or 193
     * [\d] will only match 1 single character like 1 or 8 or 9
     * but in java string need to put \\ since \ is escape character means special escape
     * [\s] match single white space. [\s]+ matches multiple white space
     * <p>
     * "\d+\s+([a-zA-Z]+(\s[a-zA-Z]+)*)"
     * 975 bryant street or 975 bryant, street is optional since *
     * in java need to do \\d because \ is especial char, need to have \\ to define a string literal \
     */
    public static boolean validateAddress(String address) {
        return address.matches("\\d+\\s+([a-zA-Z]+(\\s[a-zA-Z]+)*)");
    }


    // validate city
    // San Francisco and HongKong, city can be one word or 2 word
    public static boolean validateCity(String city) {
        return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    } // end method validateCity

    // validate zip
    public static boolean validateZip(String zip) {
        return zip.matches("\\d{5}");
    }

    // validate phone
    // will match 617-208-9409
    // [1-9]\d{2}-\d{3}-\d{4}
    // [a-zA-Z]+\s([a-zA-Z]+)\s([1-9]\d{2}-\d{3}-\d{4}) to match "Janet Smith 401-987-3456"
    public static boolean validatePhone(String phone) {
        return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
    }
}
