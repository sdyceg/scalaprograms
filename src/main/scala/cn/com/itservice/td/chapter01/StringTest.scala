package cn.com.itservice.td.chapter01

/**
  * scala String 包装类scala.collection.immutable.WrappedString
  */
object StringTest {


    var str1="String1";
    var str2="String2";
    var age=20;
    //测试字符串的相等性
    println(str1.isInstanceOf[String]);
    println(str1==str2);
    println(str1.eq(str2));
    println(str1.equals(str2));
    println("str1.charAt(2)="+str1.charAt(2));
    println("str1.take(2)="+str1.take(2));
    println("str1*3="+str1*3);
    println("str1++str2="+str1++str2);
    println("str1:+'c' = "+str1:+'w');
//    println(str1===str2);//===比较str1和str2的地址是否相同

    //测试String addString
    //Appends all elements of this wrapped string to a string builder.
    println(str1.contains('S'));
    println(str1.compareToIgnoreCase(str2));
    println(str1.drop(2));

    //新建Array
    var array=new Array[Char](10);
    str1.copyToArray(array);
    for(c <- array){
      print(c);
    }
    println();

    var split=str1.split("");
    println(split);

    println(str1.toUpperCase);
    println(str1.toLowerCase);
    val tocharArray=str1.toCharArray;
    println(tocharArray.isInstanceOf[Array[Char]]);
    println(str1.matches("String1"));
    println(str1.matches("^S.*1$"));
    println(str1.search('i'));
    println(s"this is str1=$str1,and this is str2=$str2");
    println(s"this is show of ${age+2}")
    println(s"hello\nworld");
    //想要避免像\n这种操作符变换成一个换行符的时候，raw插入符是很有用的
    var raw1=raw"hello\nworld";
    println(raw1);

    println(str1.replaceAll("S","helloworld"));
  }
