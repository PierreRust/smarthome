/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.thing.type;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.smarthome.core.thing.Channel;
import org.eclipse.smarthome.core.thing.Thing;

/**
 * The {@link ChannelDefinition} class defines a {@link Channel} of a {@link ThingType}.
 * <p>
 * A {@link Channel} is part of a {@link Thing} that represents a functionality of it.
 * <p>
 * <b>Hint:</b> This class is immutable.
 *
 * @author Michael Grammling - Initial Contribution
 * @author Chris Jackson - Added properties
 */
public class ChannelDefinition {

    private String id;
    private ChannelType type;
    private final Map<String, String> properties;

    /**
     * Creates a new instance of this class with the specified parameters.
     *
     * @param id the identifier of the channel (must neither be null nor empty)
     * @param type the type of the channel (must not be null)
     *
     * @throws IllegalArgumentException if the ID is null or empty, or the type is null
     */
    public ChannelDefinition(String id, ChannelType type) throws IllegalArgumentException {
        this(id, type, null);
    }

    /**
     * Creates a new instance of this class with the specified parameters.
     *
     * @param id the identifier of the channel (must neither be null nor empty)
     * @param type the type of the channel (must not be null)
     * @param properties the properties this Channel provides (could be null)
     *
     * @throws IllegalArgumentException if the ID is null or empty, or the type is null
     */
    public ChannelDefinition(String id, ChannelType type, Map<String, String> properties)
            throws IllegalArgumentException {
        if ((id == null) || (id.isEmpty())) {
            throw new IllegalArgumentException("The ID must neither be null nor empty!");
        }

        if (type == null) {
            throw new IllegalArgumentException("The channel type must not be null");
        }

        if (properties != null) {
            this.properties = Collections.unmodifiableMap(properties);
        } else {
            this.properties = Collections.unmodifiableMap(new HashMap<String, String>(0));
        }

        this.id = id;
        this.type = type;
    }

    /**
     * Returns the identifier of the channel.
     *
     * @return the identifier of the channel (neither null, nor empty)
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the type of the channel.
     *
     * @return the type of the channel (not null)
     */
    public ChannelType getType() {
        return this.type;
    }

    /**
     * Returns the properties for this {@link ChannelDefinition}
     * 
     * @return the properties for this {@link ChannelDefinition} (not null)
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "ChannelDefinition [id=" + id + ", type=" + type + ", properties=" + properties + "]";
    }

}
