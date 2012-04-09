package eu.abra.dao;

import eu.abra.dto.dev.wadl._2009._02.Resource;
import eu.abra.dto.dev.wadl._2009._02.Resources;

import java.util.List;

public interface ApiDao {

    /**
     * Get all available {@link Resources}.
     * @return A list of resources objects, never {@code null}.
     * @throws Exception announces an error occurred.
     */
    List<Resources> getResources() throws Exception;

    /**
     * Get {@link Resource} by its path.
     * @param path {@see Resource#path}
     * @return The resource object or {@code null} if doesn't exist.
     * @throws Exception announces an error occurred
     */
    Resource getByPath(String path) throws Exception;
}
