package org.ostroukh.dionisus.app.model.entity.geography;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.model.entity.establishments.EstablishmentType;

import java.util.Objects;

/**
 * Entertaining establishments where can order the table
 * @author Eugene Ostrouh
 */
public class Establishment extends AbstractEntity{
    private City city;

    private Address address;

    /**
     * (Optional) Phone of the administrator of the establishment
     */
    private String phone;

    private Coordinate coordinate;

    private EstablishmentType establishmentType;

    /**
     * You shouldn't create establishment object directly. Use
     * {@link City} functionality instead
     * @param city
     */
    public Establishment(final City city, final EstablishmentType establishmentType){
        this.city = Objects.requireNonNull(city);
        this.establishmentType = Objects.requireNonNull(establishmentType);
    }

    public City getCity() {
        return city;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public EstablishmentType getEstablishmentType() {
        return establishmentType;
    }

    public void setEstablishmentType(EstablishmentType establishmentType) {
        this.establishmentType = establishmentType;
    }
}
