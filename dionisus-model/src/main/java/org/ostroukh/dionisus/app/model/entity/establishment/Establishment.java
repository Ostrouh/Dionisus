package org.ostroukh.dionisus.app.model.entity.establishment;

import org.apache.commons.lang3.StringUtils;
import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.Address;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.entity.geography.Coordinate;
import org.ostroukh.dionisus.app.model.search.criteria.EstablishmentCriteria;

import java.util.Objects;

/**
 * Entertaining establishment where can order the table
 * @author Eugene Ostrouh
 */
public class Establishment extends AbstractEntity{
    private City city;

    private Address address;

    private String name;

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
    public Establishment(final String name, final City city, final EstablishmentType establishmentType){
        this.name = name;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean match(EstablishmentCriteria criteria){
        Objects.requireNonNull(criteria, "Criteria is not initialized");
        if(!StringUtils.isEmpty(criteria.getName())) {
            if(!city.getName().equals(criteria.getCity().getName())) {
                return false;
            }
        }
        if(criteria.getEstablishmentType() != null){
            if(establishmentType != criteria.getEstablishmentType()){
                return false;
            }
        }
        return true;
    }
}
