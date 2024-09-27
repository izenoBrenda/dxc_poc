/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example.travels.quarkus;

import java.lang.*;
import java.util.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RExternal {

    private static final Logger logger = LoggerFactory.getLogger(RExternal.class);
	
    private String src;
    private String r_num;
    private Boolean r_is_valid;

    // Default constructor
    public RExternal() {}

    // Parameterized constructor
    @JsonCreator
    public RExternal(@JsonProperty("src") String src, @JsonProperty("r_num") String r_num, @JsonProperty("r_is_valid") Boolean r_is_valid) {
        // logger.info("Hello World from RExternal class ... ");
        this.src = src;
        this.r_num = r_num;
        this.r_is_valid = r_is_valid;
    }

    // Getters and setters
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getR_num() {
        return r_num;
    }

    public void setR_num(String r_num) {
        this.r_num = r_num;
    }

    public Boolean getR_is_valid() {
        return r_is_valid;
    }

    public void setR_is_valid(String r_is_valid) {
        if (r_is_valid == "true") {
            this.r_is_valid = true;
        } else if (r_is_valid == "false") {
            this.r_is_valid = false;
        }
    }

    // @Override
    public String toString() {
        return "{src='" + src + "', r_num='" + r_num + "', r_is_valid=" + r_is_valid + "}";
    }
}