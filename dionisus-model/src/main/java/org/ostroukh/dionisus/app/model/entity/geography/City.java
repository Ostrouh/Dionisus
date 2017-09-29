package org.ostroukh.dionisus.app.model.entity.geography;

import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.model.entity.establishment.EstablishmentType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Any locality that contains establishment for table reserving
 * @author Eugene Ostroukh
 */
@Table(name = "CITY")
@Entity
public class City extends AbstractEntity{
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    /**
     * Name of the district where city is placed
     */
    @Column(name = "DISTRICT", nullable = false, length = 32)
    private String district;

    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    @Column(name = "REGION", nullable = false, length = 32)
    private String region;

    /**
     * Set of entertaining establishments that is linked to this
     * city
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city", orphanRemoval = true)
    private Set<Establishment> establishments;

    public City() {
    }

    public City(final String name){
        this.name = name;
    }

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
        return CommonUtil.getSafeSet(establishments);
    }

    public void setEstablishments(Set<Establishment> establishments) {
        this.establishments = establishments;
    }


    /**
     * Adds specified establishment to the city establishment list
     * @param name
     * @param establishmentType
     * @return
     */
    public Establishment addEstablishment(final String name, final EstablishmentType establishmentType) {
        if(establishments == null) {
            establishments = new HashSet<>();
        }
        Establishment establishment = new Establishment(name, this, establishmentType);
        establishments.add(establishment);

        return establishment;
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
