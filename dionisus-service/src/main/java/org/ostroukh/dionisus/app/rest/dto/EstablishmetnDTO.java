package org.ostroukh.dionisus.app.rest.dto;

import org.ostroukh.dionisus.app.model.entity.geography.Address;

/**
 * Holds establishment state for the client-server communication
 */
public class EstablishmetnDTO {
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
