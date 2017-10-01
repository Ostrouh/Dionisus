package org.ostroukh.dionisus.app.model.entity.establishment;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;
import org.ostroukh.dionisus.app.model.entity.geography.Address;
import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.model.entity.geography.Coordinate;
import org.ostroukh.dionisus.app.model.search.criteria.EstablishmentCriteria;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Entertaining establishment where can order the table
 * @author Eugene Ostrouh
 */
@Table(name = "ESTABLISHMENT")
@Entity
public class Establishment extends AbstractEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_ID")
    private City city;

    @Embedded
    private Address address;

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    /**
     * (Optional) Phone of the administrator of the establishment
     */
    @Column(name = "PHONE", length = 16)
    private String phone;

    @Embedded
    private Coordinate coordinate;

    @Enumerated
    @Column(name = "ESTABLISHMENT_TYPE", nullable = false)
    private EstablishmentType establishmentType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "establishment", orphanRemoval = true)
    private Set<ATable> tables;

    /**
     * You shouldn't create establishment object directly. Use
     * {@link City} functionality instead
     * @param city
     */
    public Establishment(final String name, final City city, final EstablishmentType establishmentType){
        this.name = Objects.requireNonNull(name);
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

    public Set<ATable> getTables() {
        return CommonUtil.getSafeSet(tables);
    }

    public void setTables(Set<ATable> tables) {
        this.tables = tables;
    }

    public boolean match(EstablishmentCriteria criteria){
        Objects.requireNonNull(criteria, "Criteria is not initialized");
        if(criteria.getEstablishmentType() != null){
            if(establishmentType != criteria.getEstablishmentType()){
                return false;
            }
        }
        if(!StringUtils.isEmpty(criteria.getName())) {
            if(!city.getName().equals(criteria.getCity().getName())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Establishment that = (Establishment) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(city, that.city)
                .append(address, that.address)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(city)
                .append(address)
                .append(name)
                .toHashCode();
    }
}
