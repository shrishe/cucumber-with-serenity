package vccss.service.api.util;

import static java.lang.String.format;
import static vccss.service.api.util.ApplicationProps.APPLICATION_PROPS;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum EndPoints {
    ENDPOINTS;

    private final String BASE_URL = "baseUrl";
    private final ConcurrentMap<String, String> endpoints = new ConcurrentHashMap<>();

    EndPoints() {
        endpoints.putAll(PropertiesUtil.in("props/endpoint.properties"));
    }

    public String getEndPoint(final String name) {
        return format("%s%s", APPLICATION_PROPS.get(BASE_URL), endpoints.get(name));
    }
}
