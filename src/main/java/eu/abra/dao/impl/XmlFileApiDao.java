package eu.abra.dao.impl;

import eu.abra.dao.ApiDao;
import eu.abra.dto.dev.wadl._2009._02.Application;
import eu.abra.dto.dev.wadl._2009._02.Resource;
import eu.abra.dto.dev.wadl._2009._02.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Component
public class XmlFileApiDao implements ApiDao {

    private static JAXBContext jaxbContext;

    @Autowired
    private ServletContext ctx;

    @Override
    public final List<Resources> getResources() throws JAXBException {
        String path = ctx.getRealPath("/WEB-INF/resources/twitter-wadl.xml");
        Application application = (Application) createUnmarshaller().unmarshal(new File(path));
        return application.getResources();
    }

    @Override
    public final Resource getByPath(String path) throws JAXBException {
        if (path == null) {
            return null;
        }
        for (Resources resources : getResources()) {
            for (Resource resource : resources.getResource()) {
                if (path.equals(resource.getPath())) {
                    return resource;
                }
            }
        }
        return null;
    }

    private Unmarshaller createUnmarshaller() throws JAXBException {
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(Application.class);
        }
        return jaxbContext.createUnmarshaller();
    }
}
