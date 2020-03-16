package work.ccpw.community.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import work.ccpw.community.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: community
 * @description: 异常处理
 * @author: cone
 * @create: 2020-03-16 11:44
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model) {
        HttpStatus status = getStatus(request);
        if(ex instanceof CustomizeException){
            model.addAttribute("message",ex.getMessage());
        }else {
            model.addAttribute("message","服务冒烟了,要不然你稍后再试试!!!");
        }
        return  new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
