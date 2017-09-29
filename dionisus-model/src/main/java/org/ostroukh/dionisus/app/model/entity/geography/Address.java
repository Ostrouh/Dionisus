package org.ostroukh.dionisus.app.model.entity.geography;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Value type that stores address attributes
 * of the specific office or person
 * @author Eugene Ostroukh
 */
@Embeddable
public class Address {
    @Column(name = "POSTAL_CODE", length = 10)
    private String postalCode;

    @Column(name = "STREET", length = 32)
    private String street;

    @Column(name = "BUILDING_NO", length = 8)
    private String buildingNo;

    /**
     * (Optional) Apartment number if it's address
     * of the apartment
     */
    @Column(name = "APARTMENT", length = 8)
    private String apartment;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
