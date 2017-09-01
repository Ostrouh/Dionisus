package org.ostroukh.dionisus.app.model.entity.geography;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Any locality that contains establishments for table reserving
 * @author Eugene Ostroukh
 */
public class City extends AbstractEntity{
    private String name;

    /**
     * Name of the district where city is placed
     */
    private String district;

    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    private String region;

    /**
     * Set of entertaining establishments that is linked to this
     * city
     */
    private Set<Establishment> establishments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(Set<Establishment> establishments) {
        this.establishments = establishments;
    }


    /**
     * Adds specified establishment to the city establishment list
     * @param establishment
     */
    public void addEstablishment(final Establishment establishment) {
        Objects.requireNonNull(establishment, "establishment parameter is not initialized");
        if(establishments == null) {
            establishments = new HashSet<>();
        }
        establishments.add(establishment);
        establishment.setCity(this);
    }

    /**
     * Removes specified station from city station list
     * @param establishment
     */
    public void removeEstablishment(Establishment establishment) {
        Objects.requireNonNull(establishment, "establishment parameter is not initialized");
        if(establishments == null) {
            return;
        }
        establishments.remove(establishment);
    }
}
