package org.ostroukh.dionisus.app.model.search.criteria;

import org.ostroukh.dionisus.app.model.entity.establishments.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.Address;

/**
 * Filtering criteria for search establishments operation
 */
public class EstablishmentCriteria {

    private String cityName;
    private EstablishmentType establishmentType;

    private Address establishmentAddress;

    /**
     * Returns filtering criteria to search establishments that
     * contains specified name parameter
     * @param cityName
     */
    public EstablishmentCriteria(String cityName) {
        this.cityName = cityName;
    }

    public EstablishmentCriteria(EstablishmentType establishmentType) {
        this.establishmentType = establishmentType;
    }

    public EstablishmentCriteria() {
    }

    public static EstablishmentCriteria byName(EstablishmentType establishmentType){
        return new EstablishmentCriteria(establishmentType);
    }

    public static EstablishmentCriteria byType(String establishmentName){
        return new EstablishmentCriteria(establishmentName);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public EstablishmentType getEstablishmentType() {
        return establishmentType;
    }

    public void setEstablishmentType(EstablishmentType establishmentType) {
        this.establishmentType = establishmentType;
    }

    public Address getEstablishmentAddress() {
        return establishmentAddress;
    }

    public void setEstablishmentAddress(Address establishmentAddress) {
        this.establishmentAddress = establishmentAddress;
    }
}
