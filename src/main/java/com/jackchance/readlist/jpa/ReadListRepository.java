package com.jackchance.readlist.jpa;

import com.jackchance.readlist.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);     //用来查找的方法
}
/**
 * 通过继承JpaRepository接口，直接继承了18个执行常用持久化操作的方法。
 * 泛型1为仓库操作的领域对象类型，类型2为对应ID属性的类型
 *
 * 只需要定义这个接口，SpringData在程序启动后会自动实现该方法
 */
