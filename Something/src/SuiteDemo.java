/**
 * Demonstration of JUnit test suites.   Code basically stolen from 
 * https://github.com/junit-team/junit/wiki/Aggregating-tests-in-suites
 * 
 * @author dlevine
 * @version 20 January 2016
 * 
 */


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    SomethingTest1.class, 
    SomethingTest2.class, 
    })

public class SuiteDemo {
    // the class remains empty,
    // used only as a holder for the above annotations
}
