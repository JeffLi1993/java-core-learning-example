# equals方法(Java核心技术卷1 p169)

1. 定义: 判断两个对象是否具有相同的引用地址,如果两个对象具有相同的引用,那他们一定是相等的。Java语言规范要求equals方法具有以下特性:

   ```
   1. 自反性:对于任何非空引用x,x.equals(x)应该返回true。
   2. 对称性:对于任何非空引用x和y,当且仅当y.equals(x)返回true,x.equals(y)也应该返回true。
   3. 传递性:对于任何非空引用x、y和z,如果x.equals(y)返回true,y.equals(z)返回true,x.equals(z)也应该返回true。
   4. 一致性:如用x和y引用的对象没有发生变化,反复调用x.equals(y)应该返回同样的结果。
   5. 对于任何非空引用x,x.equals(null)应该返回false。
   ```


2. 完美的equals方法建议:

   ```
   1. 显示参数命名为otherObject,稍后需要将它转成另一个叫做other的变量。
   2. 检测this和otherObject是否引用同一个对象:if(this == otherObject)return true;
   3. 检测otherObject是否为null,如果为null,返回false.这项检测是很必要的。
           if(otherObject == null) reutrn false;
   4. 比较this和otherObject是否属于同一个类。如果equals的语义在每个子类中有所改变,就使用getClass检测:
           if(this.getClass() != otherObject.getClass()) return false;
       如果所有的子类都拥有统一的语义,就使用instanceof检测:
           if(!(otherObject instanceof ClassName) return false;
   5. 将otherObject转换为相应的类类型变量:
           ClassName other = (ClassName)otherObject;
   6. 接下来开始对所有需要比较的属性进行比较了。使用==比较基本类型属性,使用equals比较对象属性,如果所有的属性都匹配,就返回true,否则返回false。
           return field1 == other.field1
           	&& Objects.equals(field2,other.field2);
   7. 如果在子类中重新定义equals方法,就要在其中包含调用super.equals(otherObject);
   ```

# hashCode方法(Java核心技术卷1 p173)

1. 散列码(hash code)是由对象导出的一个整型值。散列码是没有规律的。
2. 如果两个对象使用equals()相等，那么hashCode()也必须相等.如果两个对象的hashCode()相等，这两个对象不一定相等(因为hash会产生碰撞)

# toString()方法(Java核心技术卷1 p175)

1. 用于返回表示对象值的字符串;
2. 强烈建议每个自定义的类覆盖toString()方法;
3. 每个对象都继承了Object的toString()方法,数组类型使用Arrays.toString()方法;多维数组使用					  Arrays.deepToString()方法。


