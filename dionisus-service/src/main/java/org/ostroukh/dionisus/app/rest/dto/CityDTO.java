package org.ostroukh.dionisus.app.rest.dto;

import org.ostroukh.dionisus.app.model.entity.geography.City;
import org.ostroukh.dionisus.app.rest.dto.base.BaseDTO;

/**
 * Holds city state for the client-server communication
 */
public class CityDTO extends BaseDTO<City>{
    private String name;
    private String district;
    private String region;

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

    public void setRegion(String rerion) {
        this.region = rerion;
    }
}
