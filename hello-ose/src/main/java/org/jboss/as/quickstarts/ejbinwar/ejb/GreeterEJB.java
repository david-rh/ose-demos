/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.ejbinwar.ejb;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.ejb.Stateful;

/**
 * A simple Hello World EJB. The EJB does not use an interface.
 * 
 */
@Stateful
public class GreeterEJB {
    /**
     * This method takes a name and returns a personalized greeting.
     * 
     * @param name the name of the person to be greeted
     * @return the personalized greeting.
     */
    public String sayHello(String name) {
    	String msg = "Hello " + name;
    	msg = appendLocalIP(msg);
        return msg;
    }

	private String appendLocalIP(String msg) {
		String hostAddress = "unknown";
		try {
			hostAddress = Inet4Address.getLocalHost().getHostAddress();
			
			msg+= ".  Pod address is " + hostAddress;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return msg;
	}
}
