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
package com.example.travels.services;

import com.example.travels.quarkus.VExternal;
import com.example.travels.quarkus.RExternal;
import com.example.travels.quarkus.S1External;
import com.example.travels.quarkus.S2External;

import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.kie.kogito.internal.process.runtime.KogitoWorkItem;
import org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler;
import org.kie.kogito.internal.process.runtime.KogitoWorkItemManager;

@ApplicationScoped
public class TransformingService implements KogitoWorkItemHandler {

    @Override
    public void executeWorkItem(KogitoWorkItem workItem, KogitoWorkItemManager manager) {
        System.out.println("Hello from the custom work item definition.");
        System.out.println("Passed parameters:");
   }
    @Override
    public void abortWorkItem(KogitoWorkItem workItem, KogitoWorkItemManager manager) {
        System.err.println("Error happened in the custom work item definition.");
   }

    public VExternal transformingVData(String VExternal) {
        System.out.println("Entering transformingVData ... ");

        ObjectMapper objectMapper = new ObjectMapper();
        // Create SimpleDateFormat for parsing the date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            // Parse JSON into a JsonNode object
            JsonNode jsonNode = objectMapper.readTree(VExternal);

            // Extract values
            String src = jsonNode.get("src").asText();
            String eType = jsonNode.get("e_type").asText();
            String eNum = jsonNode.get("e_num").asText();
            String eValidTill = jsonNode.get("e_valid_till").asText();
            String additionNum = jsonNode.get("addition_num").asText();

            // Get today's date
            Date today = new Date();
            Date e_valid_till = dateFormat.parse(eValidTill);
            if (e_valid_till.before(today)) {
                eValidTill = "Discard";
            } else {
                eValidTill = "Continue";
            }

            System.out.println("Converted Date: " + e_valid_till);
            VExternal vExternal = new VExternal();
            vExternal.setSrc(src);
            vExternal.setE_num(eNum);
            vExternal.setE_type(eType);
            vExternal.setE_valid_till(eValidTill);
            vExternal.setAddition_num(additionNum);

            return vExternal;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public RExternal transformingRData(String RExternal) {
        System.out.println("Entering transformingRData ... ");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse JSON into a JsonNode object
            JsonNode jsonNode = objectMapper.readTree(RExternal);

            // Extract values
            String src = jsonNode.get("src").asText();
            String rNum = jsonNode.get("r_num").asText();
            String rIsValid = jsonNode.get("r_is_valid").asText();
            RExternal rExternal = new RExternal();
            rExternal.setSrc(src);
            rExternal.setR_num(rNum);
            rExternal.setR_is_valid(rIsValid);

            return rExternal;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public S1External transformingS1Data(String S1External) {
        System.out.println("Entering transformingS1Data ... ");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse JSON into a JsonNode object
            JsonNode jsonNode = objectMapper.readTree(S1External);

            // Extract values
            String src = jsonNode.get("src").asText();
            String sType = jsonNode.get("s_type").asText();
            int sValueMin = jsonNode.get("s_value_min").asInt();
            int sValueMax = jsonNode.get("s_value_max").asInt();
            String sInfo = jsonNode.get("s_info").asText();
            S1External s1External = new S1External();
            s1External.setSrc(src);
            s1External.setS_type(sType);
            s1External.setS_value_min(sValueMin);
            s1External.setS_value_max(sValueMax);
            s1External.setS_info(sInfo);

            return s1External;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public S2External transformingS2Data(String S2External) {
        System.out.println("Entering transformingS2Data ... ");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse JSON into a JsonNode object
            JsonNode jsonNode = objectMapper.readTree(S2External);

            // Extract values
            String src = jsonNode.get("src").asText();
            String sType = jsonNode.get("s_type").asText();
            String sValue = jsonNode.get("s_value").asText();
            S2External s2External = new S2External();
            s2External.setSrc(src);
            s2External.setS_type(sType);
            s2External.setS_value(sValue);

            return s2External;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}