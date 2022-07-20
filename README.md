# sunchaser-compress

基于`Snappy`、`DEFLATE`、`Gzip`、`bzip2`、`LZ4`及`LZO`等算法实现数据压缩，主要用于`RPC`通讯场景。

# 压缩算法

## `Snappy`

`Snappy`（以前称`Zippy`）是`Google`基于`LZ77`的思路用`C++`语言编写的快速数据压缩与解压程序库，并在`2011`年开源。它的目标并非最大压缩率或与其他压缩程序库的兼容性，而是非常高的速度和合理的压缩率。

## `DEFLATE`

`DEFLATE`是同时使用了`LZ77`算法与哈夫曼编码（`Huffman Coding`）的一个无损数据压缩算法。`JDK`中提供了压缩类`Deflater`和解压类`Inflater`。

## `Gzip`

`Gzip`的基础是`Deflate`。同样`JDK`中也提供了相关的类：`GZIPOutputStream`和`GZIPInputStream`。

## `bzip2`

`bzip2`是`Julian Seward`开发并按照自由软件/开源软件协议发布的数据压缩算法及程序。`bzip2`比传统的`gzip`或者`ZIP`的压缩效率更高，但是压缩速度较慢。

## `LZ4`

`LZ4`是一种无损数据压缩算法，着重于压缩和解压缩速度。它属于面向字节的`LZ77`压缩方案家族。该算法提供一个比`LZO`算法稍差的压缩率——这逊于`Gzip`等算法。但是，它的压缩速度类似`LZO`——比`Gzip`快几倍；而解压速度显著快于`LZO`。

## `LZO`

`LZO`是致力于解压速度的一种数据压缩算法，`LZO`是`Lempel-Ziv-Oberhumer`的缩写。这个算法是无损算法，参考实现程序是线程安全的。
