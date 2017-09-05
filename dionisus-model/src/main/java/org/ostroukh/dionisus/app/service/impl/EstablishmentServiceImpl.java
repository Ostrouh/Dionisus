package org.ostroukh.dionisus.app.service.impl;

import org.ostroukh.dionisus.app.infra.util.CommonUtil;
import org.ostroukh.dionisus.app.model.entity.establishment.Establishment;
import org.ostroukh.dionisus.app.service.EstablishmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link EstablishmentService}
 * @author Eugene Ostroukh
 */
public class EstablishmentServiceImpl implements EstablishmentService {

    private final List<Establishment> establishments;

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
            establishments.add(establishment);
        }
    }
}
