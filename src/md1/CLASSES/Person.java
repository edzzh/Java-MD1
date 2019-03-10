package md1.CLASSES;

import md1.ENUMS.Gender;
import md1.ENUMS.Nationality;

/**
 *
 * @author Edgars Hartmanis 3ITB
 * Person class
 */

public class Person {
    private String name;
    private String surname;
    private int identificator;
    Gender gender;
    Nationality nationality;
    
    public Person(String name, String surname, int id, Gender gender, Nationality nationality) {
       this.name = name;
       this.surname = surname;
       this.identificator = id;
       this.gender = gender;
       this.nationality = nationality;
    }
    
    public Person(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.identificator = id;
    }
    
    public Person() {}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getIdentificator() {
        return identificator;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Couldn't set Person name, conditions didn't match");
        }
    }

    public void setSurname(String surname) {
        if (surname != null && !surname.isEmpty()) {
            this.surname = surname;
        } else {
            System.out.println("Couldn't set Person surname, conditions didn't match");
        }
    }

    public void setIdentificator(int identificator) {
        if (identificator >= 0) {
            this.identificator = identificator;
        } else {
            System.out.println("Couldn't set Person identificator, conditions didn't match");
        }
    }

    public Gender getGender() {
        return gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setGender(Gender gender) {
        for (Gender g : Gender.values()) {
            if (g.equals(gender)) {
                this.gender = gender;
            }
        }
    }

    public void setNationality(Nationality nationality) {
        for (Nationality nat : Nationality.values()) {
            if (nat.equals(nationality)) {
                this.nationality = nationality;
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", identificator=" + identificator + ", gender=" + gender + ", nationality=" + nationality + '}';
    }
}
