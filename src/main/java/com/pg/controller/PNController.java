package com.pg.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pg.model.Notification;
import com.pg.util.App;
import com.pg.util.Constants;

@Controller
public class PNController {

	
	@RequestMapping(value = "/pn", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("pn", "notification", new Notification());
	}
	
	@RequestMapping(value = "/pnotification", method = RequestMethod.POST)
    public String submit(@ModelAttribute("notification")Notification notification, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        
        Map<String, String> data = new HashMap<String, String>();
 		data.put(Constants.TITLE, notification.getTitle());
 		data.put(Constants.BODY, notification.getMessageBody());
 		if(notification.getButton1() != null && !notification.getButton1().equals("")){
 			data.put(Constants.BUTTON_1, notification.getButton1());
 		}
 		if(notification.getButton2() != null && !notification.getButton2().equals("")){
 			data.put(Constants.BUTTON_2, notification.getButton2());
 		}
 		if(notification.getButton3() != null && !notification.getButton3().equals("")){
 			data.put(Constants.BUTTON_3, notification.getButton3());
 		}
        
        try {
			String response = App.sendPost(data, notification.getId());
			notification.clear();
			model.addAttribute("message", response.substring(0,response.indexOf('[')));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Error in Push Notification");
		}
       
        return "pn";
    }
}
