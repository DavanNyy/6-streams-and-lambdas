package part06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A predicate is a function that returns a boolean value. Predicates are often
 * used to check if the stream itself or the elements in the stream pass a
 * certain check. For example, you can check if all the elements in a stream are
 * positive numbers.
 * 
 * allMatch(...)  // kaikki
 * anyMatch(...)  // ainakin yksi
 * noneMatch(...) // ei yhtään
 */
public class PredicatesWithStreams {

    /**
     * Returns true if all the numbers in the specified stream are positive. Zero is
     * not considered positive in this method.
     *
     * @param numbers the stream of numbers to check
     * @return true if all the numbers in the stream are over zero
     */
    public boolean allPositive(IntStream numbers) {
        // hint: see the `allMatch()` method
        return numbers.allMatch(n -> n > 0); // TODO

        // n -> n > 0 = true, jos luku on suurempi kuin 0, 
        // false, jos luku on 0 tai negatiivinen

        // allMatch() palauttaa:
        // true → jos kaikki luvut täyttävät ehdon
        // false → jos yksikin luku ei täytä ehtoa
    }

    /**
     * Returns the first positive number in the specified stream. Zero is not
     * considered positive in this method. If the stream does not contain any
     * positive numbers, returns 0.
     *
     * @param numbers the stream of numbers to check
     * @return the first positive number in the stream or 0 if there are no positive
     */
    public int getFirstPositive(IntStream numbers) {
        /*
         * hint: you can chain the `filter()`, `findFirst()` and `isPresent()` methods.
         */
        return numbers.filter(n -> n > 0).findFirst().orElse(0); // TODO
        // filter() = suodattaa streamin, eli poistaa kaikki luvut, jotka eivät täytä ehtoa
        // findFirst() = palauttaa ensimmäisen luvun, joka täyttää ehdon
        // orElse(0) = jos ei löydy, anna 0

    }

    /**
     * Returns true if the specified stream contains no null values.
     *
     * @param strings the stream of strings to check
     * @return true if the stream contains no null values
     */
    public boolean containsNoNulls(Stream<String> strings) {
        // hint: see the `noneMatch()` method
        return strings.noneMatch(s -> s == null); // TODO

        // s -> s == null = true, jos merkkijono on null
        // noneMatch() palauttaa: 
        // true → jos yksikään merkkijono ei ole null
        // false → jos yksikin merkkijono on null
        
    }
}
