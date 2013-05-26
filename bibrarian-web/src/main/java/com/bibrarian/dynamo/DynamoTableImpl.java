/**
 * Copyright (c) 2013, bibrarian.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the bibrarian.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.bibrarian.dynamo;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.google.common.base.Function;
import com.jcabi.aspects.Immutable;
import java.util.Collection;
import java.util.Map;
import javax.validation.constraints.NotNull;

/**
 * Implementation of {@link DynamoTable}.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id: BaseRs.java 2344 2013-01-13 18:28:44Z guard $
 */
@Immutable
final class DynamoTableImpl implements DynamoTable {

    /**
     * AWS credentials.
     */
    private final transient DynamoCredentials credentials;

    /**
     * Table name.
     */
    private final transient String table;

    /**
     * Public ctor.
     * @param creds Credentials
     * @param name Table name
     */
    protected DynamoTableImpl(@NotNull final DynamoCredentials creds,
        @NotNull final String name) {
        this.credentials = creds;
        this.table = name;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public <T> Collection<T> scan(@NotNull final ScanRequest request,
        @NotNull final Function<Map<String, AttributeValue>, T> mapping) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void put(@NotNull final T item,
        @NotNull final Function<T, Map<String, AttributeValue>> reverse) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(@NotNull final DeleteItemRequest request) {
    }

}
