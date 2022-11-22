package info.dmerej.contacts;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ContactsGenerator {
  private static final Contact[] TEMPLATE_CONTACTS = new Contact[]{
          new Contact("Alice", "alice@aol.com"),
          new Contact("Bob", "bob@gmail.com"),
          new Contact("Eve", "eve@fastmail.com"),
  };

  public Stream<Contact> generateContacts(int count) {
    Random r = new Random();

    return IntStream.range(0, count)
            .mapToObj(i -> TEMPLATE_CONTACTS[r.nextInt(TEMPLATE_CONTACTS.length)]);
  }
}
