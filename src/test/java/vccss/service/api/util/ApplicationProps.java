package vccss.service.api.util;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum ApplicationProps {
    APPLICATION_PROPS;

    private ConcurrentMap<String, String> props = new ConcurrentHashMap<>();

    ApplicationProps() {
        final String environment = ofNullable(System.getProperty("env")).orElse("dev");
        props.putAll(PropertiesUtil.in(format("props/%s/application.properties", environment)));
    }

    public String get(final String key) {
        return props.get(key);
    }
}
