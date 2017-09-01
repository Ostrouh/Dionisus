package org.ostroukh.dionisus.app.model.entity.geography;

/**
 * Value type that stores address attributes
 * of the specific office or person
 * @author Eugene Ostroukh
 */
public class Address {
    private String zipCode;

    private String street;

    private String buildingNo;

    /**
     * (Optional) Apartment number if it's address
     * of the apartment
     */
    private String apartment;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
