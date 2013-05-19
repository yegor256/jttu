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
package com.bibrarian.om;

import com.jcabi.aspects.Immutable;
import com.jcabi.aspects.Loggable;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * One discovery in a hypothesis.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id: BaseRs.java 2344 2013-01-13 18:28:44Z guard $
 */
@Immutable
@SuppressWarnings("PMD.TooManyMethods")
public interface Discovery extends Comparable<Discovery> {

    /**
     * Hypothesis it is related to.
     * @return The hypothesis
     */
    @NotNull
    Hypothesis hypothesis();

    /**
     * Quote.
     * @return The text
     */
    @NotNull
    String quote();

    /**
     * Set quote.
     * @param text The text
     */
    void quote(@NotNull String text);

    /**
     * Where found, page numbers.
     * @return The pages
     */
    @NotNull
    String pages();

    /**
     * Set page numbers.
     * @param pages The pages
     */
    void pages(@NotNull String pages);

    /**
     * Relevance.
     * @return The relevance
     */
    float relevance();

    /**
     * Set relevance.
     * @param relevance The relevance
     */
    void relevance(float relevance);

    /**
     * Simple implementation.
     */
    @Loggable(Loggable.DEBUG)
    @ToString
    @EqualsAndHashCode(of = { "hypo", "qte", "pgs", "rlv" })
    final class Simple implements Discovery {
        /**
         * Hypothesis.
         */
        private final transient Hypothesis hypo;
        /**
         * Quote.
         */
        private final transient String qte;
        /**
         * Pages.
         */
        private final transient String pgs;
        /**
         * Relevance.
         */
        private final transient float rlv;
        /**
         * Public ctor.
         * @param hypothesis The hypothesis
         */
        public Simple(@NotNull final Hypothesis hypothesis) {
            this(hypothesis, "", "", 0f);
        }
        /**
         * Public ctor.
         * @param hypothesis The hypothesis
         * @param quote The description
         * @param pages The pages
         * @param relevance The relevance
         * @checkstyle ParameterNumber (5 lines)
         */
        public Simple(@NotNull final Hypothesis hypothesis,
            @NotNull final String quote, @NotNull final String pages,
            @NotNull final float relevance) {
            this.hypo = hypothesis;
            this.qte = quote;
            this.pgs = pages;
            this.rlv = relevance;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public String quote() {
            return this.qte;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public String pages() {
            return this.pgs;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public void quote(final String text) {
            throw new UnsupportedOperationException();
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public Hypothesis hypothesis() {
            return this.hypo;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public void pages(final String pages) {
            throw new UnsupportedOperationException();
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public float relevance() {
            throw new UnsupportedOperationException();
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public void relevance(final float relevance) {
            throw new UnsupportedOperationException();
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public int compareTo(final Discovery discovery) {
            return this.qte.compareTo(discovery.quote());
        }
    }

}
