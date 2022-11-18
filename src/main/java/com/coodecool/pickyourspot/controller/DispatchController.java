package com.coodecool.pickyourspot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchController extends HttpServlet {

    // private Map<String, Map<String, Method<?, ?>>> handlers;

    // public DispatchController() {
    //     for (Class<?> clazz : getAllClasses()) {
    //         var annotations = clazz.getAnnotations();
    //         if (annotations.contains(Controller.class)) {
    //             for (Method<?, ?> method : clazz.getMethods()) {
    //                 var methodAnnotations = method.getAnnotations();
    //                 if (methodAnnotations.contains(GetMapping)) {
    //                     var getHandlers = handlers.get("GET");
    //                     getHandlers.put(getURLFromAnnotation, method);
    //                 }
    //             }
    //         }
    //     }
    // }

    // @Override
    // protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     var requestMethod = req.getMethod();
    //     var requestUrl = req.getRequestURI();
    //     var methodToCall = handlers.get(requestMethod).get(requestUrl);
    //     // analyze method parameters

    //     // build parameters

    //     // call method
    // }

}
