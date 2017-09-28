package org.ostroukh.dionisus.app.config;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by eugene on 28.09.2017.
 */
public class ComponentFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(new ComponentBinder());
        return true;
    }
}
