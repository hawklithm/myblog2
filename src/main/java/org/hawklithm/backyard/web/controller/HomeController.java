package org.hawklithm.backyard.web.controller;

import org.hawklithm.backyard.domain.dao.ArticleInfoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    @Qualifier("articleInfoDAO")
	private ArticleInfoDAO articleInfoDao;

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void index(Model model) {
		log.debug("In the HomeController::index");
		model.addAttribute("example", "Hello World!");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public void users(Model model) {
//		model.addAttribute("users", articleInfoDao.getArticleInfoByCreatorIdAndPage());
	}

	@RequestMapping(value = "/exceptions", method = RequestMethod.GET)
	public void exceptions(Model model, HttpSession session) {
		model.addAttribute("exceptionsState", isThrowingExceptions(session));
	}



	/**
	 * 
	 * @param session
	 * @return
	 */
	private boolean isThrowingExceptions(HttpSession session) {
		if (session.getAttribute("exceptionsToggle") == null) {
			log.debug("the exceptionToggle was null");
			session.setAttribute("exceptionsToggle", false);
		}
		return (Boolean) session.getAttribute("exceptionsToggle");
	}
}
