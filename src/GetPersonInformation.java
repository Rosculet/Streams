import java.util.List;
import java.util.Set;

public interface GetPersonInformation<N, T>{

    Set<T> getInformation(List<N> person);

}
