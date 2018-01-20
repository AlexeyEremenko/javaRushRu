package com.springvalidation.util;

import com.springvalidation.model.entity.Book;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListManager {

    @EJB
    private DBManager dbManager;

    public List<Book> library() {
        if (dbManager.getAllBooks() == null) {return Collections.emptyList();}
        List<Book> list = new ArrayList<Book>();
        list = dbManager.getAllBooks();
        return list;
    }

    int renderedPage() {
        return 0;
    }

    int countPages() {
        return 0;
    }

    List<Book> currentPage = new ArrayList<Book>(10);
}
