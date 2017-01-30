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
 * @author Paul Guslisty (pguslisty@productengine.com)
 */

package com.comcast.redirector.dataaccess.cache.newzkstackscache;

import com.comcast.redirector.api.model.xrestack.HostIPs;
import com.comcast.redirector.api.model.xrestack.XreStackPath;
import com.comcast.redirector.dataaccess.cache.IDataListener;
import com.comcast.redirector.dataaccess.client.DataSourceConnectorException;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface IServiceDiscovery {

    List<HostIPs> getHosts(XreStackPath path) throws DataSourceConnectorException;
    int getHostsCount(XreStackPath path) throws DataSourceConnectorException;
    HostIPs getHostByIndex(XreStackPath path, int index) throws DataSourceConnectorException;

    Set<XreStackPath> getAllStackPaths();
    List<String> getAppVersionsDeployedOnStack(String stack, String appName);
    List<XreStackPath> getPathsForStackAndApp(String stack, String appName);

    void discoverAppsAndStacksChanges(int newVersion, Consumer<Integer> updateCurrentVersion) throws Exception;
}