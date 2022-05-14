package Hash_table;

public class Main {
  public static void main(String[] args) {
    PhoneBook myPhoneBook = new PhoneBook(1);

    myPhoneBook.Insert("Lana", 768);
    myPhoneBook.Insert("Hyacinth", 117);
    myPhoneBook.Insert("Kim", 320);
    myPhoneBook.Insert("Seth", 213);
    myPhoneBook.Insert("Madison", 578);

    myPhoneBook.Delete("Hyacinth");

    myPhoneBook.Print();

    myPhoneBook.Retrieve("Madison");
  }
}
