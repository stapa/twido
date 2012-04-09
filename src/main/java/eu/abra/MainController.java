package eu.abra;


import eu.abra.dao.ApiDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MainController {

    private static final Logger LOG = Logger.getLogger(MainController.class);

    @Autowired
    private ApiDao apiDao;

    @Autowired
    private MessageSource resources;

    @RequestMapping(value = "/")
    public final String index() {
        return "eu.abra.home";
    }

    @RequestMapping(value = "list")
    public final ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        try {
            mav.addObject("resourcesList", apiDao.getResources());
        } catch (Exception e) {
            error("error.docloading", e, mav.getModelMap());
        }
        mav.setViewName("eu.abra.list");
        return mav;
    }

    @RequestMapping(value = "detail")
    public final ModelAndView detail(String path) {
        ModelAndView mav = new ModelAndView();
        try {
            mav.addObject("resource", apiDao.getByPath(path));
        } catch (Exception e) {
            error("error.docloading", e, mav.getModelMap());
        }
        mav.setViewName("eu.abra.detail");
        return mav;
    }

    private void error(String messageCode, Throwable throwable, ModelMap modelMap) {
        List<String> errors;
        if (modelMap.containsKey("errors")) {
            errors = (List<String>) modelMap.get("errors");
        } else {
            errors = new ArrayList<String>();
            modelMap.addAttribute("errors", errors);
        }
        errors.add(resources.getMessage(messageCode, null, Locale.getDefault()));
        LOG.error("error", throwable);
    }
}