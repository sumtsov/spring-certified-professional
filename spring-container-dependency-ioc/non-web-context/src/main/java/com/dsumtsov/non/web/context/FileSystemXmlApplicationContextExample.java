package com.dsumtsov.non.web.context;

import com.dsumtsov.non.web.context.beans.SpringBean1;
import com.dsumtsov.non.web.context.beans.SpringBean2;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FileSystemXmlApplicationContextExample {

    public static void main(String[] args) {

        String beansXmlLocationOnFileSystem =
                FileSystemXmlApplicationContextExample.class.getResource("/beans.xml").toExternalForm();

        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(beansXmlLocationOnFileSystem);

        SpringBean1 bean1 = context.getBean(SpringBean1.class);
        SpringBean2 bean2 = context.getBean(SpringBean2.class);

        bean1.test();
        bean2.test();
    }
}
