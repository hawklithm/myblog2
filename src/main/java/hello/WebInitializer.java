package hello;

import org.hawklithm.backyard.config.Application;
import org.hawklithm.backyard.config.DataConfig;
import org.hawklithm.backyard.web.controller.HomeController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by bluehawky on 2014/12/9 0009.
 */
public class WebInitializer extends  SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DataConfig.class,Application.class, ScheduledTasks.class);
    }
}
