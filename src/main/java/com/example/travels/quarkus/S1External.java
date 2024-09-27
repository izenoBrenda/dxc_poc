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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class S1External {

    private static final Logger logger = LoggerFactory.getLogger(S1External.class);
	
    private String src;
    private String s_type;
    private int s_value_min;
    private int s_value_max;
    private String s_info;

    // Default constructor
    public S1External() {}

    @JsonCreator
    public S1External(String src, String s_type, int s_value_min, int s_value_max, String s_info) {
        this.src = src;
        this.s_type = s_type;
        this.s_value_min = s_value_min;
        this.s_value_max = s_value_max;
        this.s_info = s_info;
    }

    // Getters and setters
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public int getS_value_min() {
        return s_value_min;
    }

    public void setS_value_min(int s_value_min) {
        this.s_value_min = s_value_min;  
    }

    public int getS_value_max() {
        return s_value_max;
    }

    public void setS_value_max(int s_value_max) {
        this.s_value_max = s_value_max;  
    }

    public String getS_info() {
        return s_info;
    }

    public void setS_info(String s_info) {
        this.s_info = s_info;
    }

    // @Override
    public String toString() {
        return "{src='" + src + "', s_type='" + s_type + "', s_value_min='" + s_value_min + "', s_value_max='" + s_value_max + "', s_info='" + s_info + "'}";
    }
}