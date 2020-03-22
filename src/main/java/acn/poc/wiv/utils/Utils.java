package acn.poc.wiv.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    Logger logger = LoggerFactory.getLogger(Utils.class);
    private Environment env;

    public Utils() {}

    @Autowired
    public Utils(Environment env){
        this.env = env;
    }


}
