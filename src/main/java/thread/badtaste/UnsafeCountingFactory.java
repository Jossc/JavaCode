package thread.badtaste;

import net.jcip.annotations.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author crazy
 * @title: UnsafeCountingFactory
 * @projectName JavaCode
 * @description: 非线程安全
 * @date 2020/6/11 17:01
 */
@NotThreadSafe
public class UnsafeCountingFactory implements Servlet {

    private int count;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        /**
         * count++; = count=count+1;
         * 这里操作分三步
         * 1.读
         * 2.改
         * 3.写
         */
        count++;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
