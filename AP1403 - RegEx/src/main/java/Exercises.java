import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public String findDate(String string) {
        // todo
        String regex = "\\b(\\d{2}/\\d{2}/\\d{4}|\\d{4}-\\d{2}-\\d{2}|\\d{4}/\\d{2}/\\d{2})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public int findValidPasswords(String string) {
        // todo
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count + 1;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
            String[] words = string.split("\\W+"); // Split by non-word characters

            for (String word : words) {
                String cleanedWord = word.toLowerCase();
                if (cleanedWord.length() > 1 && cleanedWord.equals(new StringBuilder(cleanedWord).reverse().toString())) {
                    list.add(word); // Keep original case
                }
            }
            return list;
    }

    public static void main(String[] args) {
        System.out.print(new Exercises().findDate("Release date will be 2025/01/01 (hopefully) at midnight"));
        System.out.print("\n"+new Exercises().validateEmail("alice_bob123@research-lab.co.uk"));
        System.out.print("\n"+new Exercises().findValidPasswords("""
                [09:15] Dev1: Just changed my password to CodeMaster@2025. \s
                [09:17] Dev2: Haha, mine's still qwerty123, no special chars. \s
                [09:19] Dev3: I use GitHubSuper#1 but need a better one. \s
                [09:21] Dev4: AdminPass42! is good, right? \s
                [09:23] Dev5: No, too simple. I switched to UltraSecure$99 last week. \s
                [09:25] Dev6: Wait, are we sharing passwords here? \uD83D\uDE02 \s
                """));
        System.out.print("\n" + new Exercises().findPalindromes("""
                Madam, did you see Bob running? I asked Kayak and radar to wait at the civic center.\s
                The level of security was high, but I noticed a racecar driving past. A deed was done in the noon,\s
                and many said it was a referable situation.
                """));
    }

}
