package org.javacore.base.copy;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-11-16 13:53:51
 *  深拷贝与浅拷贝
 */
class Family implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Student implements Cloneable{
    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CopyT {
    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("Jeff Family");
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff");

        // 浅拷贝
        // 对其对象的引用却没有拷贝
        Student student2 = (Student) student1.clone();
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        System.out.println(student1.getName() + " " + student1.getFamily().getName());
        System.out.println(student2.getName() + " " + student2.getFamily().getName());

        // 深拷贝
//        Student student2 = (Student) student1.clone();
//        student2.setName("Jeff2");
//        student2.getFamily().setName("Jeff2 Family");
//        System.out.println(student1.getName() + " " + student1.getFamily().getName());
//        System.out.println(student2.getName() + " " + student2.getFamily().getName());
    }
}