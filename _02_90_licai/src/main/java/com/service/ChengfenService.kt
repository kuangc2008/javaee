package com.service

import com.utils.FileUtils

class ChengfenService {


    fun findSame(file1 : String , file2 : String) {
        var data = FileUtils.getFromFile(file1);
        val chengfen1s = data.split("\n");


        data = FileUtils.getFromFile(file2);
        val chengfen2s = data.split("\n");


        for (chengfen in chengfen1s) {
            for (chengfen2 in chengfen2s) {
                if (chengfen.equals(chengfen2) && !chengfen.startsWith("成分券名称")) {
                    System.out.println(chengfen)
                }
            }
        }

    }
}