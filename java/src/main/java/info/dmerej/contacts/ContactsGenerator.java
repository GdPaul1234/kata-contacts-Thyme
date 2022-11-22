package info.dmerej.contacts;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ContactsGenerator {
  public Stream<Contact> generateContacts(int count) {
    return IntStream.range(1, count + 1)
            .mapToObj(i -> new Contact("contact_"+i, "email-"+i+"@tld"));
  }
}
