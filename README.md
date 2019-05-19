# MrZ

解决gradle  "Invalid escape sequence at line 1 column 29 path $[0].name"问题


1. 在项目的gradle.properties中设置
      
      org.gradle.jvmargs='-Dfile.encoding=UTF-8'

2. 降低gradle版本到3.2.1


      将project目录下的build.gradle文件（项目目录下的，不是内层目录下的）中的
       
       dependencies {
       
            classpath ‘com.android.tools.build:gradle:3.X.1’(X>2)
       
       }
       
       
       修改为
       
       dependencies {
       
            classpath ‘com.android.tools.build:gradle:3.2.1’
       
       }
