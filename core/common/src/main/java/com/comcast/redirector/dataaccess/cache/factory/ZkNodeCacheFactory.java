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

package com.comcast.redirector.dataaccess.cache.factory;

import com.comcast.redirector.dataaccess.client.IDataSourceConnector;
import com.comcast.redirector.dataaccess.cache.INodeCacheWrapper;
import com.comcast.redirector.dataaccess.cache.ZkNodeCacheWrapper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;

public class ZkNodeCacheFactory implements INodeCacheFactory {
    private IDataSourceConnector connector;
    private CuratorFramework curatorFramework;

    public ZkNodeCacheFactory(IDataSourceConnector connector, CuratorFramework curatorFramework) {
        this.connector = connector;
        this.curatorFramework = curatorFramework;
    }

    @Override
    public INodeCacheWrapper newNodeCacheWrapper(String path, boolean useCache) {
        return newNodeCacheWrapper(path, useCache, false);
    }

    @Override
    public INodeCacheWrapper newNodeCacheWrapper(String path, boolean useCache, boolean useCacheWhenNotConnectedToDataSource) {
        return newNodeCacheWrapper(path, useCache, useCacheWhenNotConnectedToDataSource, false);
    }

    @Override
    public INodeCacheWrapper newNodeCacheWrapper(String path, boolean useCache, boolean useCacheWhenNotConnectedToDataSource,
                                                 boolean isCompressed) {
        NodeCache cache = null;
        if (useCache || useCacheWhenNotConnectedToDataSource) {
            cache = new NodeCache(curatorFramework, path, isCompressed);
        }
        return new ZkNodeCacheWrapper(connector, path, cache, isCompressed, useCache, useCacheWhenNotConnectedToDataSource);
    }
}
