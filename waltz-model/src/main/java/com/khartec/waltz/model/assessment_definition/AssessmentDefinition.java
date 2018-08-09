/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017  Waltz open source project
 * See README.md for more information
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.khartec.waltz.model.assessment_definition;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.khartec.waltz.model.*;
import com.khartec.waltz.model.user.Role;
import org.immutables.value.Value;

import java.util.Optional;


@Value.Immutable
@JsonSerialize(as = ImmutableAssessmentDefinition.class)
@JsonDeserialize(as = ImmutableAssessmentDefinition.class)
public abstract class AssessmentDefinition implements
        IdProvider,
        ExternalIdProvider,
        NameProvider,
        DescriptionProvider,
        LastUpdatedProvider,
        ProvenanceProvider {

    public abstract EntityKind entityKind();

    public abstract long ratingSchemeId();

    public abstract Optional<Role> permittedRole();

    public abstract boolean isReadOnly();
}
