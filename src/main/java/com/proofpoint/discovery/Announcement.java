package com.proofpoint.discovery;

import com.google.common.collect.ImmutableSet;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.annotation.concurrent.Immutable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Immutable
public class Announcement
{
    private final String environment;
    private final String location;
    private final Set<ServiceAnnouncement> services;

    @JsonCreator
    public Announcement(@JsonProperty("environment") String environment,
                        @JsonProperty("location") String location,
                        @JsonProperty("services") Set<ServiceAnnouncement> services)
    {
        this.environment = environment;
        this.location = location;

        if (services != null) {
            this.services = ImmutableSet.copyOf(services);
        }
        else {
            this.services = null;
        }
    }

    @NotNull
    public String getEnvironment()
    {
        return environment;
    }

    public String getLocation()
    {
        return location;
    }

    @NotNull
    @Valid
    public Set<ServiceAnnouncement> getServices()
    {
        return services;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Announcement that = (Announcement) o;

        if (environment != null ? !environment.equals(that.environment) : that.environment != null) {
            return false;
        }
        if (location != null ? !location.equals(that.location) : that.location != null) {
            return false;
        }
        if (services != null ? !services.equals(that.services) : that.services != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = environment != null ? environment.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Announcement{" +
                "environment='" + environment + '\'' +
                ", location='" + location + '\'' +
                ", services=" + services +
                '}';
    }
}
