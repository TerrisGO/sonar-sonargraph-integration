/**
 * SonarQube Sonargraph Integration Plugin
 * Copyright (C) 2016-2018 hello2morrow GmbH
 * mailto: support AT hello2morrow DOT com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hello2morrow.sonargraph.integration.sonarqube;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.hello2morrow.sonargraph.integration.sonarqube.SonargraphBase.CustomMetricsPropertiesProvider;

final class TestSupportMetricPropertiesProvider extends CustomMetricsPropertiesProvider
{
    private static final String CUSTOM_METRICS_DIRECTORY = "./src/test/." + SonargraphBase.SONARGRAPH_PLUGIN_KEY;

    public TestSupportMetricPropertiesProvider() throws IOException
    {
        reset();
    }

    @Override
    public String getDirectory()
    {
        return CUSTOM_METRICS_DIRECTORY;
    }

    private void reset() throws IOException
    {
        final Path metricProps = Paths.get(getFilePath());
        if (metricProps.toFile().exists())
        {
            Files.delete(metricProps);
        }
    }
}
