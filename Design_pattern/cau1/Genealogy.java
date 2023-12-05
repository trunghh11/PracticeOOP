package Design_pattern.cau1;

import java.util.ArrayList;
import java.util.List;

public class Genealogy {
    public List<Person> getMemsUnmarried(Family family) {
        List<Person> result = new ArrayList<Person>();
        for (Person person : family.getMembers()) {
            if (person instanceof Family) {
                result.addAll(getMemsUnmarried((Family) person));
            }

            if (person instanceof Individual) {
                Individual individual = (Individual) person;
                if (individual.getSpouse() == null) {
                    result.add(person);
                }
            }
        }
        return result;
    }

    class Couple {
        Person husband;
        Person wife;

        void displayInformation() {
            System.out.println("Couple:[ ");

            husband.displayInformation();
            wife.displayInformation();

            System.out.println("]");
        }
    }

    public List<Couple> getCoupleHasNChilds(Family family, int n) {
        List<Couple> result = new ArrayList<Couple>();
        for (Person person : family.getMembers()) {
            if (person instanceof Family) {
                result.addAll(getCoupleHasNChilds((Family) person, n));
            }

            if (person instanceof Individual) {
                Individual individual = (Individual) person;
                if (individual.getSpouse() != null && individual.getGender().equals("Male")
                        && individual.getChildrens().size() == n) {
                    Couple newCouple = new Couple();

                    newCouple.husband = person;
                    newCouple.wife = individual.getSpouse();

                    result.add(newCouple);
                }
            }
        }
        return result;
    }

    public List<Person> getLastestGeneration(Family family) {
        List<Person> result = new ArrayList<Person>();
        for (Person person : family.getMembers()) {
            if (person instanceof Family) {
                result.addAll(getLastestGeneration((Family) person));
            }

            if (person instanceof Individual) {
                Individual individual = (Individual) person;
                if (individual.getChildrens().size() == 0) {
                    result.add(person);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Create the genealogy tree
        Family jamesFamily = new Family();
        Individual james = new Individual("James", "01/01/1970", "Male");
        jamesFamily.addMember(james);

        Family hanaFamily = new Family();
        jamesFamily.addMember(hanaFamily);

        Individual hana = new Individual("Hana", "01/01/1972", "Female");
        hanaFamily.addMember(hana);
        hana.setSpouse(james);
        james.setSpouse(hana);

        Family ryanFamily = new Family();
        jamesFamily.addMember(ryanFamily);

        Individual ryan = new Individual("Ryan", "01/01/1995", "Male");
        ryanFamily.addMember(ryan);
        james.addChild(ryan);
        hana.addChild(ryan);

        Family kaiFamily = new Family();
        jamesFamily.addMember(kaiFamily);

        Individual kai = new Individual("Kai", "01/01/1997", "Male");
        kaiFamily.addMember(kai);
        james.addChild(kai);
        hana.addChild(kai);

        Family jenniferFamily = new Family();
        kaiFamily.addMember(jenniferFamily);
        Individual jennifer = new Individual("Jennifer", "01/01/1995", "Female");
        jenniferFamily.addMember(jennifer);
        kai.setSpouse(jennifer);
        jennifer.setSpouse(kai);

        jamesFamily.displayInformation();

        Genealogy genealogy = new Genealogy();
        System.out.println("Mems Unmarried: ");
        for (Person person : genealogy.getMemsUnmarried(jamesFamily)) {
            person.displayInformation();
        }

        System.out.println("Couples Have 2 Childrens: ");
        for (Couple couple : genealogy.getCoupleHasNChilds(jamesFamily, 2)) {
            couple.displayInformation();
        }

        System.out.println("Lastest Generation: ");
        for (Person person : genealogy.getLastestGeneration(jamesFamily)) {
            person.displayInformation();
        }

    }
}
