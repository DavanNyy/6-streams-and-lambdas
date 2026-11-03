package part08;

import java.util.stream.Stream;

import person.Person;

/**
 * This class applies the concepts of previous exercises with Person objects.
 * Person objects can be filtered, mapped and collected just like any other
 * objects.
 */
public class PersonStreams {

    /**
     * Returns a stream of adults in the specified stream of persons.
     * An adult is a person whose age is 18 or over.
     *
     * @param persons the stream to filter
     * @return a stream of the adults in the given stream
     */
    public Stream<Person> getAdults(Stream<Person> persons) {
        // Hint: you can call the `age()` method on a Person object to get the age.
        return persons.filter(p -> p.age() >= 18); // "pidä vain henkilöt, joiden ikä on vähintään 18"

        // p = Person-olio (esim. Person{name=Ada, age=20})
        // p.age() = haetaan ikä
        // >= 18 tarkistaa onko henkilö aikuinen
        // p.age() >= 18 = true, jos henkilö on täysi-ikäinen

        // filter() = suodattaa streamin, eli poistaa kaikki henkilöt, jotka eivät täytä ehtoa
    }

    /**
     * Returns a stream of new Person objects with ages incremented by one.
     *
     * @param persons the stream of objects
     * @return a stream of new Person objects with incremented ages
     */
    public Stream<Person> incrementAge(Stream<Person> persons) {
        /*
         * Hint: you cannot modify the age of the persons in the original stream. You
         * need to create new Person objects.
         *
         * Use the `map()` method to create new stream and the `Person` constructor to
         * create new Person objects with incremented ages. The name and age of a Person
         * object can be accessed using the `name()` and `age()` methods.
         */
        return persons.map(p -> new Person(p.name(), p.age() + 1)); // TODO
        // Luo tästä streamistä uusi stream, joka sisältää uusia Person-olioita, joiden ikä on yhden suurempi kuin alkuperäisissä olioissa.
        // filter() poistaa alkioita.
        // map() muuttaa jokaisen alkion toiseksi.

        // p = Person-olio (esim. Person{name=Ada, age=20})
        // p.name() = haetaan nimi
        // p.age() = haetaan ikä
        // p.age() + 1 = lisää ikään yksi
        // new Person(...) = luo uusi olio
        // new Person(p.name(), p.age() + 1) = Ota henkilö, pidä nimi samana ja lisää ikään yksi.
    }

    /**
     * Returns a stream of People objects that have been created based on the lines
     * in the specified stream of Strings. Each string contains the name and age of
     * a person separated by a comma.
     *
     * For example, the line "Ada,20" creates a person object with the name "Ada"
     * and the age 20.
     *
     * @param csvLines the stream of lines from a CSV file
     * @return a stream of Person objects
     */
    public Stream<Person> csvToPersons(Stream<String> csvLines) {
        return csvLines.map(line -> {
            String[] parts = line.split(",");
            return new Person(parts[0], Integer.parseInt(parts[1]));
        }); // TODO

        /*  split(",")          // jaa rivi pilkun kohdalta
            parts[0]            // nimi
            parts[1]            // ikä tekstinä
            Integer.parseInt()  // tekstistä numero
            new Person(...)     // luo henkilö
            map(...)            // tee jokaisesta rivistä Person   */
    }
}
