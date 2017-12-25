package person.liuxx.druiddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import person.liuxx.druiddemo.service.DemoService;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年12月25日 下午2:45:35
 * @since 1.0.0
 */
@RestController
public class DeomController
{
    @Autowired
    private DemoService service;

    @GetMapping("/demo")
    public String demo()
    {
        return service.demo();
    }
}
