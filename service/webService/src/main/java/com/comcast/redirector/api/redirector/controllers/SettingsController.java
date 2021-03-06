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
 * @author Yuriy Dmitriev (ydmitriev@productengine.com)
 */

package com.comcast.redirector.api.redirector.controllers;

import com.comcast.redirector.api.model.ErrorMessage;
import com.comcast.redirector.common.RedirectorConstants;
import com.comcast.redirector.api.model.ExpressionValidationException;
import com.comcast.redirector.api.model.RedirectorConfig;
import com.comcast.redirector.api.redirector.service.ruleengine.IRedirectorConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path(RedirectorConstants.SETTINGS)
public class SettingsController {

    @Autowired
    IRedirectorConfigService redirectorConfigService;

    @GET
    @Path("redirectorConfig")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getRedirectorConfigSettings() {
        return Response.ok(redirectorConfigService.getRedirectorConfig()).build();
    }

    @POST
    @Path("redirectorConfig")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response saveRedirectorConfig(RedirectorConfig redirectorConfig, @Context UriInfo ui) {
        if (redirectorConfig == null) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage("Redirector Config is not correct: " + redirectorConfig)).build());
        }
        redirectorConfigService.saveRedirectorConfig(redirectorConfig);
        return Response.created(ui.getRequestUri()).entity(redirectorConfig).build();
    }
}
