package org.ostroukh.dionisus.app.service;

import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;

import java.util.List;
import java.util.Optional;

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

    /**
     * Returns establishment with specified id.
     * If no establishment is found then returns empty optional.
     * @param id
     * @return
     */
    Optional<Establishment> findEstablById(int id);
}
