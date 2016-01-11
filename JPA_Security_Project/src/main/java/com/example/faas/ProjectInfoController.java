package com.example.faas;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.faas.dtoex.Project;
import com.example.faas.security.CustomUserDetail;
import com.example.faas.service.ProjectService;
import com.example.faas.util.JsonBuilder;
import com.example.faas.util.NumberGenerator;

@Controller
public class ProjectInfoController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/createproject")
	public String createProject() {
		return "create_project";
	}

	@RequestMapping(value = "/ProjectInfo", method = RequestMethod.PUT)
	public String addProjectInfo(@RequestParam("name") String name,
			@RequestParam("description") String description,
			Authentication auth, HttpServletResponse res) {

		Project cproject = new Project(name, description);

		CustomUserDetail userDetail = (CustomUserDetail) auth.getPrincipal();
		
		cproject = projectService.createProject(cproject,
				userDetail.getPerson());
		try {
			if (cproject != null) {
				res.sendRedirect("ProjectInfo/" + cproject.getIdx());
			} else {
				return "create_project";
			}
			return null;
		} catch (IOException e) {
			return "create_project";
		}

	}

	@RequestMapping(value = "/ProjectInfo/{projectID}", method = RequestMethod.GET)
	public ModelAndView getProjectInfo(@PathVariable String projectID,
			ModelAndView model, HttpServletResponse res, HttpServletRequest rq) {

		Project project = null;
		if (NumberGenerator.tryParseInt(projectID)) {
			int pid = Integer.parseInt(projectID);
			project = projectService.getProjectInfo(pid);
		}

		if (project != null) {
			model.addObject("project", project);
			model.setViewName("project_info");

			Cookie cookie = new Cookie("currentProject", project.toString());
			cookie.setPath("/");
			res.addCookie(cookie);

		} else {
			try {
				res.sendRedirect("ProjectList");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return model;
	}

	@RequestMapping(value = "/ProjectList", method = RequestMethod.GET)
	public ModelAndView getProjectList(HttpSession session,
			Authentication auth, ModelAndView model) {
		CustomUserDetail userDetail = (CustomUserDetail) auth.getPrincipal();

		List<Project> list = projectService.getProjectList(userDetail
				.getPerson());

		model.addObject("projects", list);
		model.setViewName("project_list");

		return model;
	}

}
