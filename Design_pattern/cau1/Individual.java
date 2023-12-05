package Design_pattern.cau1;

import java.util.ArrayList;
import java.util.List;

public class Individual implements Person {
    private String name;
    private String birthDate;
    private String gender;
    private Person spouse;
    private List<Person> childrens;

    public Individual(String name, String birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.spouse = null;
        childrens = new ArrayList<Person>();
    }

    public String getGender() {
        return new String(gender);
    }

    public void setSpouse(Person spou) {
        this.spouse = spou;
    }

    public Person getSpouse() {
        return this.spouse;
    }

    public void addChild(Person child) {
        childrens.add(child);
    }

    public List<Person> getChildrens() {
        return new ArrayList<Person>(childrens);
    }

    @Override
    public void displayInformation() {
        System.out.println("Name: " + name);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println();
    }
    
}
