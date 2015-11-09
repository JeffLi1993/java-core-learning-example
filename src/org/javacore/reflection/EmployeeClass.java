package org.javacore.reflection;

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
 * @since 2015-11-9 10:45:19
 * 反射在继承中的案例
 */
class Employee {
    private String name;
    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}
public class EmployeeClass {
    public static void main(String[] args) {
        Employee employee = new Employee("Jeff");
        Employee manager = new Manager("Boss");
        System.out.println(employee.getClass().getName() + " " + employee.getName());
        System.out.println(manager.getClass().getName() + " " + manager.getName());
    }
}
