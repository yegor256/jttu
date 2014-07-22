/**
 * Copyright (c) 2013-2014, bibrarian.com
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
package com.bibrarian.web;

import com.bibrarian.om.Book;
import com.bibrarian.om.Quote;
import com.bibrarian.om.Tag;
import com.bibrarian.om.Tags;
import com.jcabi.matchers.JaxbConverter;
import com.jcabi.matchers.XhtmlMatchers;
import com.rexsl.mock.UriInfoMocker;
import java.util.Collections;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test case for {@link JxQuote}.
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 1.0
 */
public final class JxQuoteTest {

    /**
     * JxQuote can be converted to XML.
     * @throws Exception If some problem inside
     */
    @Test
    public void convertsToXml() throws Exception {
        final Quote quote = Mockito.mock(Quote.class);
        Mockito.doReturn("the text").when(quote).text();
        Mockito.doReturn("34--35").when(quote).pages();
        final Book book = Mockito.mock(Book.class);
        Mockito.doReturn(book).when(quote).book();
        Mockito.doReturn("@article{test12,year=2012}").when(book).bibitem();
        Mockito.doReturn("hello").when(book).name();
        final Tags tags = Mockito.mock(Tags.class);
        Mockito.doReturn(tags).when(quote).tags();
        Mockito.doReturn(
            Collections.singleton(new Tag.Simple("jeff", "works-fine"))
        ).when(tags).iterate();
        MatcherAssert.assertThat(
            JaxbConverter.the(new JxQuote(quote, new UriInfoMocker().mock())),
            XhtmlMatchers.hasXPaths(
                "/quote[@id='0']",
                "/quote[text='the text']",
                "/quote/book[name='hello']",
                "/quote/links/link[@rel='open' and @href]",
                "/quote/tags/tag[user='jeff' and name='works-fine']"
            )
        );
    }

}
