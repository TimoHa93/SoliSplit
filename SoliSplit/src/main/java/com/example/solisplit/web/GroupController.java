package com.example.solisplit.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/groups")
public class GroupController {
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getGroup(ModelMap model) {
		// this should fetch groups from the database for the looged in user
		return "group";
	}
}
