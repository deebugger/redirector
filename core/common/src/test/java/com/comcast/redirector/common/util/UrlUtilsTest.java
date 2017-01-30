/*
 * Copyright 2016 Comcast Cable Communications Management, LLC
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
 *
 * @author Alexander Ievstratiev (oievstratiev@productengine.com)
 */

package com.comcast.redirector.common.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class UrlUtilsTest {

    @Test
    public void testBuildUrl() throws Exception {
        String expectedString = "http://localhost:10540/redirector/data/index.html";

        String actualString = UrlUtils.buildUrl("http://localhost:10540/redirector/" , "/data/index.html");
        Assert.assertEquals(expectedString, actualString);

        actualString = UrlUtils.buildUrl("http://localhost:10540/redirector" , "data/index.html");
        Assert.assertEquals(expectedString, actualString);

        actualString = UrlUtils.buildUrl("http://localhost:10540/redirector/" , "data/index.html");
        Assert.assertEquals(expectedString, actualString);

        actualString = UrlUtils.buildUrl("http://localhost:10540/redirector" , "/data/index.html");
        Assert.assertEquals(expectedString, actualString);

    }

}