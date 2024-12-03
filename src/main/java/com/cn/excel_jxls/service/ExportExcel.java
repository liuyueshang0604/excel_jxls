package com.cn.excel_jxls.service;

import com.cn.excel_jxls.entity.Employee;
import org.apache.commons.compress.utils.Lists;
import org.jxls.builder.JxlsOutputFile;
import org.jxls.transform.poi.JxlsPoiTemplateFillerBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ExportExcel {
    private List<Employee> getData() throws ParseException {
        List<Employee> list = Lists.newArrayList();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        list.add(new Employee("张三", formatter.parse("1970-07-10"), new BigDecimal(10000), new BigDecimal(500)));
        list.add(new Employee("王五", formatter.parse("1981-09-21"), new BigDecimal(3000), new BigDecimal(1500)));
        list.add(new Employee("赵茜", formatter.parse("1990-12-19"), new BigDecimal(23000), new BigDecimal(3500)));
        list.add(new Employee("Mal", formatter.parse("1997-11-13"), new BigDecimal(32300), new BigDecimal(3500)));
        list.add(new Employee("Tata", formatter.parse("1988-09-12"), new BigDecimal(3300), new BigDecimal(6500)));
        list.add(new Employee("Youyou", formatter.parse("1967-04-11"), new BigDecimal(300), new BigDecimal(7500)));
        list.add(new Employee("Oleg", formatter.parse("1976-03-10"), new BigDecimal(6000), new BigDecimal(5700)));
        list.add(new Employee("John", formatter.parse("1945-04-10"), new BigDecimal(8000), new BigDecimal(8500)));
        list.add(new Employee("David", formatter.parse("1989-02-10"), new BigDecimal(7000), new BigDecimal(1500)));
        list.add(new Employee("Lily", formatter.parse("1998-01-10"), new BigDecimal(55000), new BigDecimal(6500)));
        list.add(new Employee("Maria", formatter.parse("1999-05-10"), new BigDecimal(3000), new BigDecimal(8500)));
        return list;
    }

    public void writeExcel() throws Exception {
        List<Employee> list = getData();
        Map<String, Object> data = new HashMap<>();
        data.put("employees", list);
        JxlsOutputFile output = new JxlsOutputFile(new File("report.xlsx"));
        JxlsPoiTemplateFillerBuilder.newInstance()
                .withTemplate("template.xlsx")
                .build()
                .fill(data, output);
        OutputStream fos = output.getOutputStream();
        fos.close();
    }

    public void writeExcel1() throws Exception {
        List<Employee> list = getData();
        Map<String, Object> data = new HashMap<>();
        data.put("employees", list);
        data.put("sheetNames",list.stream().map(x->x.getName()).collect(Collectors.toList()));
        JxlsOutputFile output = new JxlsOutputFile(new File("report1.xlsx"));
        JxlsPoiTemplateFillerBuilder.newInstance()
                .withTemplate("template1.xlsx")
                .build()
                .fill(data, output);
        OutputStream fos = output.getOutputStream();
        fos.close();
    }
}
