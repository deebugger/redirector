/**
 * Copyright 2017 Comcast Cable Communications Management, LLC
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
 * @author Paul Guslisty (pguslisty@productengine.com)
 */

package com.comcast.redirector.api.model.validation.visitor.redirector;

import com.comcast.redirector.api.model.InIpRange;
import com.comcast.redirector.api.model.Value;
import com.comcast.redirector.api.model.validation.ModelValidationVisitor;
import com.comcast.redirector.api.model.validation.ValidationState;
import com.comcast.redirector.common.util.IpAddressValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@ModelValidationVisitor(forClass = InIpRange.class)
public class InIpRangeExpressionValidationVisitor extends ContainsBaseExpressionValidationVisitor<InIpRange> {
    public static final String IPV4_REGEX = "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
    public static Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

    private static final String IP_RANGE_TYPE = "NAMESPACEDLIST";

    @Override
    public void visit(InIpRange item) {
        super.visit(item);

        if (StringUtils.isNotBlank(item.getType()) && !item.getType().toUpperCase().equals(IP_RANGE_TYPE)) {
           getValidationState().pushError(ValidationState.ErrorType.IpRangeTypeError);
        }

        if (item.getValues() != null) {
            for (Value value : item.getValues()) {
                String ipAddress = value.getValue();
                if (!IpAddressValidator.isValidIpString(ipAddress)) {
                     getValidationState().pushError(ValidationState.ErrorType.ValueIPV6_4TypeError);
                }
            }
        }
    }
}
