package apachecommons;

import org.apache.commons.text.StrBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 * https://stackoverflow.com/questions/1904115/mvc-on-the-command-line
 */
public class TestMvcPattern {

    @Test
    public void testSimplestObservablePattern() throws Exception {
        Person person = new Person();
        Demo demo = new Demo();
        person.addObserver(demo);

        Assertions.assertThat(person.hasChanged()).isFalse();
        person.setName("Hugo");

        Assertions.assertThat(person.hasChanged()).isTrue();

        person.notifyObservers();
    }
}

class Controller {

    private Demo demo;
    private Person person;

    public Controller(Demo demo, Person person) {
        this.demo = demo;
        this.person = person;
    }
}

class Demo implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Called");
    }

    public String showToUser() {
        return "Any string";
    }
}

class Person extends Observable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
    }
}

