package com.service

import com.utils.FileUtils
import java.util.*

class ChengfenService {


    fun findSame(file1 : String , file2 : String) : List<String> {
        var data = FileUtils.getFromFile(file1);
        val chengfen1s = data.split("\n");


        data = FileUtils.getFromFile(file2);
        val chengfen2s = data.split("\n");


//        for (chengfen in chengfen1s) {
//            val a1 = chengfen.replace(" ", "");
//            for (chengfen2 in chengfen2s) {
//                val a2 = chengfen2.replace(" ", "");
//                if (a1.equals(a2) && !a1.startsWith("成分券名称")) {
//                    System.out.println(chengfen)
//                }
//            }
//        }

        return findSame(chengfen1s, chengfen2s)
    }


    fun findSame(chengfen1s : List<String> , chengfen2s : List<String>) : List<String> {
        val r = ArrayList<String>()
        for (chengfen in chengfen1s) {
            val a1 = chengfen.replace(" ", "");
            for (chengfen2 in chengfen2s) {
                val a2 = chengfen2.replace(" ", "");
                if (a1.equals(a2) && !a1.startsWith("成分券名称")) {
//                    System.out.println(chengfen)
                    r.add(chengfen)
                }
            }
        }

        return r
    }



}