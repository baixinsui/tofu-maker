/*
 * SPDX-License-Identifier: Apache-2.0
 * SPDX-FileCopyrightText: Huawei Inc.
 */

package org.eclipse.xpanse.tofu.maker.models.request.directory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Data;
import org.eclipse.xpanse.tofu.maker.opentofu.tool.OpenTofuVersionsHelper;

/** Data model for the OpenTofu deploy requests. */
@Data
public class OpenTofuDeployFromDirectoryRequest {

    @Schema(description = "Id of the request.")
    private UUID requestId;

    @NotNull
    @NotBlank
    @Pattern(regexp = OpenTofuVersionsHelper.OPENTOFU_REQUIRED_VERSION_REGEX)
    @Schema(description = "The required version of the OpenTofu which will execute the scripts.")
    private String openTofuVersion;

    @NotNull
    @Schema(
            description =
                    "Flag to control if the deployment must only generate the OpenTofu "
                            + "or it must also apply the changes.")
    private Boolean isPlanOnly;

    @NotNull
    @Schema(
            description =
                    "Key-value pairs of variables that must be used to execute the "
                            + "OpenTofu request.")
    private Map<String, Object> variables;

    @Schema(
            description =
                    "Key-value pairs of variables that must be injected as environment "
                            + "variables to OpenTofu process.")
    private Map<String, String> envVariables = new HashMap<>();
}
