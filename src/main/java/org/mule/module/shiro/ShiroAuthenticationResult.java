/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.shiro;

import org.mule.api.MuleEvent;
import org.mule.api.security.Authentication;

import java.util.Map;

import org.apache.shiro.subject.Subject;

public class ShiroAuthenticationResult implements Authentication
{
	private static final long serialVersionUID = -4007028153583360863L;

	private transient final Subject subject;
    private boolean authenticated;
    private Map<String,Object> properties;
    private transient final MuleEvent event;

    public ShiroAuthenticationResult(Subject subject, MuleEvent event)
    {
        this(subject, null, event);
    }
    
    public ShiroAuthenticationResult(Subject subject, Map<String,Object> properties, MuleEvent event)
    {
        this.subject = subject;
        this.properties = properties;
        this.event = event;
    }

    public void setAuthenticated(boolean b)
    {
        this.authenticated = b;
    }

    public boolean isAuthenticated()
    {
        return authenticated;
    }

    public Object getCredentials()
    {
        return null;
    }

    public Object getPrincipal()
    {
        return subject.getPrincipals();
    }

    public Map<String,Object> getProperties()
    {
        return properties;
    }

    public void setProperties(Map<String,Object> properties)
    {
        this.properties = properties;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public MuleEvent getEvent()
    {
        return event;
    }

}
