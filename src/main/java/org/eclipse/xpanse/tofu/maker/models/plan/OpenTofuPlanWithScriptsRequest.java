/*
 * SPDX-License-Identifier: Apache-2.0
 * SPDX-FileCopyrightText: Huawei Inc.
 */

package org.eclipse.xpanse.tofu.maker.models.plan;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Data model for the generating openTofu plan.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OpenTofuPlanWithScriptsRequest extends OpenTofuPlanFromDirectoryRequest {

    @NotNull
    @Schema(description = "Map of script files to be considered for generating openTofu plan")
    private Map<String, String> scriptsMap;

}
