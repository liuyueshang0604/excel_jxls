package com.cn.excel_jxls;

import com.cn.excel_jxls.service.ExportExcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExcelJxlsApplicationTests {

    ExportExcel exportExcel = new ExportExcel();
    @Test
    void contextLoads() throws Exception {
        exportExcel.writeExcel();
    }
    @Test
    void writeExcel1() throws Exception {
        exportExcel.writeExcel1();
    }
}
