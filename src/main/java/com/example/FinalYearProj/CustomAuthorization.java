package com.example.FinalYearProj;

import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Slf4j

public class CustomAuthorization {
    public boolean pathMatches(ArrayList<String> allowedServletPaths, String servletPath){
        for (String allowedServletPath : allowedServletPaths) {
            if (servletPath.startsWith(allowedServletPath)) {
                return true;
            }
        }
        return false;
    }


    private void returnFailString(HttpServletResponse response){
        response.setContentType("application/json");
        JsonMapper jsonMapper = new JsonMapper();
        Map<String, String> map = new HashMap<>();
        map.put("response", "failed authorization");
        try {
            jsonMapper.writeValue(response.getOutputStream(), map);
        }catch (Exception e){
            log.warn(e.getMessage());
        }
}
}
