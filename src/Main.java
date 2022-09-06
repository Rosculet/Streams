import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    // ------------------------------  Level 1 ----------------------------------

    public static Set<String> getPersonInformation(List <Person> list, GetPersonInformation<Person, String> method) {
        return method.getInformation(list);
    }

    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setfName("Ivanov");
        person.setiName("Ivan");
        person.setEmail("ivanov@gmail.com");
        personList.add(person);
        personList.add(new Person());
        personList.add(new Person());
        personList.add(new Person());

        System.out.println(getPersonInformation(personList, new GetName()));
        System.out.println(getPersonInformation(personList, new GetMails()));
        System.out.println(getPersonInformation(personList, new GetTel()));
        System.out.println(getPersonInformation(personList, new GetAddress()));


        /* Из Person получаю Set из Integer c длиннами строк Address, немного не по заданию т.к. не так сначала прочитал,
         так же тут Set не подходит очевидно, но я уже не хочу везде всё менять т.к. это долго, то что с Дженериками всё хорошо и так понятно. */

        GetPersonInformation<Person, Integer> getAddressLength = (List<Person> personX) -> {
            Set<Integer> integerSet = new HashSet<>();
            try {
                for (Person person1 : personX) {
                    integerSet.add(person1.getAddress().toString().length());
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            return integerSet;
        };
        System.out.println(getAddressLength.getInformation(personList));

        // ------------------------------  Level 2 ----------------------------------

        ArrayList<BankAccount> bankAccounts = new ArrayList<>(List.of(new BankAccount(), new BankAccount(), new BankAccount()));
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(100000);
        bankAccount.setIban("DE12 2342 2344 2343 2345");
        bankAccount.setPerson(person);
        bankAccounts.add(bankAccount);

        bankAccounts.stream().filter(x -> x.getBalance() < 100).forEach(System.out::println);

        bankAccounts.stream()
                .filter(x -> x.getBalance() > 10000)
                .sorted(Comparator.comparing(o -> o.getPerson().getiName()))
                .forEach(x -> System.out.println(x.getPerson().getiName() + " " + x.getPerson().getfName() +
                        " " + x.getIban().substring(0,2) + "************" + x.getIban().substring(x.getIban().length()-2, x.getIban().length())
                        + " " + x.getPerson().getEmail()));
    }
}