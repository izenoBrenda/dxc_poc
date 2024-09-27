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
public class S2External {

    private static final Logger logger = LoggerFactory.getLogger(S2External.class);
	
    private String src;
    private String s_type;
    private String s_value;

    // Default constructor
    public S2External() {}

    @JsonCreator
    public S2External(String src, String s_type, String s_value) {
        this.src = src;
        this.s_type = s_type;
        this.s_value = s_value;
    }

    // Getters and setters
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        if (src == "") {
            this.src = null;
        } else {
            this.src = src;
        }
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getS_value() {
        return s_value;
    }

    public void setS_value(String s_value) {
        this.s_value = s_value;
    }

    // @Override
    public String toString() {
        return "{src='" + src + "', s_type='" + s_type + "', s_value='" + s_value + "'}";
    }
}