package org.j2os.model.domain;

import java.io.Serializable;

public class Person implements Serializable {
    private Long personId;
    private String name;
    private String family;

    public Person() {
    }

    public Person(Long personId, String name, String family) {
        this.personId = personId;
        this.name = name;
        this.family = family;
    }

    public Long getPersonId() {
        return personId;
    }

    public Person setPersonId(Long personId) {
        this.personId = personId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
