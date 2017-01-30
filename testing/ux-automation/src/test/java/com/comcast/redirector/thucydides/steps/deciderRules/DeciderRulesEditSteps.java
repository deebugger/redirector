/**
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
 */
package com.comcast.redirector.thucydides.steps.deciderRules;

import com.comcast.redirector.thucydides.pages.deciderRules.DeciderRulesEditPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DeciderRulesEditSteps extends ScenarioSteps {
    private DeciderRulesEditPage page;

    @Step
    public DeciderRulesEditSteps addCondition() {
        page.addCondition();
        return this;
    }

    @Step
    public DeciderRulesEditSteps addOrCondition() {
        page.addOrCondition();
        return this;
    }

    @Step
    public DeciderRulesEditSteps addXorCondition() {
        page.addXorCondition();
        return this;
    }

    @Step
    public DeciderRulesEditSteps setParameterName(String value) {
        page.setParameterName(value);
        return this;
    }

    public DeciderRulesEditSteps selectCondition(String value) {
        page.selectCondition(value);
        return this;
    }

    public DeciderRulesEditSteps setConditionValue(String value) {
        page.setConditionValue(value);
        return this;
    }

    public DeciderRulesEditSteps setConditionValueType(String valueType) {
        page.selectConditionValueType(valueType);
        return this;
    }

    public DeciderRulesEditSteps selectNamespacedList(String value) {
        page.selectNamespacedList(value);
        return this;
    }

    @Step
    public DeciderRulesEditSteps clickSaveButton() {
        page.clickSaveButton();
        return this;
    }

    @Step
    public DeciderRulesEditSteps verifySuccessToasterIsShown() {
        page.verifySuccessToasterIsShown();
        return this;
    }

    @Step
    public DeciderRulesEditSteps removeExpression() {
        page.removeExpression();
        return this;
    }
}