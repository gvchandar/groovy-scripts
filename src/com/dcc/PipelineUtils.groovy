package com.dcc
import java.io.*

final class PipelineUtils implements Serializable {
    private script=null
    private static final PipelineUtils instance = new PipelineUtils()
    @NonCPS
    String saveFile(String filename, String text) {
        String PWD = script.pwd()
        String filePath = "${PWD}/${filename}"

        File file = new File(filePath)
        file.text = text
    }
}
