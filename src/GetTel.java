import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetTel implements GetPersonInformation<Person, String>{
    @Override
    public Set<String> getInformation(List<Person> person) {
        Set<String> nameList = new HashSet<>();
        for (Person person1 : person) {
            nameList.add(person1.getPhone());
        }
        return nameList;
    }
}
