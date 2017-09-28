package org.ostroukh.dionisus.app.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.ostroukh.dionisus.app.persistence.repository.CityRepository;
import org.ostroukh.dionisus.app.persistence.repository.inmemory.CityRepositoryInMemory;
import org.ostroukh.dionisus.app.service.CityService;
import org.ostroukh.dionisus.app.service.impl.CityServiceImpl;
import org.ostroukh.dionisus.app.service.transform.Transformer;
import org.ostroukh.dionisus.app.service.transform.impl.TransformerImpl;

import javax.inject.Singleton;

/**
 * Binds bean implementations and implemented interfaces
 */
public class ComponentBinder extends AbstractBinder{
    @Override
    protected void configure() {
        bind(CityRepositoryInMemory.class)
                .to(CityRepository.class)
                .in(Singleton.class);
        bind(TransformerImpl.class)
                .to(Transformer.class)
                .in(Singleton.class);
        bind(CityServiceImpl.class)
                .to(CityService.class)
                .in(Singleton.class);
    }
}
