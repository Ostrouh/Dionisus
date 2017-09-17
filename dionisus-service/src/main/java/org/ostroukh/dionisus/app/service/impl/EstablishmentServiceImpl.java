package org.ostroukh.dionisus.app.service.impl;

import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.service.EstablishmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Default implementation of the {@link EstablishmentService}
 * @author Eugene Ostroukh
 */
public class EstablishmentServiceImpl implements EstablishmentService {

    private final List<Establishment> establishments;
    private int counter = 0;


    public EstablishmentServiceImpl() {
        establishments = new ArrayList<>();
    }

    @Override
    public List<Establishment> findEstablishments() {
        return CommonUtil.getSafeList(establishments);
    }



    @Override
    public void saveEstablishment(Establishment establishment) {
        if(!establishments.contains(establishment)){
            establishment.setId(++counter);
            establishments.add(establishment);
        }
    }

    @Override
    public Optional<Establishment> findEstablById(int id) {
        return establishments.stream()
                .filter(establishment -> establishment.getId() == id)
                .findFirst();
    }
}
