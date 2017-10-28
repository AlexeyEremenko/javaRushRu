
//They kept saying, "Hail, King of the Jews!" and they kept slapping him. (John 19:3)


package com.javarush.task.task20.task2011;

/* 
Externalizable для апартаментов
*/

import java.io.*;
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
        
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.address);
            out.writeInt(this.year);
            out.close();
        }
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String)in.readObject();
            this.year = in.readInt();
            in.close();
        }
    }

    public static void main(String[] args) {

    }
}
/*
Externalizable для апартаментов
Реализуй интерфейс Externalizable в классе Apartment.


Требования:
1. Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
2. В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
3. В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
4. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
5. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
6. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
7. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.

package com.javarush.task.task20.task2011;

* 
Externalizable для апартаментов
*
public class Solution {

    public static class Apartment {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) {

    }
}
*/
