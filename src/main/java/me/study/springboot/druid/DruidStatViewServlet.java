package me.study.springboot.druid;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 *
 * @author 
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "loginUsername", value = "test"), @WebInitParam(name = "loginPassword", value = "test") })
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = 1L;

}

