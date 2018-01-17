android dp和sp生成工具
将项目打包成jar后 如：dpsp.jar 放在你盘符目录下
执行如下操作:

java -jar E:\dpsp.jar "productpath = E:\\hello.xml" "key = size" "endvalue = 100" "half = true"

productpath :生成文件的路径及名称
key ：指生成xml文件中name的值,自动会在后面跟上sp或dp
endvalue :指需要生成到好多的值,上面即生成0--100之间的值
half ：表示是否生成0.5的值，如：1.5,2.5,....
