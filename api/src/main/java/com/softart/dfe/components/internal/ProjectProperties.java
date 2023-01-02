package com.softart.dfe.components.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ProjectProperties {

    public final static String projectVersion;
    public final static String projectArctifact;

    static {
        try {
            final Properties properties = new Properties();
            properties.load(ProjectProperties.class.getClassLoader().getResourceAsStream("project.properties"));

            final String version = System.getProperty("PROJECT_VERSION", "0.0.1");
            final String artifact = System.getProperty("PROJECT_ARTIFACT", "dfe");

            projectVersion = Objects.nonNull(version) ? version : Objects.requireNonNull(properties.getProperty("project.version"));
            projectArctifact = Objects.nonNull(artifact) ? artifact : Objects.requireNonNull(properties.getProperty("project.artifact"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ProjectProperties() {
    }

    public static String displayVersion() {
        return projectArctifact + "-" + projectVersion;
    }

}
