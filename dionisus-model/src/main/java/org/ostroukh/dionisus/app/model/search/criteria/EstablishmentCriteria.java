package org.ostroukh.dionisus.app.model.search.criteria;

import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;
import org.ostroukh.dionisus.app.model.entity.geography.City;

import java.util.Objects;

/**
 * Filtering criteria for search establishment operation.
 * The filter can be a name, a city name and a type of catering ectablishment.
 * @author Eugene Ostroukh
 */
public class EstablishmentCriteria {
    /**
     *Catering establishment's name
     */
    private String name;

    private City city;
    private EstablishmentType establishmentType;


    /**
     * Returns filtering criteria to search establishment that
     * contains specified establishment's name parameter
     * @param name
     */
    public EstablishmentCriteria(String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Returns filtering criteria to search establishment that
     * contains specified city parameter
     * @param city
     */
    public EstablishmentCriteria(City city) {
        this.city = Objects.requireNonNull(city);
    }

    /**
     * Returns filtering criteria to search establishment that
     * contains specified establishmentType parameter
     * @param establishmentType
     */
    public EstablishmentCriteria(EstablishmentType establishmentType) {
        this.establishmentType = Objects.requireNonNull(establishmentType);
    }

    public EstablishmentCriteria() {
    }

    public static EstablishmentCriteria byType(EstablishmentType establishmentType){
        return new EstablishmentCriteria(establishmentType);
    }

    public static EstablishmentCriteria byName(String establishmentName){
        return new EstablishmentCriteria(establishmentName);
    }

    public static EstablishmentCriteria byCityName(String cityName){
        return new EstablishmentCriteria(cityName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(String cityName) {
        this.city = city;
    }

    public EstablishmentType getEstablishmentType() {
        return establishmentType;
    }

    public void setEstablishmentType(EstablishmentType establishmentType) {
        this.establishmentType = establishmentType;
    }

}