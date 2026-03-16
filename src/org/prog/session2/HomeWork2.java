package org.prog.session2;

//TODO: using for cycle, print only valid emails
//TODO: only one @
//TODO: must have at least 3 chars before @
//TODO: at least 3 symbols between @ and .
//TODO: domain (after @) must hav eat least 1 .

public class HomeWork2 {

    public static void main(String[] args) {

        String[] emails = new String[]{
                "abcd@gmail.com",
                "john.doe@gmail.com",
                "mymailgmail.com",
                "badmail@@gmail.com",
                "somemail@gmailcom",
                "somemail@gmail.com",
                "a@gmail.com",
                "abcdedfg@x.com",
                "abcdedfg@xzfgdasd.com"
        };

        for (int i = 0; i < emails.length; i++) {

            String email = emails[i];

            int atIndex = email.indexOf("@");
            int lastAtIndex = email.lastIndexOf("@");
            int dotIndex = email.indexOf(".", atIndex);

            if (atIndex == lastAtIndex &&
                    atIndex >= 3 &&
                    dotIndex - atIndex > 3 &&
                    dotIndex != -1) {

                System.out.println(email);
            }
        }
    }
}
