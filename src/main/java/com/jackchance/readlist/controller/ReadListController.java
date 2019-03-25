package com.jackchance.readlist.controller;

import com.jackchance.readlist.data.Book;
import com.jackchance.readlist.jpa.ReadListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller注解，组件扫描会自动将其注册为Spring程序上下文中的Bean
 * RequestMapping注解，将该处理方法映射到URL上
 */
@RestController
@RequestMapping("/readList")
public class ReadListController {

    @Autowired
    private ReadListRepository readListRepository;

    public ReadListController(ReadListRepository readListRepository) {
        this.readListRepository = readListRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getBookList() {
        return readListRepository.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Book save(Book book) {
        return readListRepository.save(book);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<Book> delete(Long id) {
        readListRepository.deleteById(id);
        return readListRepository.findAll();
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book) {
        return readListRepository.save(book);
    }

    /**
     * 处理/{reader}上的HTTP GET请求
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBook(@PathVariable("reader") String reader,
                              Model model) {
        List<Book> readList = readListRepository.findByReader(reader);  //基于URL中的参数从仓库中取数据
        if (readList != null) {
            model.addAttribute("books", readList);  //将列表塞入模型，键为books
        }
        return "readList";  //返回readList作为逻辑视图名称
    }

    /**
     * 处理/{reader}上的HTTP POST请求
     * 将请求正文里的数据绑定到一个book对象里
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadList(@PathVariable("reader") String reader,
                                Book book) {
        book.setReader(reader);     //写入读者信息
        readListRepository.save(book);      //保存修改后的book信息
        return "redirect://readList/{reader}";  //重定向到/{reader},controller中的另一个方法会处理这个请求
    }

}
