/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.webgoat.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * <p>SessionService class.</p>
 *
 * @author rlawson
 * @version $Id: $Id
 */
@Controller
public class ContrastService {

    /**
     * Returns hints for current lesson
     *
     * @param session a {@link javax.servlet.http.HttpSession} object.
     * @param request a {@link javax.servlet.http.HttpServletRequest} object.
     * @return a {@link java.lang.String} object.
     */
    @RequestMapping(path = "/service/contrast.mvc", produces = "application/json")
    public @ResponseBody
    String showInfo(HttpServletRequest request, HttpSession session) {
        
        StringBuilder sb = new StringBuilder();
        try {
          Class<?> cls = Class.forName("com.contrastsecurity.agent.ContrastAgent");
          java.lang.reflect.Method getBuildVersion = cls.getDeclaredMethod("getBuildVersion", new Class[0]);
          getBuildVersion.setAccessible(true);
          String buildVersion = (String)getBuildVersion.invoke(null, new Object[0]);
          sb.append("Contrast agent version: " + buildVersion);
        } catch (Exception e) {
          sb.append("No Contrast Agent Available");
        }
        return sb.toString();
    }
}
