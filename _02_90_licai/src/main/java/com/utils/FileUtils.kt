package com.utils

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream

class FileUtils {

    companion object {

        public fun getFromFile(path : String): String {
            val resourceAsStream = FileUtils.javaClass.getResourceAsStream(path)
            val os = ByteOutputStream();

            val len: Int = 1024 * 8;
            val ba: ByteArray = ByteArray(len)
            var size: Int = 0

            size = resourceAsStream.read(ba)

            while ((size) != -1) {
                os.write(ba, 0, size)
                size = resourceAsStream.read(ba)
            }

            resourceAsStream.close();

            os.flush()
            val data: String = os.toString()
            os.close()
            return data
        }
    }



}
