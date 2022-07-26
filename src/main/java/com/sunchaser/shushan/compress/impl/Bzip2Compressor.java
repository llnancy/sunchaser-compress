package com.sunchaser.shushan.compress.impl;

import com.sunchaser.shushan.compress.util.IoUtils;
import lombok.SneakyThrows;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 基于bzip2算法实现的压缩与解压缩
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/7/20
 */
public class Bzip2Compressor extends AbstractCompressor {

    /**
     * 将数据进行压缩
     *
     * @param data 原比特数组
     * @return 压缩后的数据
     */
    @SneakyThrows({Throwable.class, Exception.class})
    @Override
    protected byte[] doCompress(byte[] data) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             BZip2CompressorOutputStream bzip2 = new BZip2CompressorOutputStream(bos)) {
            bzip2.write(data);
            return bos.toByteArray();
        }
    }

    /**
     * 将数据解压缩
     *
     * @param data 压缩的数据
     * @return 原数据
     */
    @SneakyThrows({Throwable.class, Exception.class})
    @Override
    protected byte[] doUnCompress(byte[] data) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             BZip2CompressorInputStream unzip = new BZip2CompressorInputStream(new ByteArrayInputStream(data))) {
            IoUtils.copy(unzip, bos);
            return bos.toByteArray();
        }
    }
}
