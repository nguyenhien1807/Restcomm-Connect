/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package org.restcomm.connect.telephony.api;

import org.restcomm.connect.commons.annotations.concurrency.Immutable;
import org.restcomm.connect.commons.dao.Sid;

import java.net.URI;
import java.util.List;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 * @author jean.deruelle@telestax.com
 * @author gvagenas@telestax.com
 */
@Immutable
public final class CreateCall {
    public enum Type {
        CLIENT, PSTN, SIP, USSD
    };

    private final String from;
    private final String to;
    private final String username;
    private final String password;
    private final boolean isFromApi;
    private final int timeout;
    private final Type type;
    private final Sid accountId;
    private boolean createCDR = true;
    private final Sid parentCallSid;
    private final URI statusCallbackUrl;
    private final String statusCallbackMethod;
    private final List<String> statusCallbackEvent;

    public CreateCall(final String from, final String to, final String username, final String password,
            final boolean isFromApi, final int timeout, final Type type, final Sid accountId, final Sid parentCallSid,
            final URI statusCallbackUrl, final String statusCallbackMethod, final List<String> statusCallbackEvent) {
        super();
        this.from = from;
        this.to = to;
        this.username = username;
        this.password = password;
        this.isFromApi = isFromApi;
        this.timeout = timeout;
        this.type = type;
        this.accountId = accountId;
        this.parentCallSid = parentCallSid;
        this.statusCallbackUrl = statusCallbackUrl;
        this.statusCallbackMethod = statusCallbackMethod;
        this.statusCallbackEvent = statusCallbackEvent;
    }

    public String from() {
        return from;
    }

    public String to() {
        return to;
    }

    public boolean isFromApi() {
        return isFromApi;
    }

    public int timeout() {
        return timeout;
    }

    public Type type() {
        return type;
    }

    public Sid accountId() {
        return accountId;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public boolean isCreateCDR() {
        return createCDR;
    }

    public void setCreateCDR(boolean createCDR) {
        this.createCDR = createCDR;
    }

    public Sid parentCallSid() {
        return parentCallSid;
    }

    public URI statusCallback() { return statusCallbackUrl; }

    public String statusCallbackMethod() { return statusCallbackMethod; }

    public List<String> statusCallbackEvent() { return statusCallbackEvent; }
}
