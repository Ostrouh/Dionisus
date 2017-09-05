package org.ostroukh.dionisus.app.service;

import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;

import java.util.List;

/**
 * Entry point to perform operations
 * over establishment entities
 * @author Eugene Ostroukh
 */
public interface EstablishmentService {
    /**
     * Returns list of existing establishments
     * @return
     */
    List<Establishment> findEstablishments();

    /**
     * Saves specified establishment instance
     * @param establishment
     */
    void saveEstablishment(Establishment establishment);
}
