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
 * @author Alexander Binkovsky (abinkovski@productengine.com)
 */

package com.comcast.redirector.core.engine.rules;

import com.comcast.redirector.ruleengine.model.Model;
import com.comcast.redirector.ruleengine.model.DistributionServer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FlavorRuleSet extends RuleSet<Model> implements IFlavorRuleSet {

    public FlavorRuleSet(Model model) {
        super(model);
    }

    @Override
    public Object getResult(Map<String, String> context) {
        return (isAvailable()) ? model.execute(context) : null;
    }

    @Override
    public Object getDefault() {
        return (isAvailable()) ? model.executeDefault(Collections.<String, String>emptyMap()) : null;
    }

    @Override
    public List<DistributionServer> getDistributionServers() {
        return (isAvailable()) ? model.getDistribution() : null;
    }
}
