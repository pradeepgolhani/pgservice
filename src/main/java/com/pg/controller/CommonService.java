package com.pg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("FB_CHAT")
public class CommonService {

	private static final String FB_CHAT = "FB_CHAT";
	private static final String HUB_MODE = "hub.mode";
	private static final String HUB_CHALLENGE = "hub.challenge";
	private static final String HUB_VERIFY_TOKEN = "hub.verify_token";

	
	@ModelAttribute("FB_CHAT")
    public Map<String, String> getVisitor () {
        return new HashMap<String, String>();
    }
	
	@RequestMapping(value = "/fb/callback", method = RequestMethod.GET, produces = { "text/html" })
	@ResponseStatus(value = HttpStatus.OK)
	public void validateFacebookRequest(@ModelAttribute("FB_CHAT") Map<String, String> chatMap,
			@RequestParam(HUB_MODE) String hubMode,
			@RequestParam(HUB_CHALLENGE) String hubChallenge,
			@RequestParam(HUB_VERIFY_TOKEN) String hubVerifyToken,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			// hubVerifyToken based validation if desired
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(hubChallenge);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	@RequestMapping(value = "/fb/display", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView validateFacebookRequest(@ModelAttribute("FB_CHAT") Map<String, String> chatMap, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("display");
		return modelAndView;
	}


	@RequestMapping(value = "/fb/callback", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public void processFbRealtimeUpdate(@ModelAttribute("FB_CHAT") Map<String, String> chatMap, Model model, HttpServletRequest request,
			InputStream inputStream) {
		StringBuilder sb = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		String line;
		String json = "";

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			while ((line = reader.readLine()) != null)
				sb.append(line).append(newLine);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		json = sb.toString(); // use this json string for desired purpose
		System.out.println(json);
		Map<String, String> chatObjMap = null;
		
		if(!model.containsAttribute(FB_CHAT)){
			chatObjMap = new HashMap<String, String>();
			chatObjMap.put(""+System.currentTimeMillis(), json);
			model.addAttribute(FB_CHAT, chatObjMap);
			chatMap.put(""+System.currentTimeMillis(), json);
		}else{
			//chatMap.put(""+System.currentTimeMillis(), json);
			Map<String, String> chatObjMap2 = (Map<String, String>) request.getSession().getAttribute("FB_CHAT");
			chatMap.put(""+System.currentTimeMillis(), json);
			model.addAttribute(FB_CHAT, chatMap);
			chatMap.put(""+System.currentTimeMillis(), json);
		}
	}
}
