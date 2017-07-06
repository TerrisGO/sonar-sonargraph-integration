/**
 * SonarQube Sonargraph Integration Plugin
 * Copyright (C) 2016-2017 hello2morrow GmbH
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
package com.hello2morrow.sonargraph.integration.sonarqube.foundation;

import java.util.List;

import com.hello2morrow.sonargraph.integration.access.model.IIssue;
import com.hello2morrow.sonargraph.integration.access.model.IIssueProvider;
import com.hello2morrow.sonargraph.integration.access.model.IIssueType;
import com.hello2morrow.sonargraph.integration.access.model.INamedElement;
import com.hello2morrow.sonargraph.integration.access.model.IResolution;

public class StandardFixResolutionIssue implements IIssue
{
    private static final long serialVersionUID = -6480457296024358084L;
    private final IIssue issue;
    private final IResolution resolution;

    public StandardFixResolutionIssue(final IResolution resolution, final IIssue issue)
    {
        this.resolution = resolution;
        this.issue = issue;
    }

    @Override
    public final IIssueProvider getIssueProvider()
    {
        return new StandardFixIssueProvider();
    }

    protected final IResolution getResolution()
    {
        return resolution;
    }

    @Override
    public final IIssueType getIssueType()
    {
        return new FixResolutionIssueType();
    }

    @Override
    public final boolean hasResolution()
    {
        return true;
    }

    public final IIssue getIssue()
    {
        return issue;
    }

    @Override
    public String getDescription()
    {
        return resolution.getDescription() + ", assignee=" + getResolution().getAssignee() + ", created=" + getResolution().getDate() + "\n"
                + issue.getDescription();
    }

    @Override
    public List<INamedElement> getOrigins()
    {
        return issue.getOrigins();
    }

    @Override
    public int getLineNumber()
    {
        return issue.getLineNumber();
    }
}
