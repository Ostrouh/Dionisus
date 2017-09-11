package org.ostroukh.dionisus.app.model.entity.geography;

/**
 * Value type that stores address attributes
 * of the specific office or person
 * @author Eugene Ostroukh
 */
public class Address {
    private String postalCode;

    private String street;

    private String buildingNo;

    /**
     * (Optional) Apartment number if it's address
     * of the apartment
     */
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
