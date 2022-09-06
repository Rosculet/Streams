import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetAddress implements GetPersonInformation<Person, String>{
    @Override
    public Set<String> getInformation(List<Person> person) {
        Set<String> nameList = new HashSet<>();
        try {
            for (Person person1 : person) {
                nameList.add(person1.getAddress().toString());
            }
        }
        catch (NullPointerException e ) {
            System.out.println("Address is empty");
        }
        return nameList;
    }
}
