package com.overall.common.util;

import java.io.OutputStream;
import java.util.Collection;

public interface ExportExcelInterface<T> {
    void exportExcel(String[] headers, Collection<T> dataset, OutputStream out, String pattern) throws Exception;
}
