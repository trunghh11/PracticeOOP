package Design_pattern.cau1;

import java.util.ArrayList;
import java.util.List;

public class Family implements Person {
    private List<Person> members;

    public Family() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return new ArrayList<Person>(members);
    }

    @Override
    public void displayInformation() {
        for (Person member : members) {
            member.displayInformation();
        }
    }
    
}
