/*
 * This Spock specification was auto generated by running 'gradle init --type groovy-library'
 * by 'alberto' at '10/14/15 7:53 PM' with Gradle 2.1
 *
 * @author alberto, @date 10/14/15 7:53 PM
 */

import spock.lang.Specification

class LibraryTest extends Specification{
    def "someLibraryMethod returns true"() {
        setup:
        Library lib = new Library()
        when:
        def result = lib.someLibraryMethod()
        then:
        result == true
    }
}
